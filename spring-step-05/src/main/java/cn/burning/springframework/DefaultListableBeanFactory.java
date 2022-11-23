package cn.burning.springframework;

import cn.burning.springframework.bean.abstracts.AbstractAutowireCapableBeanFactory;
import cn.burning.springframework.bean.interfaces.BeanDefinitionRegistry;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 默认的Bean工厂实现类（核心实现类）
 * 此类继承了AbstractAutowireCapableBeanFactory 类，也就具备了接口 BeanFactory 和 AbstractBeanFactory 等一连串的功能实现。
 * 所以有时候你会看到一些类的强转，调用某些方法（例如此类中createBean方法），也是因为你强转的类实现接口或继承了某些类。
 *
 * 此类中涉及的BeanDefinitionRegistry接口定义了注册，AbstractBeanFactory抽象类定义了获取，都集中在beanDefinitionMap里
 * @Date 2022/11/17 22:41
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * spring bean容器  且依赖BeanDefinition
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 注册bean定义
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 获取bean定义
     * 只需要关心属于自己相关内容，获取bean定义（基类的基类）---实现了抽象方法1
     * @param beanName  Bean 名称
     * @return
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named " + beanName + " is defined");
        }
        return beanDefinition;
    }


    /**
     * add-05
     * @param beanName
     * @return
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
}
