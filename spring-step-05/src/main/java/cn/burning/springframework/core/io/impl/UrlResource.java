package cn.burning.springframework.core.io.impl;

import cn.burning.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author 会游泳的蚂蚁
 * @Description: URL加载资源  add-05
 * @Date 2022/11/22 21:59
 */
public class UrlResource implements Resource {

    /**
     * 通过 HTTP 的方式读取云服务的文件
     */
    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException e) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection) con).disconnect();
            }
            throw e;
        }
    }
}
