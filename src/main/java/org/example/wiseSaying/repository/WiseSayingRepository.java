package org.example.wiseSaying.repository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.member.entity.Member;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WiseSayingRepository {
    long lastId = 0;
    private  List<WiseSaying> wiseSayings;
    private DBConnection dbConnection;

    public WiseSayingRepository () {
        dbConnection = Container.getDBconnection();
        wiseSayings = new ArrayList<>();
    }

    public List<WiseSaying> getArticleListAll() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM article"));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            wiseSayings.add(new WiseSaying(row));
        }

        return wiseSayings;
    }

    public void write(long wiseSayingNum, String content, String author, String userId) {
        WiseSaying wiseSaying = new WiseSaying(wiseSayingNum, content, author, userId);
        wiseSayings.add(wiseSaying);
    }

    public WiseSaying getWiseSayingfindById(long inputNum) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            if (wiseSaying.getId() == inputNum) {
                return wiseSaying;
            }
        }
        return null;
    }

    public long getWiseSayingListSize() {
        return wiseSayings.size();
    }

    public void getWiseSayingList() {
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent(), wiseSaying.getWriter());
        }
    }

    public void remove(WiseSaying wiseSaying) {
        if (wiseSaying.getWriter().equals(Container.getLoginedMember().getUserId())) {
            wiseSayings.remove(wiseSaying);
            System.out.println(wiseSaying.getId() + "번 명언이 삭제되었습니다.");
        }
        else {
            System.out.println("글 작성자만 삭제가 가능합니다.");
        }
    }

    public void modify(WiseSaying wiseSaying) {
        if (wiseSaying.getWriter().equals(Container.getLoginedMember().getUserId())) {
            System.out.println("기존 명언 : " + wiseSaying.getContent());
            String content = Container.getSc().nextLine().trim();
            wiseSaying.setContent(content);
            System.out.println("기존 작가 : " + wiseSaying.getAuthor());
            String author = Container.getSc().nextLine().trim();
            wiseSaying.setAuthor(author);
            System.out.println(wiseSaying.getId() + "번 명언이 수정되었습니다.");
        }
        else {
            System.out.println("글 작성자만 수정이 가능합니다.");
        }
    }
}
