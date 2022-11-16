package cn.burning.springframework;

import cn.burning.springframework.bean.UserService;
import org.junit.Test;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 测试BeanFactory类
 * @Date 2022/11/16 22:26
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
