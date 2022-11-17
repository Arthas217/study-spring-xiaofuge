package cn.burning.springframework;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 自定义Bean异常
 * @Date 2022/11/17 17:34
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
