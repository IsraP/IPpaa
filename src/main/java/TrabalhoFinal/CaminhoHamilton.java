package TrabalhoFinal;

public class CaminhoHamilton {
    public static void main(String[] args) {
        int[][] graph1 = {
                {0, 1, 1, 0, 0}, // A
                {1, 0, 0, 1, 0}, // B
                {1, 0, 0, 1, 1}, // C
                {0, 1, 1, 0, 1}, // D
                {0, 0, 1, 1, 0}, // E
        };
    }
}

/*
Create an empty path array.
Add the vertex 0 to the array.
Start adding vertex 1 and other connected nodes and check if the current vertex can be included in the array or not.
This can be done by using a visiting array and check if the vertex has already been visited or is adjacent to previously added vertex.
If any such vertex is found, add it to the array and backtrack from that node.
Try every possible combinations and if a path returns false, ignore the vertex and start iterating from the next vertex till all the nodes has been visited.
* */