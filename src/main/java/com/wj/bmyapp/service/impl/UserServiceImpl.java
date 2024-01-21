package com.wj.bmyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.bmyapp.domain.User;
import com.wj.bmyapp.exception.BusinessException;
import com.wj.bmyapp.req.LoginReq;
import com.wj.bmyapp.req.RegisterReq;
import com.wj.bmyapp.resp.BaseResponse;
import com.wj.bmyapp.resp.LoginResp;
import com.wj.bmyapp.service.UserService;
import com.wj.bmyapp.mapper.UserMapper;
import com.wj.bmyapp.utils.ResultUtil;
import com.wj.bmyapp.utils.TokenGenerator;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author WinX PRO
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-01-21 16:09:35
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public BaseResponse<LoginResp> login(LoginReq loginReq, HttpSession httpSession) {
        String account = loginReq.getAccount();
        String password = loginReq.getPassword();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount, account).eq(User::getPassword, password);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new BusinessException("账号或密码错误");
        }
        LoginResp loginResp = new LoginResp();
        String token = TokenGenerator.generateToken();
        loginResp.setToken(token);
        httpSession.setAttribute(token, user);
        log.info("登入成功");
        return ResultUtil.success(loginResp, "登入成功");

    }

    @Override
    public BaseResponse<String> register(RegisterReq registerReq) {

        String account = registerReq.getAccount();
        String password = registerReq.getPassword();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount, account);
        Long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException("账号已存在");
        }

        userMapper.insert(new User(account, password));
        log.info("注册成功");
        return ResultUtil.success("注册成功");

    }
}




