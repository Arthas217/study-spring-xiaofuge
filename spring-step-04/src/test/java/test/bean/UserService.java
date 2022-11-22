package test.bean;

/**
 * @description 模拟用户服务类
 */
public class UserService {

    private String uId;

    /**
     * 平常开发经常使用的场景。在 UserService 中注入 UserDao，这样就能体现出Bean属性的依赖了
     */
    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
