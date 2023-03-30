package cn.burning.springframework.todo;

import cn.burning.springframework.bean.interfaces.SingletonBeanRegistry;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口
 * @Date 2022/11/24 10:42
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
