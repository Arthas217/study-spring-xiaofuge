package cn.burning.springframework.bean.abstracts;

import cn.burning.springframework.bean.interfaces.BeanDefinitionReader;
import cn.burning.springframework.bean.interfaces.BeanDefinitionRegistry;
import cn.burning.springframework.core.io.ResourceLoader;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 抽象Bean定义读取基类
 * 此抽象类只实现此类职责：加载和注册（没有实现xml解析）
 * @Date 2022/11/23 22:30
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 依赖--->资源加载
     */
    private ResourceLoader resourceLoader;

    /**
     * 依赖--->注册
     */
    private final BeanDefinitionRegistry registry;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

}
