package cn.burning.springframework.bean.support;

/**
 * @Author 会游泳的蚂蚁
 * @Description:  Bean对象定义
 * @Date 2022/11/17 17:27
 */
public class BeanDefinition {

    private Class beanClass;

    /**
     * 属性集合 add-04
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        //注意add04 不添加会报空指针异常
        this.propertyValues = new PropertyValues();
    }

    /**
     * add-04 把属性一定交给 Bean的构造函数
     * @param beanClass
     * @param propertyValues
     */
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        // 避免后面for循环时还得判断属性填充是否为空。
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    /**
     * getBeanClass方法名称为了区分BeanFactory中getBean方法
     * @return
     */
    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
