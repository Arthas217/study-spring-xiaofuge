package cn.burning.springframework.core.io.impl;

import cn.burning.springframework.core.io.Resource;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 类路径方式加载资源   add-05
 * @Date 2022/11/22 22:00
 */
public class ClassPathResource implements Resource {

    /**类路径*/
    private final String path;

    /**类加载器*/
    private ClassLoader classLoader;


    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        //使用hutool工具获取类加载器
        this.classLoader = classLoader != null ? classLoader : ClassUtil.getClassLoader();
//        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        //通过ClassLoader 读取ClassPath下的文件信息.
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }
}
