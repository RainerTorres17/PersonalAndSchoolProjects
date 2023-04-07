import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    //creating graph methods that will execute in accordance to the input

    int verticesNumber;
    int[][] matrix; //adjacency matrix
    
    public Graph(int n)
    {
        verticesNumber = n;
        matrix = new int[verticesNumber][verticesNumber];
    }

    public void addEdge(int v, int w, int weight)
    {
        matrix[v][w] = weight;
        matrix[w][v] = weight;
    }
    
    public void removeEdge(int v, int w)
    {
        matrix[v][w] = -1;
        matrix[w][v] = -1;        
    }

    public int[] findAdjacencyVertices(int v)
    {
        int[] vert = new int[verticesNumber];
        int total = 0;
        
        for (int i=0; i<verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
            {
                vert[total] = i;
                total++;
            }
        }
        
        return Arrays.copyOf(vert, total);        
    }


    //Sourced from Prog18_01

    private int minDistance(boolean [] visited, int[] distance){
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < verticesNumber; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                index = i;
            }
        }

        return index;
    }



    //sourced from Prog18_07

    public void shortestPath(int[] p, int[] d, int src, int dest){
        boolean[] visited = new boolean [verticesNumber];

        for(int i = 0; i < verticesNumber; i++){
            visited[i] = false;
            p[i] = -1;
            d[i] = Integer.MAX_VALUE;
        }

        d[src] = 0;

        for(int i = 0; i < verticesNumber-1; i++){
            int w = minDistance(visited,d);
            visited[w] = true;

            if (w == dest) {
                break;
            }

            int [] adj = findAdjacencyVertices(w);
            for(int u: adj){
                if(!visited[u]){
                    if(d[w] + matrix[w][u] < d[u]){
                        d[u] = d[w]+matrix[w][u];
                        p[u] = w;
                    }
                }
            }
        }
    }

    public ArrayList<Integer> printShortestPath(int[] parent, int src, int dest) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        int curr = dest;
        while (curr != -1) {
            path.add(0, curr);
            curr = parent[curr];
        }
        System.out.print("Shortest path from " + src + " to " + dest + ": ");

        for (int i = 0; i < path.size(); i++) {
            if(i == path.size() -1){
                System.out.print(path.get(i));
            }else{
                System.out.print(path.get(i) + " -> ");
            }

        }
        System.out.println();

        return path;
    }

}
