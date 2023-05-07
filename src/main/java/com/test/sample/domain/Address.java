package com.test.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor //@Embeddable 기본생성자 필수
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String detail;

}
