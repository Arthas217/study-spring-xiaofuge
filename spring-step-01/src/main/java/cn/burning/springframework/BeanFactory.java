package cn.burning.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 简单的bean工厂
 * @Date 2022/11/16 22:19
 */
public class BeanFactory {

    /**
     * spring bean容器
     * 目前简单理解为HashMap为容器（可以存储数据的数据结构称为容器）
     */
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * bean注册
     * @param name bean名称
     * @param beanDefinition bean定义
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }

    /**
     * bean获取
     * @param name
     * @return
     */
    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

}
