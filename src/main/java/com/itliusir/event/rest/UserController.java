package com.itliusir.event.rest;

import com.itliusir.event.biz.UserBiz;
import com.itliusir.event.entity.Coupon;
import com.itliusir.event.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Test
 *
 * @author liugang
 * @since 2018-08-28
 */
@RestController
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @GetMapping("/register")
    public String register() throws Exception {
        User user = new User();
        user.setId("1");
        user.setMobile("110");
        user.setName("tom");
        user.setPwd("123456");
        userBiz.register(user);
        return "success";
    }

    @GetMapping("user/{userId}")
    public User getUser(@PathVariable String userId) throws Exception {
        return userBiz.getUser(userId);
    }

    @GetMapping("coupon/{userId}")
    public List<Coupon> getCoupon(@PathVariable String userId) throws Exception {
        return userBiz.getCoupon(userId);
    }
}
