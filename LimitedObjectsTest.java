
class TestObject {
    static int count = 0;
    String name = "Hello";

    private TestObject() {
    }

    static TestObject create() {
        if (count < 3) {
            count++;
            System.out.println("Object number created: " + count);
            return new TestObject();
        }
        System.out.println("Object is not created");
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
        count--;
        System.out.println("Deleted object");
        super.finalize();
    }

}

class LimitedObjectsTest {
    public static void main(String[] args) throws InterruptedException {
        TestObject t1 = TestObject.create();
        TestObject t2 = TestObject.create();
        TestObject t3 = TestObject.create();
        TestObject t4 = TestObject.create();

        t1 = null;
        System.gc();
        Thread.sleep(100);
        TestObject t5 = TestObject.create();
        
    }
}
