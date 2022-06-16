package Examples.Dinamico.Fibonacci;

public class Fibonacci {
    static Integer[] memo;

    public static void main(String[] args) {
        int n = 5;

        memo = new Integer[n + 1];
        System.out.println(fibo2(n));
    }

    public static int fibo(int n){
        int result;
        Integer f1, f2;

        System.out.println("Current n: " + n);
        printMemo();

        if(n == 1 || n == 2)
            result = 1;
        else{
            f1 = memo[n-2];
            f2 = memo[n-3];

            if(f1 == null) {
                f1 = fibo(n - 1);
                memo[n-2] = f1;
                System.out.println("Adding " + f1 + " to position " + (n-2));
            }
            else{
                System.out.println("Using memoized data on position " + (n-2) + " for value " + f1);
            }

            if(f2 == null) {
                f2 = fibo(n - 2);
                memo[n-3] = f2;
                System.out.println("Adding " + f2 + " to position " + (n-3));
            }
            else{
                System.out.println("Using memoized data on position " + (n-3) + " for value " + f2);
            }

            result = f1 + f2;
        }

        System.out.println();

        return result;
    }

    static int fibo2(int n){
        System.out.println("Current n: " + n);
        printMemo();

        Integer result = memo[n];

        if(result != null) {
            System.out.println("Using memoized data on position " + n + " for value " + result);
            return result;
        }

        if(n == 1 || n == 2)
            result = 1;
        else
            result = fibo2(n-1) + fibo2(n-2);

        memo[n] = result;
        System.out.println("Adding " + result + " to position " + n);

        return result;
    }

    private static void printMemo() {
        System.out.print("[");
        for (Integer integer : memo) {
            System.out.print(integer + ", ");
        }
        System.out.print("]\n");
    }
}
