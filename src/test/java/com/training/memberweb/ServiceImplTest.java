package com.training.memberweb;

import com.training.memberweb.Repository.MemberRepository;
import com.training.memberweb.service.MemberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ServiceImplTest {
    private MemberServiceImpl memberService;
    private MemberRepository memberRepository;

    @Before
    public void setUp() throws Exception {
        memberRepository = Mockito.mock(MemberRepository.class);
        memberService = new MemberServiceImpl(memberRepository);
    }

    @Test
    public void testCreate(){
        Member member = new Member(1L, "Anandita Melisa", "dita@yahoo.com",
                "0813849095803", "Jalan Seruni");
        Mockito.when(memberRepository.save(member)).thenReturn(member);
        Member result = memberService.create(member);
        Assert.assertTrue(result!=null);
        Assert.assertTrue(member.getMemberID().equals(result.getMemberID()));

        Mockito.verify(memberRepository, Mockito.times(1)).save(member);
    }

    @Test
    public void testFindById(){
        Member member = new Member(1L, "Anandita Melisa", "dita@yahoo.com",
                "0813849095803", "Jalan Seruni");
        Mockito.when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        Mockito.when(memberRepository.findById(2L)).thenReturn(Optional.empty());

        Member result1 = memberService.findById(1L);
        Assert.assertTrue(result1!=null);

        Member result2 = memberService.findById(2L);
        Assert.assertTrue(result2==null);

        Mockito.verify(memberRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(memberRepository, Mockito.times(1)).findById(2L);
    }

    @Test
    public void testFindAll(){
        Member member = new Member(1L, "Anandita Melisa", "dita@yahoo.com",
                "0813849095803", "Jalan Seruni");
        Member member2 = new Member(2L, "Gilang Rabbani", "gilang@yahoo.com",
                "083208598237", "Jalan Seruni");
        Mockito.when(memberRepository.save(member)).thenReturn(member);
        memberService.create(member);
        Mockito.when(memberRepository.save(member2)).thenReturn(member2);
        memberService.create(member2);

        Mockito.when(memberRepository.findAll()).thenReturn(Arrays.asList(member,member2));
        List<Member> all = memberService.findAll();

        Assert.assertTrue("total member 2 orang", all.size()==2);
        Assert.assertEquals("data pertama harus berupa object member", member, all.get(0));
    }

    @Test
    public void testUpdate(){
        Member member = new Member(1L, "Anandita Melisa", "dita@yahoo.com",
                "0813849095803", "Jalan Seruni");
        Mockito.when(memberRepository.save(member)).thenReturn(member);
        memberService.create(member);

        member.setName("Dita");
        Mockito.when(memberRepository.findById(member.getMemberID())).thenReturn(Optional.ofNullable(member));
        Mockito.when(memberRepository.save(member)).thenReturn(member);
        Member update = memberService.update(member);

        Assert.assertNotNull("member ketika di update harus nya mereturn object yg diupdate",update);
    }

    @Test
    public void testDelete(){
        Member member = new Member(1L, "Anandita Melisa", "dita@yahoo.com",
                "0813849095803", "Jalan Seruni");
        Mockito.when(memberRepository.save(member)).thenReturn(member);
        memberService.create(member);
        Mockito.when(memberRepository.findById(member.getMemberID())).thenReturn(Optional.ofNullable(member));
        Member deleted = memberService.delete(member.getMemberID());

        Assert.assertTrue(member==deleted);
        Assert.assertTrue(memberRepository.count()==0L);
    }
}
