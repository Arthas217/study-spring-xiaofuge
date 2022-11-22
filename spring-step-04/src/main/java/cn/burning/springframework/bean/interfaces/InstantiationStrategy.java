package cn.burning.springframework.bean.interfaces;

import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean实例化策略（接口）
 * @Date 2022/11/18 11:19
 */
public interface InstantiationStrategy {

    /**
     * 实例化
     * @param beanDefinition
     * @param beanName
     * @param ctor 必要的类信息  拿到符合入参信息相对应的构造函数
     * @param args 具体的入参信息，最终实例化时候会用到
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
