public class testrecursion {
    public static void main(String args[]) {
        new Thread(null, new Runnable() {
            public void run() {
                new testrecursion().call(0);
            }
        }, "1", 1 << 26).start();
    }

    public static void call(int i) {
        if (i > 1000000)
            return;
        call(i+1);
    }
}