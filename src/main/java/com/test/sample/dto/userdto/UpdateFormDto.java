package com.test.sample.dto.userdto;

import com.test.sample.domain.Address;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UpdateFormDto {
    // 회원수정 폼에 맞게 dto 작성

    @Size(min = 6, message = "6자리 이상")
    @NotEmpty(message = "빈칸이면 안됨")
    private String password;

    @Email(message = "잘못된 메일임 ㅇㅇ")
    @NotEmpty(message = "빈칸이면 안됨")
    private String email;

    private Address address;
}
