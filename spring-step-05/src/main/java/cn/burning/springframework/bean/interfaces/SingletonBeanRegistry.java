package cn.burning.springframework.bean.interfaces;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 单例Bean对象注册（表接口）
 * @Date 2022/11/17 23:04
 */
public interface SingletonBeanRegistry {

    /**
     * 注册单例对象
     * @param beanName          Bean对象名称
     * @param singletonObject   单例Bean对象
     */
    void registerSingleton(String beanName, Object singletonObject);


    /**
     * 返回在给定名称下注册的（原始）单例对象。
     * @param beanName 要查找的bean的名称
     * @return 返回注册的单例对象
     */
    Object getSingleton(String beanName);
}
