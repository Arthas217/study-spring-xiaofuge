package cn.burning.springframework.todo;

import cn.burning.springframework.bean.interfaces.BeanFactory;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Sub-interface implemented by bean factories that can be part of a hierarchy.
 * 一种扩展工厂的层次子接口
 * 在Spring源码中它提供了可以获取父类 BeanFactory 方法
 * @Date 2022/11/24 10:37
 */
public interface HierarchicalBeanFactory extends BeanFactory {
}
