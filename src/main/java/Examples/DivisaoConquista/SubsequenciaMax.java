package Examples.DivisaoConquista;

import java.util.Arrays;

public class SubsequenciaMax {
    public static void main(String[] args) {
        int[] arr = {-5, 4, 2, 4, 5};

        System.out.println(subsequenciaMax(arr));
    }

    static int subsequenciaMax(int[] vet){
        if(vet.length == 1)
            return vet[0];
        if(vet.length == 2)
            return vet[0] + vet[1];

        int[] tmp1 = Arrays.copyOfRange(vet, 0, vet.length/2);
        int[] tmp2 = Arrays.copyOfRange(vet, vet.length/2, vet.length);

        int s1 = subsequenciaMax(tmp1);
        int s2 = subsequenciaMax(tmp2);

        return max3(s1, s2, s1 + s2);
    }

    private static int max3(int f1, int f2, int f3) {
        return Integer.max(Integer.max(f1, f2), f3);
    }
}
