package cn.burning.springframework.bean.support;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 属性值集合
 * @Date 2022/11/22 16:35
 */
public class PropertyValues {

    /**
     * 因为属性可能会有很多
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }


    public PropertyValue[] acquirePropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValueByName(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}
