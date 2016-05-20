package iy.jspspring.training.controller;

/**
 * Created by lord-777 on 23.04.16.
 */
public class ClassWithEnum {
    private String name;
    private String pass;

    public ClassWithEnum(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public void doSome(){
        InnerClass innerClass = new InnerClass();
        int i = innerClass.someMethod();
        String s = "";
    }

    private enum Inner{
        ONE(23),
        TWO(56);

        private int some;

        Inner(int i) {
            some = i;
        }

        public int getSome() {
            return some;
        }
    }

    private class InnerClass{

       private int someMethod(){
           return Inner.ONE.getSome();
        }
    }
}
