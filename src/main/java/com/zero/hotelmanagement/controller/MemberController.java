package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.pojo.Member;
import com.zero.hotelmanagement.service.MemberService;
import com.zero.hotelmanagement.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("getMember")
    @ResponseBody
    HashMap<String,Object> getMember(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Member> memberList=memberService.getMembers(Integer.parseInt(page));
        int count=memberService.countAllMembers();
        map.put("count",count);
        map.put("List",memberList);
        return map;
    }

    @RequestMapping("delMember")
    @ResponseBody
    public HashMap<String,Object> delMember(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelMember:ID:"+id);
        boolean isSuccess= memberService.deleteMember(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addMember")
    @ResponseBody
    public HashMap<String,Object> addMember(Member member)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddMember:"+member);
        boolean isSuccess=memberService.insertMember(member)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("editMember")
    @ResponseBody
    public HashMap<String,Object> editMember(Member member)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateMember:"+member);
        boolean isSuccess=memberService.updateMember(member)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchMemberById")
    @ResponseBody
    HashMap<String,Object> searchMemberById(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Member> memberList=memberService.selectMemberById(Integer.parseInt(id));
        map.put("List",memberList);
        return map;
    }

    @RequestMapping("searchMemberByName")
    @ResponseBody
    HashMap<String,Object> searchMemberByName(String name)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Member> memberList=memberService.selectMembersByName(name);
        map.put("List",memberList);
        return map;
    }
}
