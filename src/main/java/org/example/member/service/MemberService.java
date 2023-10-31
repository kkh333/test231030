package org.example.member.service;

import org.example.member.entity.Member;
import org.example.member.repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();

    public Member getMemberfindByUserId(String userId) {
        return this.memberRepository.getMemberfindByUserId(userId);
    }

    public long getMembersSize() {
        return this.memberRepository.getMembersSize();
    }

    public void join(long id, String userId, String userPassword) {
        this.memberRepository.join(id, userId, userPassword);
    }

    public void getAllMemberList() {
        this.memberRepository.getAllMemberList();
    }
}
