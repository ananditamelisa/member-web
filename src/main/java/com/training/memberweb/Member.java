package com.training.memberweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="members")
public class Member {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberID;
    private String name;

    //@Column(unique=true)
    private String email;
    private String phoneNumber;
    private String address;
}
