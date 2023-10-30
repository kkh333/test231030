package org.example;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
        //글 작성시, 로그인한 작성자 이름 남기게 하는 부분부터 막혔습니다
    }
}