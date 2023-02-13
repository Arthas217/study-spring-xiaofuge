package cn.burning.springframework.bean.support;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean引用
 * bean属性中除了基本类型外，还有引用
 * @Date 2022/11/22 16:40
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
