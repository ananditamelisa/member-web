package com.training.memberweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String memberID;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
