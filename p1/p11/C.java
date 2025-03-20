package p1.p11;

import p1.A;
import p1.p12.*;
import p1.p12.p121.*;

class C {
    String Name1 = "C1";
    public String Name2 = "C2";
    private String Name3 = "C3";
    protected String Name4 = "C4";

    B b = new B();
    A a = new A();

    void getB() {
        System.out.println(b.Name1);
        System.out.println(b.Name2);
        System.out.println(b.Name4);
    }

    void getA() {
        System.out.println(a.Name2);
    }

    public void get() {
        getA();
    }
}