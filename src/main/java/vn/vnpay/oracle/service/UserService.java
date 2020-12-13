package vn.vnpay.oracle.service;

import vn.vnpay.oracle.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> listUser(Map inParam);
}
