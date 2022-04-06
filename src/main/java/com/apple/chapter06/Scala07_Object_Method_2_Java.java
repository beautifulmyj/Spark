package com.apple.chapter06;

public class Scala07_Object_Method_2_Java {
    public static void main(String[] args) {

        // 方法重写 ： 动态绑定原则
        // 在调用对象的成员方法过程中，JVM会将当前的方法和实际的对象内存进行绑定后调用
        // 成员变量是没有绑定机制，所以在哪里声明，在哪里使用
        AAA aaa = new AAA();
        BBB bbb = new BBB();
        AAA aaaa = new BBB();
       // System.out.println(aaa.sum()); // 20
       // System.out.println(bbb.sum()); // 40
        //System.out.println(aaaa.sum()); // 40
        //System.out.println(aaaa.sum()); // 20
        System.out.println(aaaa.sum()); //30
    }

}

class AAA {
    public int i = 10;
    public int sum() {
        return i + 10;
    }
    //public int getI() {
//        return i;
//    }
}

class BBB extends AAA {
    public int i = 20;
//    public int sum() {
//        return i + 20;
//    }
//    public int getI() {
//        return i;
//    }
}

