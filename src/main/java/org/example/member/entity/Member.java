package org.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Member {
    private long id;
    private String regDate;
    private String userId;
    private String userPassword;

    public Member(long id, String userId, String userPassword, String regDate) {
        this.id = id;
        this.regDate = regDate;
        this.userId = userId;
        this.userPassword = userPassword;
    }
}

