package p1.p12;

import p1.A;
import p1.p11.*;
import p1.p12.p121.*;


public class D {
    String Name1 = "D1";
    public String Name2 = "D2";
    private String Name3 = "D3";
    protected String Name4 = "D4";

    A a = new A();

    void getA() {
        System.out.println(a.Name2);
    }

    public void get() {
        System.out.println("Can't access B, C and E");
        getA();
    }
}
