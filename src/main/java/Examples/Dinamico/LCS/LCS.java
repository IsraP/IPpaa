package Examples.Dinamico.LCS;

public class LCS {
    static Integer[][] memo;
    static String a, b;
    static int al, bl;

    public static void main(String[] args) {
        a = "ARARATO";
        b = "RATOARARAT";
        al = a.length();
        bl = b.length();

        memo = new Integer[al][bl];

        System.out.println("Result: " + LCS(a.length()-1, b.length()-1));
    }

    static int LCS(int indexA, int indexB){
        Integer result;

        if(indexA == -1 || indexB == -1) // Caso base. Caso tenhamos chegado ao fim da string, do final para o inicio, retorne 0.
            return 0;

        result = memo[indexA][indexB]; // memoization
        if(result != null)
            return result; // memoization doing crazy shit

        result = Integer.max(LCS(indexA - 1, indexB), LCS(indexA, indexB - 1));
        if(a.charAt(indexA) == b.charAt(indexB))
            result = Integer.max(result,  LCS(indexA - 1, indexB - 1) + 1);
        else
            result = Integer.max(result,  LCS(indexA - 1, indexB - 1));

        memo[indexA][indexB] = result; // memoization

        return result;
    }

    private static void printMatrix() {
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }

    private static int max3(int f1, int f2, int f3) {
        return Integer.max(Integer.max(f1, f2), f3);
    }

    static int nonDynamicLCS(int indexA, int indexB){
        int result = 0;

        if(indexA == -1 || indexB == -1)
            return result;

        if(a.charAt(indexA) == b.charAt(indexB)) {
            result = max3(nonDynamicLCS(indexA - 1, indexB), nonDynamicLCS(indexA, indexB - 1), nonDynamicLCS(indexA - 1, indexB - 1) + 1);
        }
        else {
            result = max3(nonDynamicLCS(indexA - 1, indexB), nonDynamicLCS(indexA, indexB - 1), nonDynamicLCS(indexA - 1, indexB - 1));
        }
        return result;
    }


}
