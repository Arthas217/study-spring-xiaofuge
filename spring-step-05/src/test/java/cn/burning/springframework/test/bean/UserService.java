package cn.burning.springframework.test.bean;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 模拟用户服务类
 * @Date 2022/11/24 10:03
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
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
