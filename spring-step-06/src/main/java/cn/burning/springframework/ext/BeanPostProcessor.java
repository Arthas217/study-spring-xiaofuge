package cn.burning.springframework.ext;


import cn.burning.springframework.exception.BeansException;

/**
 * 用于修改新实例化 Bean 对象的扩展点   add-06
 * 允许自定义修改新bean实例的工厂钩子，例如。检查标记接口或用代理包装它们。
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
