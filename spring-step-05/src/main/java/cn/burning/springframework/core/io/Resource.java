package cn.burning.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 资源 add-05
 * @Date 2022/11/22 21:54
 */
public interface Resource {

    /**
     * 提供获取InputStream流的方法
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
