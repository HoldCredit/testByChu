package com.test.sample.dto.userdto;

import com.test.sample.domain.Address;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegisterFormDto {
    // 회원가입 폼에 맞게 dto 작성

    @NotEmpty(message = "빈칸이면 안됨")
    private String userId;

    @Size(min = 6, message = "6자리 이상")
    @NotEmpty(message = "빈칸이면 안됨")
    private String password;

    @Email(message = "잘못된 메일임 ㅇㅇ")
    @NotEmpty(message = "빈칸이면 안됨")
    private String email;

    private Address address;

    /**
     * validation 참고
     * @Sizemin = 6, message = "6자리 이상") : 문자열 6자리 이상
     * @Min(value = 6, message = "최소 6자 이상") : 숫자 6자리 이상
     * @Max : 숫자에 사용
     *
     */

}
