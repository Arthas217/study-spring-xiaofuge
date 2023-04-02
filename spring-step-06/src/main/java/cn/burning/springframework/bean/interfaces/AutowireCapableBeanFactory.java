package cn.burning.springframework.bean.interfaces;

import cn.burning.springframework.bean.interfaces.BeanFactory;
import cn.burning.springframework.exception.BeansException;

/**
 * @Author 会游泳的蚂蚁
 * @Description:  自动化处理Bean工厂配置的接口
 * @Date 2022/11/24 10:40
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     * add-06
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     * add-06
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
