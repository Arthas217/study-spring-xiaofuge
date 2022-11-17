package cn.burning.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 通用的单例bean注册表实现类
 * @Date 2022/11/17 23:13
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
}
