import java.math.BigInteger;

public class DiwaliLights {

        public static void main(String[] args) {
            long r = lights(663);
            System.out.println(r);
        }

        static long lights(int n) {
            //Total ways of choosing at least 1 bulb is 2^(n-1)
            long res = 1;
            for (int i = 1; i < n; i++) {
                res = (res * 2) % 100000;
            }
            return res;
        }
}
