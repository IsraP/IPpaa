package Examples.Dinamico.Knapsack;

import java.util.Arrays;
import java.util.Random;

public class Knapsack {
    static Integer[][] memo;
    static Item[] items;

    public static void main(String[] args) {
        int n = 5;
        int c = 10;

        fillArrays(n, c);
        System.out.println(Arrays.toString(items));

        System.out.println("Result: " + knapsack(n-1, c-1));
    }

    private static void fillArrays(int n, int c) {
        Random r = new Random();

        memo = new Integer[n][c];
        items = new Item[n];

        for(int i = 0; i < items.length; i++){
            items[i] = new Item(r.nextInt(10), r.nextInt(10));
        }
    }

    static int knapsack(int n, int c){
        Integer result = memo[n][c];
        int f1, f2;

        if(result != null)
            return result;
        if(n == 0 || c == 0)
            return 0;
        if(items[n].weight > c){
            return knapsack(n-1, c);
        }

        f1 = knapsack(n-1, c);
        f2 = items[n].value + knapsack(n-1, c-items[n].weight);
        result = Integer.max(f1, f2);
        memo[n][c] = result;

        return result;
    }
}
