package com.test.sample.dto.boarddto;

import com.test.sample.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class postBoardDto {

    private String title;
    private String content;
    private User user;

}
