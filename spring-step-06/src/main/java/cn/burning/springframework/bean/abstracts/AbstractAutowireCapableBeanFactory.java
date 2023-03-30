package cn.burning.springframework.bean.abstracts;

import cn.burning.springframework.bean.impl.CglibSubclassingInstantiationStrategy;
import cn.burning.springframework.bean.interfaces.InstantiationStrategy;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.bean.support.BeanReference;
import cn.burning.springframework.bean.support.PropertyValue;
import cn.burning.springframework.bean.support.PropertyValues;
import cn.burning.springframework.exception.BeansException;
import cn.hutool.core.bean.BeanUtil;

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
     * 实现Bean的实例化操作
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            // 创建Bean实例对象
            bean = createBeanInstance(beanDefinition, beanName, args);
            // add-04  属性添加、给Bean填充属性
            applyPropertyValues(beanDefinition, beanName, bean);
        } catch (Exception e) {
            throw new BeansException("create bean failed", e);
        }
        //注册单例bean
        registerSingleton(beanName, bean);
        return bean;
    }

    /**
     * 创建对象功能又做了扩充
     * 补充Bean属性信息。当遇到Bean属性为Bean对象时，需要递归处理。
     * 最后在属性填充时需要用到反射操作
     * @param beanDefinition
     * @param beanName
     * @param bean
     */
    private void applyPropertyValues(BeanDefinition beanDefinition, String beanName, Object bean){
        try {
            //获取属性集合（注意原来beanDefinition中的构造函数别忘记添加propertyValues属性）
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            //遍历属性集合中的属性
            for (PropertyValue pv : propertyValues.acquirePropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    // 获取 value 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        // 获取到你所有的构造函数
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : constructors) {
            //循环比对出构造函数集合与入参信息args的匹配情况,这里简单只是一个数量对比
            //实际Spring源码中还需要比对入参类型，否则相同数量不同入参类型的情况，就会抛异常了。
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        // cglib策略调用，创建对象的实例化
        return this.getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }


}
