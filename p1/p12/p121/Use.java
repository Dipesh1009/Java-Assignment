package p1.p12.p121;

import p1.*;
import p1.p11.*;
import p1.p12.*;
import p1.p12.p121.*;


public class Use {
    public static void main(String[] args) {
        A a = new A();        
        D d = new D();
        F f = new F();    
        
        System.out.println("\nFor A");
    

        System.out.println("\nFor D");
        d.get();

        System.out.println("\nFor F");
        f.get();

        System.out.println("Use cannot access class B, C and E, as they are not public (visible)");

    }
}
