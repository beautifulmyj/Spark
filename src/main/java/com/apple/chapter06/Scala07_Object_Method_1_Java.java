package com.apple.chapter06;

public class Scala07_Object_Method_1_Java {
    public static void main(String[] args) {

        // 方法重载 : 看参数类型,如果类型不匹配，会依赖于类树向上查找
//        AA aa = new AA();
//        BB bb = new BB();
        AA aaa = new BB();
//        test(aa); // aaa
//        test(bb); // bbb
        test(aaa); // aaa
    }
    public static void test(Object aa) {
        System.out.println("obj");
    }
//    public static void test(AA aa) {
//        System.out.println("aaa");
//    }
    public static void test(BB bb) {
        System.out.println("bbb");
    }
}
class AA {

}
class BB extends AA {

}

