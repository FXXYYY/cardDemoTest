package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.domains.User;
import com.demo.service.UserService;
import com.demo.service.UserService;
import com.demo.util.CommunicationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/12 14:47
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("getUser")
    public CommunicationData getUser(@RequestBody User pojo) {
        return userService.selectUser(pojo);
    }

    @PutMapping("addUser")
    public CommunicationData addUser(@RequestBody User debitCard) {
        return userService.addUser(debitCard);
    }


    @PostMapping("updateUser")
    public CommunicationData updateUser(@RequestBody User debitCard) {
        return userService.updateUser(debitCard);
    }


}