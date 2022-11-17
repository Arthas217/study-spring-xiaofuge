package cn.burning.springframework;

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
}
