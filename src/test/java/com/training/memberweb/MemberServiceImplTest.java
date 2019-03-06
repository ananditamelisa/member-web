package com.training.memberweb;

import com.training.memberweb.service.MemberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemberServiceImplTest {
    private MemberServiceImpl service;
    @Before
    public void setUp() throws Exception{
        service = new MemberServiceImpl();
    }

    @Test
    public void testCreate(){
        Member member = new Member("1", "Anandita", "dita.lisaira@gmail.com",
                "081268170048", "Karawaci");
        service.create(member);
        Assert.assertTrue("Total member nharus ada 1", service.findAll().size()==1 );
        Member temp = service.findById("1");
        Assert.assertTrue("Member harus ada", member==temp );
    }

    @Test
    public void testFindById(){
        Member member = service.findById("kosong");
        Assert.assertTrue("Member harus null", member==null);
        Member temp = service.create(new Member("1", "Anandita", "dita.lisaira@gmail.com",
                "081268170048", "Karawaci"));
        member = service.findById("1");
        Assert.assertTrue("member dgn id 1 hrs ada", temp==member);
    }

    @Test
    public void testUpdate(){
        service.create(new Member("1", "Anandita", "dita.lisaira@gmail.com",
                "081268170048", "Karawaci"));
        service.update(new Member("1", "Melisa Humaira", "ananditalsr@gmail.com",
                "081268170048", "Karawaci"));
        Member member = service.findById("1");
        Assert.assertTrue("nama dan email member harus berubah", member.getName().equals("Melisa Humaira")
        && member.getEmail().equals("ananditalsr@gmail.com"));
    }

    @Test
    public void testDelete(){
        service.create(new Member("1", "Anandita", "dita.lisaira@gmail.com",
                "081268170048", "Karawaci"));
        service.create(new Member("2", "Gilang", "gilang@gmail.com",
                "081234567884", "Karawaci"));
        service.create(new Member("3", "Melisa", "melisa@gmail.com",
                "081943905895", "Karawaci"));
        service.create(new Member("4", "Rabbani", "rabban.i@gmail.com",
                "08120520083", "Karawaci"));
        service.delete("3");
        Assert.assertTrue("total member harus 3", service.findAll().size()==3);
        Assert.assertTrue("member ke3 harusnya gaada", service.findById("3")==null);
    }
}
