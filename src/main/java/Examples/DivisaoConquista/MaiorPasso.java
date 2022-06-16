package Examples.DivisaoConquista;

import java.util.Arrays;

import static java.lang.Math.abs;

public class MaiorPasso {
    public static void main(String[] args) {
        int[] vet = {7, 15, 27, 40, 44, 56, 69, 78, 83, 100};

        System.out.println("Linear: " + maiorPassoSequencial(vet));
        System.out.println("Divisão e Conquista: " + maiorPassoDC(vet));
    }

    static int maiorPassoSequencial(int[] vet){
        int passo = 0;

        int tmp;
        for(int i = 1; i < vet.length; i++){
            tmp = Math.abs(vet[i] - vet[i-1]);
            passo = Math.max(tmp, passo);
        }

        return passo;
    }

    static int maiorPassoDC(int[] vet){
        // System.out.println(Arrays.toString(vet));

        if(vet.length == 1)
            return 0;

        if(vet.length == 2)
            return Math.abs(vet[0] - vet[1]);

        int[] tmp1 = Arrays.copyOfRange(vet, 0, vet.length/2);
        int[] tmp2 = Arrays.copyOfRange(vet, vet.length/2, vet.length);

        return max3(maiorPassoDC(tmp1), maiorPassoDC(tmp2), Math.abs(tmp1[tmp1.length-1] - tmp2[0]));
    }

    private static int max3(int f1, int f2, int f3) {
        return Integer.max(Integer.max(f1, f2), f3);
    }

}
