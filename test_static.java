public class test_static {
    static int ser;
    public static void main(String s[]) {
        System.out.println("Testing static variables.");
        for (int i=0; i<10; i++) {
            ser=0;
            ser++;
            System.out.println(ser);
        }
        System.out.println(ser);
    }
}   