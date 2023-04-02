package cn.burning.springframework.context.support;

import cn.burning.springframework.bean.DefaultListableBeanFactory;
import cn.burning.springframework.exception.BeansException;
import cn.burning.springframework.todo.ConfigurableListableBeanFactory;

/**
 * 抽象基类刷新应用上下文
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;


    @Override
    protected void refreshBeanFactory() throws BeansException {
        //获取了DefaultListableBeanFactory 的实例化
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        //对资源配置的加载操作
        //完成对spring.xml配置文件中Bean对象的定义和注册
        //也包括实现了接口BeanFactoryPostProcessor、BeanPostProcessor的配置Bean信息。？？
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /**
     * 获取Bean工厂
     * @return
     */
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
