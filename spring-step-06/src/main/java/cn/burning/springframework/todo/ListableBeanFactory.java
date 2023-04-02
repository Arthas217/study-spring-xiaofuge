package cn.burning.springframework.todo;

import cn.burning.springframework.bean.interfaces.BeanFactory;
import cn.burning.springframework.exception.BeansException;

import java.util.Map;

/**
 *  add-05
 *  扩展Bean工厂接口的接口(Spring源码中还有其他扩展方法)
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回Bean实例  add-05
     * toThink 枚举所有的bean实例，匹配所有类型的bean总是尽可能按照后端配置中定义的顺序返回bean名称和相应的bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
