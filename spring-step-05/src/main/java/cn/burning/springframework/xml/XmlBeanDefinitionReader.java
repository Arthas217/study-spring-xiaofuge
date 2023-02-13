package cn.burning.springframework.xml;

import cn.burning.springframework.bean.abstracts.AbstractBeanDefinitionReader;
import cn.burning.springframework.bean.interfaces.BeanDefinitionRegistry;
import cn.burning.springframework.bean.support.BeanDefinition;
import cn.burning.springframework.bean.support.BeanReference;
import cn.burning.springframework.bean.support.PropertyValue;
import cn.burning.springframework.core.io.Resource;
import cn.burning.springframework.core.io.ResourceLoader;
import cn.burning.springframework.exception.BeansException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 会游泳的蚂蚁
 * @Description: XML方式Bean定义读取,核心类
 * @Date 2022/11/23 22:56
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    /**
     * 构造函数 + bean定义注册
     * 依赖BeanDefinitionRegistry
     * @param registry
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * 构造函数 + bean定义注册 + 资源加载
     * 依赖BeanDefinitionRegistry、ResourceLoader
     * @param registry
     * @param resourceLoader
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 核心处理资源加载、主要负责解析xml
     * @param resource
     * @throws BeansException
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        InputStream inputStream;
        try {
            inputStream = resource.getInputStream();
            //依赖getRegistry方法的注册
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        //依赖加载ResourceLoader
        ResourceLoader resourceLoader = super.getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }


    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    /**
     * 对xml的读取 XmlUtil.readXML(inputStream) 和元素 Element 解析
     * 解析的过程中通过循环操作，以此获取 Bean配置以及配置中的 id、name、class、value、ref 信息。
     * @param inputStream
     * @throws ClassNotFoundException
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) {continue;}
            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {continue;}
            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {continue;}
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {continue;}
                // 解析标签：property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            // 通过BeanDefinitionRegistry判断是否为重复注册
            if (super.getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 通过BeanDefinitionRegistry注册BeanDefinition
            // 把读取出来的配置信息，创建成BeanDefinition以及PropertyValue，最终把完整的Bean定义内容注册到Bean容器
            super.getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
