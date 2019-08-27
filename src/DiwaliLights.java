import java.math.BigInteger;

public class DiwaliLights {

        public static void main(String[] args) {
            long r = lights(663);
            System.out.println(r);
        }

        static long lights(int n) {
            int res = 0;

            for (int i = 1; i <= n; i++) {
                long comb = combination(n, i).longValue();
                System.out.println(comb);
                res += comb;
            }
            return res;
        }

        private static BigInteger combination(int n, int r) {
//        n!/(r!)(n-r)!
            BigInteger modulo = BigInteger.valueOf(100000);
            BigInteger nFact = factorial(n);
            BigInteger rFact = factorial(r);
            BigInteger differenceFact = factorial(n-r);
            BigInteger mult = rFact.multiply(differenceFact).mod(modulo);

            return nFact.divide(mult);
        }

        private static BigInteger factorial(int n) {
            BigInteger res = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) {
                res  = res.multiply(BigInteger.valueOf(i));
            }
            return res;
        }
    }
}
