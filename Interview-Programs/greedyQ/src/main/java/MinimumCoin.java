/**
 * Created by saurabhkumar on 28/07/17.
 */
public class MinimumCoin {

    // coins[] has varities of different coins
    static int minCoins(int coins[], int valueSumRequired) {
        // base case
        if (valueSumRequired == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than valueSumRequired
        for (int coin : coins) {

            if (coin <= valueSumRequired) {
                int sub_result = minCoins(coins, valueSumRequired - coin);

                // Check for INT_MAX to avoid overflow and see if result can minimized
                if (sub_result != Integer.MAX_VALUE && sub_result + 1 < res)
                    res = sub_result + 1;
            }
        }

        return res;
    }


    // A Dynamic Programming based C++ program to find minimum of coins
    // to make a given change valueSumRequired
    // noOfCoinType is size of coins array (number of different coins)
    static int minCoinsDyn(int coins[], int valueSumRequired) {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[valueSumRequired] will have result
        int[] table = new int[valueSumRequired + 1];

        // Base case (If given value valueSumRequired is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= valueSumRequired; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to valueSumRequired
        for (int currentValue = 1; currentValue <= valueSumRequired; currentValue++) {
            // Go through all coins smaller than i
            for (int coin : coins)
                if (coin <= currentValue) {
                    int sub_res = table[currentValue - coin];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[currentValue])
                        table[currentValue] = sub_res + 1;
                }
        }
        return table[valueSumRequired];
    }
}
