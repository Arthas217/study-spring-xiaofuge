package cn.burning.springframework.bean.interfaces;


import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean定义注册
 * @Date 2022/11/17 21:58
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册BeanDefinition
     * @param beanName Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


    /**
     * 判断是否包含指定名称的BeanDefinition  add-05
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);




    /**
     * Return the names of all beans defined in this registry.
     * add-06
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();


    /**
     * 使用Bean名称查询BeanDefinition
     * add-06
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
