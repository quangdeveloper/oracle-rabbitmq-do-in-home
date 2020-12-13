package vn.vnpay.oracle.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vnpay.oracle.config.RedisService;
import vn.vnpay.oracle.dao.UserDAO;
import vn.vnpay.oracle.model.User;
import vn.vnpay.oracle.service.UserService;
import vn.vnpay.oracle.util.GsonUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<User> listUser(Map inParam) {
        try {
            Map<String, Object> result = userDAO.getList(inParam);
            List<Map> list = (List) result.get("RS");

            List<User> users = new ArrayList<>();
            for (Map mapResult : list) {

                if (mapResult instanceof Map) {
                    User user = new User();
                    user.convertUser(mapResult);
                    users.add(user);
                    redisService.setKey(user.getId().toString(), user);
                    System.out.println(user.getId());

                    if (!redisService.hasKey(user.getId().toString())) {
                        int i = 0;
                        while (i < 3) {
                            redisService.setKey(user.getId().toString(), user);
                            i++;
                        }
                    }

                    if (redisService.hasKey(user.getId().toString())) {
                        rabbitTemplate.convertAndSend("route-one", GsonUtil.toJson(user));
                    }
                }
            }
            return users;
        } catch (CloneNotSupportedException | SQLException exq) {
            return null;
        }
    }
}
