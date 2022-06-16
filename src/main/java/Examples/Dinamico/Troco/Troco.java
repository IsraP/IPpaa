package Examples.Dinamico.Troco;

import java.util.ArrayList;
import java.util.List;

public class Troco {
    static Integer[] memo;

    public static void main(String[] args) {
        int compra = 16, n = 4;
        int[] moedas = {25, 10, 5, 1};

        memo = new Integer[compra+1];

        System.out.println(findTroco(compra, n, moedas));
    }

    private static String findTroco(int compra, int n, int[] moedas){
        int resp = findExactTroco(compra, n-1, moedas);

        if(resp > 0)
            return "S";

        return "N";
    }

    private static int findExactTroco(int compra, int n, int[] moedas) {
        Integer result = memo[compra];

        if(result != null) {
            System.out.println("MEMOIZATION");
            return result;
        }
        if(compra == 0)
            return 1;
        if(compra - moedas[n] < 0)
            return 0;
        if(n < 0)
            return 0;
        else if(compra < moedas[n])
            result = findExactTroco(compra, n-1, moedas);
        else
            result = Integer.max(findExactTroco(compra - moedas[n], n-1, moedas), findExactTroco(compra, n-1, moedas));

        memo[compra] = result;

        return result;
    }

    private static int nonDynamicFindTroco(int compra, int n, int[] moedas, List<Integer> sol) {
        if(n == -1)
            return 0;

        if(sol.stream().mapToInt(Integer::intValue).sum() == compra)
            return 1;

        List<Integer> solWithNewCoin = new ArrayList<>(sol);
        solWithNewCoin.add(moedas[n]);

        return Integer.max(nonDynamicFindTroco(compra, n-1, moedas, solWithNewCoin), nonDynamicFindTroco(compra, n-1, moedas, sol));
    }




}
