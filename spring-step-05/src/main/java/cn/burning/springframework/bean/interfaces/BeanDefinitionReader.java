package cn.burning.springframework.bean.interfaces;

import cn.burning.springframework.core.io.Resource;
import cn.burning.springframework.core.io.ResourceLoader;
import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: bean定义读取  add-05
 * 前面两个方法（加载和注册），前面两个方法的实现会包装到抽象类AbstractBeanDefinitionReader中，以免污染具体的接口实现方法。
 * 用于提供给后面三个加载Bean定义的方法
 *
 * @Date 2022/11/23 22:17
 */
public interface BeanDefinitionReader {

    /**
     * 获取资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     * 获取Bean定义注册器
     */
    BeanDefinitionRegistry getRegistry();


    /**
     * 通过资源处理（加载、解析、注册到spring容器）
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 通过location处理（加载、解析、注册到spring容器）
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 多个资源
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;


}
