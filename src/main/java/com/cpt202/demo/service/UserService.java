package com.CPT202.fitnessB19.service;

import com.CPT202.fitnessB19.repository.UserRepo;
import com.CPT202.fitnessB19.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    // 假设有一个服务来处理验证码的验证
    private final VerificationCodeService verificationCodeService;

    @Autowired
    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder, VerificationCodeService verificationCodeService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationCodeService = verificationCodeService;
    }

    public boolean isPhoneRegistered(String phone) {
        return userRepository.findByPhone(phone) != null;
    }

    public boolean verifyVerificationCode(String verificationCode) {
        return verificationCodeService.verifyCode(verificationCode);
    }

    public boolean verifyInvitationCode(String invitationCode) {
        // 这里的实现会依赖于如何处理和存储邀请码
        // 假设有一个方法来检查邀请码的有效性
        return invitationCodeService.verifyInvitationCode(invitationCode);
    }

    public boolean registerNewUser(String name, String phone, String password, String role, String invitationCode) {
        if(isPhoneRegistered(phone)) {
            return false;
        }
        
        // 创建用户实例
        User newUser = new User();
        newUser.setName(name);
        newUser.setPhone(phone);
        newUser.setPassword(passwordEncoder.encode(password)); // 加密密码
        newUser.setRole(role); // 假设角色已经是正确的格式

        // 如果邀请码不为空，则设置邀请码
        if (invitationCode != null && !invitationCode.isEmpty()) {
            newUser.setInvitationCode(invitationCode);
        }

        // 保存用户到数据库
        try {
            userRepository.save(newUser);
            return true;
        } catch (Exception e) {
            // 处理异常，可能是数据库问题，也可能是其他问题
            // 这里应该记录日志或做进一步的异常处理
            return false;
        }
    }

    // 其他方法...
}
