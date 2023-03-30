package cn.burning.springframework.context;


import cn.burning.springframework.todo.ListableBeanFactory;

/**
 * 应用上下文接口  add-06
 * 扩展出一系列应用上下文的抽象实现类
 * 并最终完成ClassPathXmlApplicationContext类的实现。而这个类就是最后交给用户使用的类。
 */
public interface ApplicationContext extends ListableBeanFactory {
}
