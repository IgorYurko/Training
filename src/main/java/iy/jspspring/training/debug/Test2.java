package iy.jspspring.training.debug;

import iy.jspspring.training.debug.Test1;

public class Test2 extends Test1
{

    public static String print(){
        return "2";
    }

    public static void p(){
        System.out.println(print());
    }

    public Test2() {
        Test1 test1 = new Test1();
        test1.setVer("2");
    }
}
