package com.test.sample.service.userservice;

import com.test.sample.domain.User;
import com.test.sample.dto.userdto.RegisterFormDto;
import com.test.sample.dto.userdto.UpdateFormDto;
import com.test.sample.dto.userdto.UserInfoDto;
import com.test.sample.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
/**
 * @Transactional(readOnly = true)
 * 모두 반영되거나 모두 반영되지 말아야 함 => 무결성
 * 읽기만 가능 => 불변성
 * 수정을 하고 싶다면 메소드에 @Transactional 재작성
 */
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;

    // 회원 등록
    @Override
    @Transactional
    public UserInfoDto registerUser(RegisterFormDto dto) {
        User user = new User(dto.getUserId(), dto.getPassword(), dto.getEmail(), dto.getAddress());
        userRespository.save(user);
        return new UserInfoDto(user.getUserId(), user.getEmail(), user.getAddress());
    }

    // 회원 정보 조회
    @Override
    public UserInfoDto findUser(Long userId) {
        User user = userRespository.findById(userId).get();
        UserInfoDto userInfoDto = new UserInfoDto(user.getUserId(), user.getEmail(), user.getAddress());
        return userInfoDto;
    }

    // 회원 수정
    @Override
    @Transactional
    public UserInfoDto updateUser(Long userId, UpdateFormDto dto) {
        User user = userRespository.findById(userId).get();
        user.updateUser(dto.getPassword(), dto.getEmail(), dto.getAddress());
        return new UserInfoDto(user.getUserId(), user.getEmail(), user.getAddress());
    }

    // 회원 삭제
    @Override
    @Transactional
    public void removeUser(Long userId) {
        User user = userRespository.findById(userId).get();
        userRespository.delete(user);
    }


}
