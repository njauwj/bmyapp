package com.wj.bmyapp;

import com.wj.bmyapp.domain.User;
import com.wj.bmyapp.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class BmyappApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));
    }

}
