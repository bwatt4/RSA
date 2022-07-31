package sample;

public class RSA {
    public static int eea(int x, int n) {
        int p = 0;
        int newp = 1;
        int a = n;
        int r = 0;
        int z;
        while ((a % x) > 0) {
            int q = a / x;
            r = a % x;
            int w = (p - newp * q);
            int dummyp = w % n;
            if (w < 0) {
                z = w + n;
                dummyp = z;
            }
            p = newp;
            newp = dummyp;
            a = x;
            x = r;
            if (r == 1) {
                return newp;
            }
            if (a > 1) {
                System.out.println("");
            }
        }
        return 1;
    }
    public static int encryption(int x, int e, int n) {
        int y = (int) (Math.pow(x, e) % n);
        return y;
    }
    public static int decryption(int y, int d, int n) {
            int x = (int) (Math.pow(y, d) % n);
            return x;
        }
}


