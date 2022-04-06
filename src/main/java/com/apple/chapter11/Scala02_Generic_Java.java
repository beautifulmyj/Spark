package com.apple.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Scala02_Generic_Java {
    public static void main(String[] args) {

        // TODO 泛型

        // 1. 泛型和类型的关系
        // 泛型和类型无关，不能当成整体来用
        // String -> Object, List<String> -> List<Object>
        //List<String> list = new ArrayList<String>();
        //test1(list);
        //test2(list);
        // 2. 泛型的变化
        //    泛型的不可变，不考虑父子关系的。
        //List<Student> studentList1 = new ArrayList<Student>();
        //List<Student> studentList2 = new ArrayList<Parent>();
        //List<Student> studentList3 = new ArrayList<Child>();

        // 3. 泛型的上限，下限
        MessageX<Student> messageX1 = new MessageX<Student>();
        MessageX<Child> messageX2 = new MessageX<Child>();
        //MessageX<Parent> messageX3 = new MessageX<Parent>();
        // 上限和下限的作用
        // 上限用于消费数据,保证功能不丢失
        Consumer<Student> c = new Consumer<Student>();
        final Message<? extends Student> message = c.consume();
        final Student data = message.data;

        // 下限用于生成数据，保证数据转换正常
        Producer<Student> p = new Producer<Student>();
        p.produce(new Message<Student>());
        p.produce(new Message<Parent>());
        //p.produce(new Message<Child>());

    }
    public static void test1( Collection<String> stringList ) {

    }
    public static void test2( List<Object> stringList ) {

    }
}
class Parent {

}
class Student extends Parent {

}
class Child extends Student {

}

class MessageX<T> {
    public T data;
}
class Producer<T> {
    public void produce( Message<? super T> m ) {

    }
}
class Consumer<T> {
    public Message<? extends T> consume() {
        return null;
    }
}
//// 下限
//class MessageXX<T super Student> {
//    public T data;
//}

