package p1.p11;

import p1.A;
import p1.p12.*;
import p1.p12.p121.*;

class B extends A {
    String Name1 = "B1";
    public String Name2 = "B2";
    private String Name3 = "B3";
    protected String Name4 = "B4";

    C c = new C();
    D d = new D();
    F f = new F();

    void getA() {
        System.out.println(super.Name2);
        System.out.println(super.Name4);
    }

    void getC() {
        System.out.println(c.Name1);
        System.out.println(c.Name2);
        System.out.println(c.Name4);
    }

    public void get() {
        getC();
        getA();
    }
}


