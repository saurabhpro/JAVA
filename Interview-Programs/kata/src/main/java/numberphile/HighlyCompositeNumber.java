package numberphile;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=2JM2oImb9Qg
 * A Study of how highly composite number (Anti-Prime) numbers are found (Ramanujan)
 * num = p1^a1 x p2^a2 x ... pk^ak<br/>
 * Total Number of factors of a number = (a1 + 1) x (a2 + 1) + .... + (ak + 1) <br/>
 * It should have three properties <br>
 * 1. the prime factors (p1, p2,...) has to be consecutive
 * 2. the powers (a1, a2,...) has to be weekly decreasing, so a1 >> a2 >> a3 >> ...
 * 3.
 */
public class HighlyCompositeNumber {
    public boolean isHighlyComposite(int i) {

        Map<Long, Integer> primeFactors = getPrimeFactors(i);

        // consequtive

	    return false;
     }

    private Map<Long, Integer> getPrimeFactors(int i) {
        Map<Long, Integer> primeFactors  = new HashMap<>();
        long prime = 2;
        int tmp;
        while (i > 0) {
            tmp = 0;
            while(i % prime == 0){
                tmp++;
                i /= prime;

                primeFactors.put(prime, tmp);
            }

            prime = BigInteger.valueOf(prime).nextProbablePrime().longValue();

        }
return primeFactors;
    }

    private int getNextPrime(int prime) {
        for(int i = prime; i < prime * 2; i++){

        }
        return 0;
    }

    private boolean isPrime(int j) {
return false;
    }
}
