package org.example.member.repository;

import org.example.member.entity.Member;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<Member> members = new ArrayList<>();

    public MemberRepository() {
        Member user1 = new Member(0,"ㄱ","ㄱ", Util.nowDateTime());
        members.add(user1);
        Member user2 = new Member(0,"ㄴ","ㄴ", Util.nowDateTime());
        members.add(user2);
    }

    public Member getMemberfindByUserId(String userId) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getUserId().equals(userId)) {
                return member;
            }
        }
        return null;
    }

    public long getMembersSize() {
        return members.size();
    }

    public void join(long id, String userId, String userPassword) {
        Member member = new Member(id, userId, userPassword, Util.nowDateTime());
        members.add(member);
    }

    public void getAllMemberList() {
        for (int i = members.size() - 1; i >= 0; i--) {
            Member member = members.get(i);
            System.out.printf("%d / %s / %s / %s\n", member.getId(), member.getRegDate(), member.getUserId(), member.getUserPassword());
        }
    }
}
