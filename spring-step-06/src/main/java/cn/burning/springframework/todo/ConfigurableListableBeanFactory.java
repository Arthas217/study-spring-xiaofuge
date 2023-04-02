package cn.burning.springframework.todo;

import cn.burning.springframework.bean.interfaces.AutowireCapableBeanFactory;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

/**
 * 提供分析和修改Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory{

    /**
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /**
     * add-06
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;
}
