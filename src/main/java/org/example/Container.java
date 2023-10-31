package org.example;

import org.example.member.entity.Member;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getSc() {
        return sc;
    }

    private static Member loginedMember = null;

    public static Member getLoginedMember() {
        return loginedMember;
    }

    public static void setLoginedMember(Member member) {
        loginedMember = member;
    }
}
