package cn.burning.springframework.context;


import cn.burning.springframework.exception.BeansException;

/**
 * SPI接口配置应用上下文  add-06
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * 需要在上下文的实现中完成刷新容器的操作过程。
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
