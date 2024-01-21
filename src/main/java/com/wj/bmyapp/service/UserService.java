package com.wj.bmyapp.service;

import com.wj.bmyapp.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wj.bmyapp.req.LoginReq;
import com.wj.bmyapp.req.RegisterReq;
import com.wj.bmyapp.resp.BaseResponse;
import com.wj.bmyapp.resp.LoginResp;
import jakarta.servlet.http.HttpSession;

/**
* @author WinX PRO
* @description 针对表【user】的数据库操作Service
* @createDate 2024-01-21 16:09:35
*/
public interface UserService extends IService<User> {

    BaseResponse<LoginResp> login(LoginReq loginReq, HttpSession httpSession);

    BaseResponse<String> register(RegisterReq registerReq);
}
