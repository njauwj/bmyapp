package com.wj.bmyapp.controller;

import com.wj.bmyapp.req.LoginReq;
import com.wj.bmyapp.req.RegisterReq;
import com.wj.bmyapp.resp.BaseResponse;
import com.wj.bmyapp.resp.LoginResp;
import com.wj.bmyapp.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wj
 * @create_time 2024/1/21
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public BaseResponse<LoginResp> login(@RequestBody LoginReq loginReq, HttpSession httpSession) {
        return userService.login(loginReq, httpSession);
    }

    @PostMapping("/register")
    public BaseResponse<String> register(@RequestBody RegisterReq registerReq) {
        return userService.register(registerReq);
    }

}
