package cn.burning.springframework;

/**
 * @Author 会游泳的蚂蚁
 * @Description: Bean(对象)定义
 * @Date 2022/11/16 22:18
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }
}
