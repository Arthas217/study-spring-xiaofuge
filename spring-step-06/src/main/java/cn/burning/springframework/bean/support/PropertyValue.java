package cn.burning.springframework.bean.support;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 属性实体
 * @Date 2022/11/22 16:35
 */
public class PropertyValue {

    /** 属性名称 */
    private final String name;

    /** 属性值 */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
