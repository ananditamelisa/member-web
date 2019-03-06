package com.training.memberweb.service;

import com.training.memberweb.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberServiceImpl implements MemberService {
    private ArrayList<Member> list = new ArrayList<>();
    @Override
    public Member create(Member member) {
        list.add(member);
        return member;
    }

    @Override
    public Member findById(String id) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getMemberID().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return list;
    }

    @Override
    public Member update(Member member) {
        Member mb = findById(member.getMemberID());
        if(mb==null) return null;
        list.set(list.indexOf(mb), member);
        return member;
    }

    @Override
    public Member delete(String id) {
        Member mb = findById(id);
        if(mb==null) return null;
        list.remove(findById(id));
        return mb;
    }
}
