package cn.burning.springframework.bean.abstracts;

import cn.burning.springframework.bean.impl.DefaultSingletonBeanRegistry;
import cn.burning.springframework.bean.interfaces.BeanFactory;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.exception.BeansException;
import cn.burning.springframework.ext.BeanPostProcessor;
import cn.burning.springframework.todo.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 抽象Bean工厂基类
 * 定义模板方法  统一收口通用核心方法的调用逻辑和标准定义,控制了后续的实现者不用关心调用逻辑,按照统一方式执行(模板模式的设计方式)
 * @Date 2022/11/17 21:43
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements
//        BeanFactory {
        ConfigurableBeanFactory { //add-06


    /**
     * 返回Bean的实例对象
     * @param name 要检索的bean的名称
     * @param args 构造函数入参
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    /**
     * add-05 返回指定泛型的对象 实现BeanFactory接口
     * @param name  要检索的bean的名称
     * @param requiredType 类型
     * @param <T>
     * @return
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }


    protected <T> T doGetBean(final String name, final Object[] args) {
        //通过继承DefaultSingletonBeanRegistry 具备了单例Bean的注册功能。
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T) singleton;
        }
        //并没有自身的去实现这些方法，而是只定义了调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应实现。
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }


    /**
     * 抽象方法1
     * 通过bean名称，获取bean定义
     * 在子类DefaultListableBeanFactory实现
     * @param beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);


    /**
     * add-03 抽象方法2 创建bean（实例化）
     * 在子类AbstractAutowireCapableBeanFactory实现
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args);



    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }


    /**
     * add-06 这个报错太隐蔽了，找了半天
     * @param name 要检索的bean的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

}
