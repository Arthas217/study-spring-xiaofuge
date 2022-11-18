package cn.burning.springframework;

/**
 * @description 模拟含有入参构造函数的用户 Bean 对象
 */
public class UserService {

    private String name;


    /**
     * add-03
     * @param name
     */
    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(name);
        return sb.toString();
    }

}
