package cn.burning.springframework;

/**
 * @Author 会游泳的蚂蚁
 * @Description:  Bean对象定义
 * @Date 2022/11/17 17:27
 */
public class BeanDefinition {

    private Class beanClass;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * getBeanClass方法名称为了区分BeanFactory中getBean方法
     * @return
     */
    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
