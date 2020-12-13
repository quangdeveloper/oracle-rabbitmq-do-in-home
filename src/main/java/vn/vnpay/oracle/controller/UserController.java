package vn.vnpay.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.oracle.config.RedisService;
import vn.vnpay.oracle.model.User;
import vn.vnpay.oracle.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @GetMapping
    public ResponseEntity<Object> getListUser(){
        Map map = new HashMap();
        List<User> users = userService.listUser(map);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id){
       Object user = redisService.getKey(id.toString());
        return ResponseEntity.ok(user);
    }
}
