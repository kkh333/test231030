package org.example;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
        //삭제, 수정 글 작성자만 되게 작업중
    }
}