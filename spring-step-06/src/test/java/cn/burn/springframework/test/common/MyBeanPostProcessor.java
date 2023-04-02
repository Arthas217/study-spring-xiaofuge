package cn.burn.springframework.test.common;


import cn.burning.springframework.exception.BeansException;
import cn.burning.springframework.ext.BeanPostProcessor;
import cn.burn.springframework.test.bean.UserService;

/**
 * BeanPostProcessor 在 Bean 对象执行初始化方法前后进行扩展
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
