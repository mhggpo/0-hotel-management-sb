package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.dao.MemberDao;
import com.zero.hotelmanagement.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberDao memberDao;

    @Autowired(required = false)
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public List<Member> getMembers(Integer page) {
        return memberDao.getMembers(6*(page-1));
    }

    @Override
    public int deleteMember(Integer memberId) {
        return memberDao.deleteMember(memberId);
    }

    @Override
    public int insertMember(Member Member) {
        return memberDao.insertMember(Member);
    }

    @Override
    public int updateMember(Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public List<Member> selectAllMember() {
        return memberDao.selectAllMember();
    }

    @Override
    public List<Member> selectMemberById(Integer memberId) {
        return memberDao.selectMemberById(memberId);
    }

    @Override
    public List<Member> selectMembersByName(String memberName) {
        return memberDao.selectMembersByName(memberName);
    }

    @Override
    public int countAllMembers() {
        return memberDao.countAllMembers();
    }
}
