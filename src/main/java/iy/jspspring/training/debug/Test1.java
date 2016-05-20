package iy.jspspring.training.debug;

public class Test1 {
    protected static String ver = "1";

    public static String print(){
        return ver;
    }

    protected void setVer(String version){
        ver = version;
    }

    public static void p(){
        System.out.println(print());
    }

    public String getStr(int i){
        return String.valueOf(i);
    }

    protected Test1() {
    }
}
