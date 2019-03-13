package com.training.memberweb.service;

import com.training.memberweb.Member;
import com.training.memberweb.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {


    private MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private ArrayList<Member> list = new ArrayList<>();
    @Override
    public Member create(Member member) {
       memberRepository.save(member);
       return member;
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else{
            return null;
        }
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member update(Member member) {
        Optional<Member> byId = memberRepository.findById(member.getMemberID());
        if(byId.isPresent()){
            return memberRepository.save(member);
        }else{
            return null;
        }
    }

    @Override
    public Member delete(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        if(byId.isPresent()){
            Member m = byId.get();
            memberRepository.delete(byId.get());
            return m;
        }else{
            return null;
        }
    }
}
