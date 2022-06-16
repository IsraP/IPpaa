package Examples.Guloso.ChangeMakingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CMP {
    public static void main(String[] args) {
        int compra = 43, n = 4;
        int[] moedas = {25, 10, 5, 1};

        System.out.println(findChange(compra, n, moedas));
    }

    static int findChange(int compra, int n, int[] moedas){
        List<Integer> sol = new ArrayList<>();
        int troco = compra;

        Arrays.sort(moedas);

        while(troco != 0){
            for(int i = moedas.length-1; i >= 0; i--){
                if(troco - moedas[i] < 0)
                    continue;

                troco = troco - moedas[i];
                sol.add(moedas[i]);
            }
        }
        System.out.println(sol);

        return sol.size();
    }
}
