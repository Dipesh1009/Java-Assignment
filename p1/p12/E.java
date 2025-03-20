package p1.p12;

import p1.*;
import p1.p11.*;
import p1.p12.p121.*;

class E {
    String Name1 = "E1";
    public String Name2 = "E2";
    private String Name3 = "E3";
    protected String Name4 = "E4";

    D d = new D();
    A a = new A();

    void getD() {
        System.out.println(d.Name1);
        System.out.println(d.Name2);
        System.out.println(d.Name4);
    }

    void getA() {
        System.out.println(a.Name2);
    }


    public void get() {
        System.out.println("Can't access B, C and E");
        getA();
        getD();
    }
}