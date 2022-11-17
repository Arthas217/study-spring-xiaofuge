package cn.burning.springframework;

import org.junit.Test;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2022/11/17 23:58
 */
public class ApiTest {

    @Test
    public void testSpringBean(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService2 = (UserService)beanFactory.getBean("userService");
        userService2.queryUserInfo();

    }
}
