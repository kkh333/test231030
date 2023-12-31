package org.example.member.cotroller;

import org.example.Container;
import org.example.member.entity.Member;
import org.example.member.service.MemberService;

public class MemberController {
    long id = 0;

    MemberService memberService = new MemberService();

    public void signUp() {
        if (Container.getLoginedMember() != null) {
            System.out.println("현재 로그인 상태 입니다.");
            return;
        }

        String userId;
        String userPassWord;
        String userPassWordConfirm;
        while (true) {
            System.out.println("아이디를 입력해 주세요.");
            userId = Container.getSc().nextLine().trim();

            Member member = this.memberService.getMemberfindByUserId(userId);

            if (member != null) {
                System.out.println("중복된 아이디입니다.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("비밀번호를 입력해 주세요.");
            userPassWord = Container.getSc().nextLine().trim();
            System.out.println("비밀번호를 한 번 더 입력해 주세요.");
            userPassWordConfirm = Container.getSc().nextLine().trim();

            if (userPassWord.equals(userPassWordConfirm) == false) {
                System.out.println("비밀번호를 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        id++;

        try {
            this.memberService.join(id, userId, userPassWord);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(userId + "님 회원가입이 완료되었습니다.");
    }

    public void userList() {
        if (memberService.getMembersSize() == 0) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }
        System.out.println("번호 / 가입일 / 아이디 / 비밀번호");
        System.out.println("----------------------");
        this.memberService.getAllMemberList();
    }

    public void login() {
        if (Container.getLoginedMember() != null) {
            System.out.println("현재 로그인 상태 입니다.");
            return;
        }

        System.out.printf("아이디 : ");
        String userId = Container.getSc().nextLine().trim();
        System.out.printf("비밀번호 : ");
        String userPassword = Container.getSc().nextLine().trim();

        Member member = this.memberService.getMemberfindByUserId(userId);

        if (member == null) {
            System.out.println("존재하는 아이디가 없습니다.");
            return;
        }

        if (member.getUserPassword().equals(userPassword) == false) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }

        Container.setLoginedMember(member);
        System.out.println(member.getUserId() + "님 반갑습니다. 로그인이 완료되었습니다.");
    }

    public void logout() {
        if (Container.getLoginedMember() == null) {
            System.out.println("현재 로그인 상태가 아닙니다.");
            return;
        }

        Container.setLoginedMember(null);
        System.out.println("로그아웃이 완료되었습니다.");
    }

}
