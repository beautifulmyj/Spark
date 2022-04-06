package com.apple.chapter11;
import java.util.*;
public class Scala01_Generic_Java {
    public static void main(String[] args) {

        // TODO 泛型

        // 1. 泛型和类型的区别？
        // 类型用于声明外层对象的类型, 泛型主要用于声明内部数据的类型
        // 如果构造对象时，没有使用泛型，这个时候，内部数据的类型会自动变为Object类型
        // 有的时候，将泛型也称之为：类型参数

        //Message<String> message = new Message<String>();
        //message.data
        // 2. 泛型的作用时机
        //    泛型在声明后,对类型操作时起作用
        //    泛型只在编译时起作用，在运行时不起作用,称之为泛型擦除
        List list = new ArrayList();
        list.add(new Emp());

        List<User> userList = list;
        //System.out.println(userList);
        for ( User user : userList ) {
            System.out.println(user);
        }

    }
}
class Emp {

}
class User {

}
class Message<T> {
    public T data;
}
