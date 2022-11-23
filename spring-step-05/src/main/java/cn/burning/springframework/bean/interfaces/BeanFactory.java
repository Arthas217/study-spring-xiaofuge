package cn.burning.springframework.bean.interfaces;


import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean工厂（接口）
 * @Date 2022/11/17 17:29
 */
public interface BeanFactory {



    /**
     * 构造函数的入参信息传递进去
     * 返回含构造函数的 Bean 实例对象
     * 重载了一个含有入参信息 args
     * @param name 要检索的bean的名称
     * @param args 构造函数入参
     * @return 实例化的Bean对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name, Object... args) throws BeansException;
}
