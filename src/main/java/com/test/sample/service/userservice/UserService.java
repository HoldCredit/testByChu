package com.test.sample.service.userservice;

import com.test.sample.dto.userdto.UpdateFormDto;
import com.test.sample.dto.userdto.RegisterFormDto;
import com.test.sample.dto.userdto.UserInfoDto;

public interface UserService {

    // 회원 등록
    UserInfoDto registerUser(RegisterFormDto dto);

    // 회원 정보 조회
    UserInfoDto findUser(Long userId);

    // 회원 수정
    UserInfoDto updateUser(Long userId, UpdateFormDto dto);

    // 회원 삭제
    void removeUser(Long userId);


}
