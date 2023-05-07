package com.test.sample.dto.userdto;

import com.test.sample.domain.Address;
import lombok.Data;

@Data
public class UserInfoDto {

    private String userId;
    private String email;
    private Address address;

    public UserInfoDto(String userId, String email, Address address) {
        this.userId = userId;
        this.email = email;
        this.address = address;
    }
}
