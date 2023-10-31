package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;


public class WiseSayingController {
    long wiseSayingNum = 1;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public void write() {
        System.out.printf("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("작가 : ");
        String author = Container.getSc().nextLine().trim();
        System.out.println(wiseSayingNum + "번 명언이 등록되었습니다.");
        WiseSaying wiseSaying = new WiseSaying(wiseSayingNum, content, author, Container.getLoginedMember().getUserId());
        wiseSayings.add(wiseSaying);
        wiseSayingNum++;
    }

    public void list() {
        if (wiseSayings.size() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }
        System.out.println("번호 / 작가 / 명언 / 작성자");
        System.out.println("----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent(), wiseSaying.getWriter());
        }
    }

    public void remove() {
        if (wiseSayings.size() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }

        System.out.println("삭제할 번호를 입력해 주세요.");
        long inputNum = Integer.parseInt(Container.getSc().nextLine().trim());

        WiseSaying wiseSaying = this.findById(inputNum);

        if (wiseSaying == null) {
            System.out.println("해당 번호의 명언이 존재하지않습니다.");
        } else {
            if (wiseSaying.getWriter().equals(Container.getLoginedMember().getUserId())) {
                wiseSayings.remove(wiseSaying);
                System.out.println(inputNum + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println("글 작성자만 삭제가 가능합니다.");
            }
        }
    }

    public void modify() {
        if (wiseSayings.size() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }

        System.out.println("수정할 번호를 입력해 주세요.");
        long inputNum = Integer.parseInt(Container.getSc().nextLine().trim());

        WiseSaying wiseSaying = this.findById(inputNum);

        if (wiseSaying == null) {
            System.out.println("해당 번호의 명언이 존재하지않습니다.");
        } else {
            if (wiseSaying.getWriter().equals(Container.getLoginedMember().getUserId())) {
                System.out.println("기존 명언 : " + wiseSaying.getContent());
                String content = Container.getSc().nextLine().trim();
                wiseSaying.setContent(content);
                System.out.println("기존 작가 : " + wiseSaying.getAuthor());
                String author = Container.getSc().nextLine().trim();
                wiseSaying.setAuthor(author);
                System.out.println(inputNum + "번 명언이 수정되었습니다.");
            } else {
                System.out.println("글 작성자만 수정이 가능합니다.");
            }
        }
    }

    public WiseSaying findById(long inputNum) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            if (wiseSaying.getId() == inputNum) {
                return wiseSaying;
            }
        }
        return null;
    }
}
