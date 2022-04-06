package com.apple.chapter06;

public class Scala11_Object_Interface_Java {
    public static void main(String[] args) {

        // 接口和父子类无关
        //C c = new D();
       // D d = new E();
        // 多态的传递
        C c = new E();
        System.out.println(c);
        System.out.println(E.class.getInterfaces().length);
    }
}
interface C {

}
class D implements C {

}
class E extends D {

}
