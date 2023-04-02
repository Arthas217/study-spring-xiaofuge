package cn.burning.springframework.ext;

import cn.burning.springframework.exception.BeansException;
import cn.burning.springframework.todo.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改 BeanDefinition 属性信息 add-06
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * 允许自定义修改应用程序上下文的bean定义，调整上下文底层bean工厂的bean属性值。
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
