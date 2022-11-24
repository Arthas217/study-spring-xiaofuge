package cn.burning.springframework.test;

import cn.burning.springframework.test.bean.UserService;
import cn.burning.springframework.DefaultListableBeanFactory;
import cn.burning.springframework.core.io.Resource;
import cn.burning.springframework.core.io.impl.DefaultResourceLoader;
import cn.burning.springframework.xml.XmlBeanDefinitionReader;
import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 测试
 * @Date 2022/11/24 10:05
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    /**
     * 资源加载
     */
    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

//    @Test
//    public void test_url() throws IOException {
//        Resource resource = resourceLoader.getResource("https://github.com/Arthas217/study-spring-xiaofuge/tree/master/spring-step-05/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }


    /**
     * 通过xml资源加载、解析、注册bean到容器中
     */
    @Test
    public void test_xml_bean() {
        // 1.初始化BeanFactory (实现了BeanDefinitionRegistry)
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件 &&注册Bean
        // 替换step-04测试中 UserDao注册、UserService注册 && 设置属性[uId、userDao]、UserService注入bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取Bean对象   替换step-04测试中 UserService 获取bean
        UserService userService = beanFactory.getBean("userService", UserService.class);
        // 4. 调用方法
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
