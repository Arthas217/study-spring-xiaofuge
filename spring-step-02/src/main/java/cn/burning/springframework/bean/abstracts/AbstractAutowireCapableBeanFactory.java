package cn.burning.springframework.bean.abstracts;

import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 只需要关心属于自己相关内容--实现默认bean创建的抽象bean工厂超类
 * @Date 2022/11/17 23:37
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 实现了Bean的实例化操作
     * 实现了抽象方法2
     * @param beanName
     * @param beanDefinition
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("create bean failed", e);
        }
        //继承父类的父类
        registerSingleton(beanName, bean);
        return bean;
    }
}
