package com.pallidamors.memo.user.service;

import com.pallidamors.memo.common.MD5HashingEncoder;
import com.pallidamors.memo.common.SHA256HashiEncoder;
import com.pallidamors.memo.user.domain.User;
import com.pallidamors.memo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

    //final : 한번 값이 저장되면 다른 값이 지정 X
    private final UserRepository userRepository;

    //다른 생성자가 없이 Autowired를 위한 생성자만 있는 경우 @Autowired 생략가능
    //@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(
              String loginId
            , String password
            , String name
            , String email) {

         String encodePassword = SHA256HashiEncoder.encode(password);

        int count = userRepository.insertUser(loginId, encodePassword, name, email);

        if (count == 1) {
            return true;
        }else{
            return false;
        }
    }


    public User getUser(String loginId, String password) {
        String encodedPassword = SHA256HashiEncoder.encode(password);

        return userRepository.selectUser(loginId, encodedPassword);
    }

}
