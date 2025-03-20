package p1.p12.p121;

import p1.p12.*;
import p1.*;
import p1.p11.*;
import p1.p12.*;

public class F extends D {
    String Name1 = "F1";
    public String Name2 = "F2";
    private String Name3 = "F3";
    protected String Name4 = "F4";

    A a = new A();
    D d = new D();
    
    void getA() {
        System.out.println(a.Name2);
    }
    
    void getD() {
        System.out.println(d.Name2);
    }

    public void get() {
        System.out.println("Can't access B, C and E");
        getA();
        getD();
    }

}
