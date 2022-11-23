package cn.burning.springframework.bean.interfaces;

import cn.burning.springframework.core.io.Resource;
import cn.burning.springframework.core.io.ResourceLoader;
import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: bean定义读取简单接口  add-05
 * 前面两个方法（加载和注册），用于提供给后面三个加载Bean定义的方法
 * 前面两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
 * @Date 2022/11/23 22:17
 */
public interface BeanDefinitionReader {

    /**
     * 获取加载资源
     */
    ResourceLoader getResourceLoader();

    /**
     * Bean定义注册
     */
    BeanDefinitionRegistry getRegistry();


    /**
     * 通过资源加载Bean定义（加载、解析、注册到spring容器），所以实现类中要依赖加载和注册
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 通过资源加载Bean定义（加载、解析、注册到spring容器）实现类中要依赖加载
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;


}
