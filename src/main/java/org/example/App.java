package org.example;

import org.example.db.DBConnection;
import org.example.member.cotroller.MemberController;
import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

public class App {
    public App () {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";
        DBConnection.DB_PORT = 3306;

        Container.getDBconnection().connect();
        Container.getDBconnection().insert(
                "INSERT INTO article\n" +
                        "SET id = 5,\n" +
                        "title = \"test5\",\n" +
                        "content = \"test5\",\n" +
                        "memberId = 5,\n" +
                        "regDate = now();"
        );
    }
    public void run() {

        SystemController systemController = new SystemController();
        MemberController memberController = new MemberController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.printf("명령) ");
            String command = Container.getSc().nextLine().trim();

            switch (command) {
                case "종료":
                    systemController.exit();
                    return;
                case "회원가입":
                    memberController.signUp();
                    break;
                case "회원목록":
                    memberController.userList();
                    break;
                case "로그인":
                    memberController.login();
                    break;
                case "로그아웃":
                    memberController.logout();
                    break;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove();
                    break;
                case "수정":
                    wiseSayingController.modify();
                    break;
            }
        }
    }
}
