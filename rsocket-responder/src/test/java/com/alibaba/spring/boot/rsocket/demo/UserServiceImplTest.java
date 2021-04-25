package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    public void testFindById() throws Exception {
        System.out.println(userService.findById(1).block());
    }
}
