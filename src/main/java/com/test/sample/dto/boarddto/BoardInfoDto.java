package com.test.sample.dto.boarddto;

import com.test.sample.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardInfoDto {

    private Long id;
    private String title;
    private String content;
    private User user;
    private Date lastModifiedDate;

}
