package com.training.memberweb.service;

import com.training.memberweb.Member;

import java.util.List;

public interface MemberService {
    Member create (Member member);
    Member findById (String id);
    List<Member> findAll ();
    Member update (Member member);
    Member delete (String id);
}
