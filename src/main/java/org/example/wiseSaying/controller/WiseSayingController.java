package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.service.WiseSayingService;

public class WiseSayingController {
    long wiseSayingNum = 1;

    WiseSayingService wiseSayingService = new WiseSayingService();

    public void write() {
        System.out.printf("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("작가 : ");
        String author = Container.getSc().nextLine().trim();
        System.out.println(wiseSayingNum + "번 명언이 등록되었습니다.");
        if (Container.getLoginedMember() == null) {
            this.wiseSayingService.write(wiseSayingNum, content, author, "비회원");
        }
        else {
            this.wiseSayingService.write(wiseSayingNum, content, author, Container.getLoginedMember().getUserId());
        }
        wiseSayingNum++;
    }

    public void list() {
        if (wiseSayingService.getWiseSayingListSize() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }
        System.out.println("번호 / 작가 / 명언 / 작성자");
        System.out.println("----------------------");
        this.wiseSayingService.getWiseSayingList();
    }

    public void remove() {
        if (wiseSayingService.getWiseSayingListSize() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }

        System.out.println("삭제할 번호를 입력해 주세요.");
        long inputNum = Integer.parseInt(Container.getSc().nextLine().trim());

        WiseSaying wiseSaying = this.wiseSayingService.getWiseSayingfindById(inputNum);

        if (wiseSaying == null) {
            System.out.println("해당 번호의 명언이 존재하지않습니다.");
        }
        else if (wiseSaying.getWriter().equals("비회원")) {
            System.out.println("비회원 글은 삭제할 수 없습니다.");
        }
        else {
            this.wiseSayingService.remove(wiseSaying);
        }
    }

    public void modify() {
        if (wiseSayingService.getWiseSayingListSize() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }

        System.out.println("수정할 번호를 입력해 주세요.");
        long inputNum = Integer.parseInt(Container.getSc().nextLine().trim());

        WiseSaying wiseSaying = this.wiseSayingService.getWiseSayingfindById(inputNum);

        if (wiseSaying == null) {
            System.out.println("해당 번호의 명언이 존재하지않습니다.");
        }
        else if (wiseSaying.getWriter().equals("비회원")) {
            System.out.println("비회원 글은 수정할 수 없습니다.");
        }
        else {
            this.wiseSayingService.modify(wiseSaying);
        }
    }
}
