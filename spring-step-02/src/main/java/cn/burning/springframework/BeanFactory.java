package cn.burning.springframework;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean工厂（接口）
 * @Date 2022/11/17 17:29
 */
public interface BeanFactory {

    /**
     * 返回Bean的实例对象
     * @param name  要检索的bean的名称
     * @return 实例化的Bean对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name) throws BeansException;
}
