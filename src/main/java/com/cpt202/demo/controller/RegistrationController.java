package com.CPT202.fitnessB19.controller;

import com.CPT202.fitnessB19.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // 定义了基础路径
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String confirm_password,
            @RequestParam String verification_code,
            @RequestParam String role,
            @RequestParam(required = false) String invitation_code // 假设邀请码是可选的
    ) {
        // 基本输入验证
        if (!password.equals(confirm_password)) {
            return ResponseEntity.badRequest().body("两次输入的密码不匹配！");
        }
        if (!userService.verifyVerificationCode(verification_code)) {
            return ResponseEntity.badRequest().body("验证码错误！");
        }
        if (userService.isPhoneRegistered(phone)) {
            return ResponseEntity.badRequest().body("此电话号码已注册！");
        }
        if (invitation_code != null && !userService.verifyInvitationCode(invitation_code)) {
            return ResponseEntity.badRequest().body("邀请码无效！");
        }

        // 注册逻辑，这里调用UserService的方法进行注册
        boolean registrationSuccess = userService.registerNewUser(name, phone, password, role, invitation_code);

        // 检查注册是否成功
        if (registrationSuccess) {
            return ResponseEntity.ok("注册成功！");
        } else {
            return ResponseEntity.badRequest().body("注册失败，请重试！");
        }
    }
    
    // 其他方法...
}
