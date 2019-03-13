package com.training.memberweb.controller;

import com.training.memberweb.Member;
import com.training.memberweb.model.ApiKey;
import com.training.memberweb.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Member findById (@PathVariable("idMember") Long id){
        return memberService.findById(id);
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> findAll(ApiKey apiKey){
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
    public Member delete (@PathVariable("idMember") Long id){
        return memberService.delete(id);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public String hello (ApiKey apiKey){
        return "Hello World";
    }

}
