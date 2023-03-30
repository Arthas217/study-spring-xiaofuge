package cn.burning.springframework.context;


import cn.burning.springframework.exception.BeansException;

/**
 * SPI接口配置应用上下文  add-06
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition to the application context client methods in the
 * {@link cn.burning.springframework.context.ApplicationContext} interface.
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
