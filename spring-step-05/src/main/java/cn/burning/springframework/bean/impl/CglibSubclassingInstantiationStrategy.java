package cn.burning.springframework.bean.impl;

import cn.burning.springframework.bean.interfaces.InstantiationStrategy;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Cglib策略实例化
 * @Date 2022/11/18 11:40
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            //空操
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor){
           return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
