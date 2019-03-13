package com.training.memberweb;

import com.training.memberweb.Repository.MemberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    private Member m, m2, m3, create, create2, create3, updated;

    @Before
    public void setUp() throws Exception {
        m = new Member();
        m.setAddress("Jalan Seruni");
        m.setEmail("dita.lisaira@gmail.com");
        m.setName("Anandita Melisa");
        m.setPhoneNumber("081268170048");

        create = memberRepository.save(m);

        m2 = new Member();
        m2.setAddress("Ubud");
        m2.setEmail("inge.shalvya@gmail.com");
        m2.setName("Shalvey Inge");
        m2.setPhoneNumber("08120849205");

        create2 = memberRepository.save(m2);

        m3 = new Member();
        m3.setAddress("Karawaci");
        m3.setEmail("gilangR@gmail.com");
        m3.setName("Gilang Rabbani");
        m3.setPhoneNumber("081285073028");

        create3 = memberRepository.save(m3);
    }

    @Test
    public void testFindAll(){
        Assert.assertTrue("harusnya total member ada 3", memberRepository.findAll().size()==3);
    }
    @Test
    public void testCreate(){
        Assert.assertTrue("yg di insert harus sama dgn yg di create", m==create);

    }
    @Test
    public void testUpdate(){
        m2 = new Member();
        m2.setMemberID(create.getMemberID());
        m2.setName("Anandita Melisa Humaira");
        m2.setAddress("Karawaci");
        m2.setEmail("ananditalsr@gmail.com");
        m2.setPhoneNumber("081268170048");
        updated = memberRepository.save(m2);

        Assert.assertTrue("member harus terupdate",
                updated.getMemberID()==create.getMemberID());

    }

    @Test
    public void testFindById(){
        Optional<Member> byId = memberRepository.findById(create3.getMemberID());
        if(byId.isPresent()){
            Assert.assertTrue("harusnya member m3 bisa ketemu",
                    byId.get().getName().equals("Gilang Rabbani"));
        }
    }

    @Test
    public void testDelete(){
        memberRepository.deleteById(create2.getMemberID());
        Assert.assertFalse("harusnya skrg id dari creat2 udh gaada",
                memberRepository.existsById(create2.getMemberID()));
    }

//    @Test
//    public void testFindByEmail(){
//        memberRepository.findByEmail("gilangR@gmail.com");
//
//    }

}
