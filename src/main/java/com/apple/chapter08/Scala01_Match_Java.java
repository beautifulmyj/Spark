package com.apple.chapter08;

public class Scala01_Match_Java {
    public static void main(String[] args) {

        int age = 40;

        // switch穿透现象

        switch (age) {
//            default:
//                System.out.println("年龄为其他");
            case 10 :
                System.out.println("年龄为10");
            case 20 :
                System.out.println("年龄为20");
                break;
            case 30 :
                System.out.println("年龄为30");
                break;
        }


    }
}
