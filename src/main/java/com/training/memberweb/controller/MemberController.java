package com.training.memberweb.controller;

import com.training.memberweb.Member;
import com.training.memberweb.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member m){
        return memberService.create(m);
    }

    @RequestMapping(
            value = "/members/{idMember}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member findById (@PathVariable("idMember") String id){
        return memberService.findById(id);
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @RequestMapping(
            value = "/members/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member update (@RequestBody  Member m){
        return memberService.update(m);
    }

    @RequestMapping(
            value = "/members/delete/{idMember}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete (@PathVariable("idMember") String id){
        return memberService.delete(id);
    }


}
