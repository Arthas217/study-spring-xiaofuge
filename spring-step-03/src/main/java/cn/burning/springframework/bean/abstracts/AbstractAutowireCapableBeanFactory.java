package cn.burning.springframework.bean.abstracts;

import cn.burning.springframework.bean.impl.CglibSubclassingInstantiationStrategy;
import cn.burning.springframework.bean.interfaces.InstantiationStrategy;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 只需要关心属于自己相关内容--实现默认bean创建的抽象bean工厂超类
 * 类名的翻译：自动的有能力的BeanFactory，实例化Bean类，把Bean的实例化操作放到容器中处理
 * Spring Bean容器的实现类，不同特性类的使用就可以非常好的隔离开类的功能职责和作用范围。
 * @Date 2022/11/17 23:37
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    /**
     * step-01 实现了Bean的实例化操作
     * 实现了抽象方法2
     * @param beanName
     * @param beanDefinition
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            // 获取Bean实例对象， 埋下一个坑，有构造函数入参的对象怎么处理
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("create bean failed", e);
        }
        //继承父类的父类
        registerSingleton(beanName, bean);
        return bean;
    }


    /**
     * add-03
     * 创建cglib策略属性类
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    /**
     * add-03
     * 实现了Bean的实例化操作
     * 实现了add-03 抽象方法2
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            // 获取Bean实例对象处理
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("create bean failed", e);
        }
        //继承父类的父类
        registerSingleton(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        // 获取到你所有的构造函数
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : constructors) {
            //循环比对出构造函数集合与入参信息args的匹配情况,这里简单只是一个数量对比，实际Spring源码中还需要比对入参类型，否则相同数量不同入参类型的情况，就会抛异常了。
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        // cglib策略调用，创建对象的实例化
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }


}
