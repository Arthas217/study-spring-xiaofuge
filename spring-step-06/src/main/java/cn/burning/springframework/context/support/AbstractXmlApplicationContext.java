package cn.burning.springframework.context.support;


import cn.burning.springframework.DefaultListableBeanFactory;
import cn.burning.springframework.xml.XmlBeanDefinitionReader;

/**
 * 抽象基类XML上下文
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    /**
     * 上下文中对配置信息的加载
     * 处理了关于 XML 文件配置信息的操作。
     * @param beanFactory
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 从入口上下文类，拿到配置信息的地址描述。
     * @return
     */
    protected abstract String[] getConfigLocations();

}
