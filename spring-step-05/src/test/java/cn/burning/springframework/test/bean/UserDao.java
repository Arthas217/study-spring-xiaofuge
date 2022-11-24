package cn.burning.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 模拟用户Dao
 * @Date 2022/11/24 10:02
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "得到哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
