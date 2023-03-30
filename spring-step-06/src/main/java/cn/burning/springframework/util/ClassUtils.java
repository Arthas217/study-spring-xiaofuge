package cn.burning.springframework.util;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 类加载器工具  add-05
 * @Date 2022/11/23 21:33
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (null == cl) {
            // use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
