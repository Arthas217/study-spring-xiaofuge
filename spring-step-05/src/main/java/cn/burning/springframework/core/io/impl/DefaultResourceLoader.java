package cn.burning.springframework.core.io.impl;

import cn.burning.springframework.core.io.Resource;
import cn.burning.springframework.core.io.ResourceLoader;
import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 默认的实现资源处理器  add-05
 * 设计模式约定的具体结果: 不会让外部调用放知道过多的细节，而是仅关心具体调用结果即可。
 * @Date 2022/11/23 22:00
 */
public class DefaultResourceLoader implements ResourceLoader {

    /**
     * @param location 地址
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        //把三种不同类型的资源处理方式进行了包装
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
