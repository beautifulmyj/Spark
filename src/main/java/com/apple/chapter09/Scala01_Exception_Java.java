package com.apple.chapter09;

public class Scala01_Exception_Java {
    public static void main(String[] args) throws Exception {
        throw new Exception();
        // Java 异常
        // Scala异常不分类
//        try {
//            int i = 0;
//            int j = 10 / i;
//
//        } catch ( ArithmeticException e ) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("xxxxx");
//        }
        //System.out.println(test());
    }
    public static int test() {
        // java中方法的返回值是固定的。
        int i = 0;
        try {
            return i++; // _rtnVal = i++ = 0; i = 1
        } finally {
            //return ++i; // _rtnVal =++i = 2; return _rtnVal
            ++i;
        }
    }
}
