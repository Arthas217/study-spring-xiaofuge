package cn.burn.springframework.test.common;

import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.bean.support.PropertyValue;
import cn.burning.springframework.bean.support.PropertyValues;
import cn.burning.springframework.exception.BeansException;
import cn.burning.springframework.ext.BeanFactoryPostProcessor;
import cn.burning.springframework.todo.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor 实例化 Bean 对象之前，修改 BeanDefinition 属性
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
