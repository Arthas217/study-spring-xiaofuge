package cn.burning.springframework.bean.abstracts;

import cn.burning.springframework.bean.impl.DefaultSingletonBeanRegistry;
import cn.burning.springframework.bean.interfaces.BeanFactory;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 抽象Bean工厂基类
 * 定义模板方法  统一收口通用核心方法的调用逻辑和标准定义,控制了后续的实现者不用关心调用逻辑,按照统一方式执行(模板模式的设计方式)
 * @Date 2022/11/17 21:43
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 返回Bean的实例对象
     * @param name 要检索的bean的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        //通过继承DefaultSingletonBeanRegistry 具备了单例Bean的注册功能。
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return singleton;
        }
        //并没有自身的去实现这些方法，而是只定义了调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应实现。
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }


    /**
     * 抽象方法1
     * @param beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 抽象方法2
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

}
