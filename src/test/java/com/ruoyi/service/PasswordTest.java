package com.ruoyi.service;


import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.utils.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)
public class PasswordTest {
    @Test
    public void encryptPassword() {
        String newPassword = "admin123";
        System.out.println("newPassword = " + SecurityUtils.encryptPassword(newPassword));

    }
}
