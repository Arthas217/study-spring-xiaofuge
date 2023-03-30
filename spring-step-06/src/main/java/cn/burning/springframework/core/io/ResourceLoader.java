package cn.burning.springframework.core.io;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 资源加载器 add-05
 * @Date 2022/11/23 21:55
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     * 按照资源加载的不同方式，把不同方式集中到统一的类服务下进行资源加载，外部用户只需要传递资源地址即可
     * @param location 地址
     * @return
     */
    Resource getResource(String location);
}
