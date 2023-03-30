package cn.burning.springframework.bean.impl;

import cn.burning.springframework.bean.interfaces.InstantiationStrategy;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: JDK策略实例化
 * @Date 2022/11/18 11:30
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            // 判断ctor是否为空，如果为空则是无构造函数实例化，否则就是需要有构造函数的实例化。
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("SimpleInstantiationStrategy Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
