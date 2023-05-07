package com.test.sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator( name = "USER_SEQ_GENERATOR",
                    sequenceName = "USER_SEQ", //매핑할 데이터베이스 시퀀스 이름
                    initialValue = 1, allocationSize = 1)
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "USER_SEQ_GENERATOR")
    private Long userNo;

    @Column(unique = true)
    private String userId;

    @JsonIgnore
    private String password;

    private String email;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.USER;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();


    // 회원가입 : dto -> entity
    public User(String userId, String password, String email, Address address) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    // 회원수정 : dto -> entity
    public void updateUser(String password, String email, Address address) {
        this.password = password;
        this.email = email;
        this.address = address;
    }

    @PrePersist
    public void prePersist() {
        LocalDate joinDate = LocalDate.now();
        int sequenceNumber = 1; // joinDate 날짜에 해당하는 일련번호를 DB에서 가져오도록 구현해야 함
        this.userNo = Long.valueOf(joinDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + String.format("%04d", sequenceNumber));
    }
}
