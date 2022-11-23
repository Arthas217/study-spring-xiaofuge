package cn.burning.springframework.bean.interfaces;


import cn.burning.springframework.bean.support.BeanDefinition;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean 定义注册（接口）
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
}
