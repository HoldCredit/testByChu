package com.test.sample.controller;

import com.test.sample.dto.userdto.RegisterFormDto;
import com.test.sample.dto.userdto.UpdateFormDto;
import com.test.sample.dto.userdto.UserInfoDto;
import com.test.sample.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 회원 등록
    @PostMapping
    public ResponseEntity<UserInfoDto> registerUser(@RequestBody @Valid RegisterFormDto dto) {
        UserInfoDto user = userService.registerUser(dto);

//        return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // 회원 정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoDto> findUser(@PathVariable Long userId) {
        UserInfoDto user = userService.findUser(userId);
        return new ResponseEntity<>(user, OK);
    }

    // 회원 수정
    @PostMapping("/{userId}")
    public ResponseEntity<UserInfoDto> updateUser(@PathVariable Long userId, @RequestBody @Valid UpdateFormDto dto) {
        UserInfoDto user = userService.updateUser(userId, dto);
        return new ResponseEntity<>(user, OK);
    }

    // 회원 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable Long userId) {
        userService.removeUser(userId);
        return new ResponseEntity<>(NO_CONTENT);
    }


}
