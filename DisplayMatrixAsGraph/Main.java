import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {



        File input = new File("C:/Users/alanf/Desktop/FINALLL/bigInput.txt");

        Scanner in = null;
        try
        {
            in = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }

        //sourced from ReadInputFromTextFile

        //intakes number of vertices
        int verticesNumber = in.nextInt();

        System.out.println("number of vertices: " + verticesNumber);

        // create a 2D array to store the adjacency matrix

        Graph graph = new Graph(verticesNumber);

        // read the matrix from the remaining lines of the file
        //stop before the last line
        for (int i = 0; i < verticesNumber; i++) {
            for (int j = 0; j < verticesNumber; j++) {
                int weight = in.nextInt();
                if (weight >= 0) {
                    graph.addEdge(i, j, weight);
                    System.out.print(weight + " ");
                }
            }
            System.out.println();
        }

            //collect s and t
            int source = in.nextInt();
            System.out.println("source: " + source);
            int destination = in.nextInt();
            System.out.println("destination: " + destination);

            // close the input file
            in.close();

            // find the shortest paths from vertex 0 to all other vertices
            int[] p = new int[verticesNumber]; // array to store previous vertex on shortest path
            int[] d = new int[verticesNumber]; // array to store distance to each vertex

            graph.shortestPath(p, d, source, destination);

            if (d[destination] == Integer.MAX_VALUE) {
                System.out.println("No path found");
            } else {
                System.out.println("Shortest distance: " + d[destination]);
                
            }
            ArrayList<Integer> path = graph.printShortestPath(p, source, destination);//FIX ME

            FrameDisplay frame = new FrameDisplay(verticesNumber, graph.matrix, source, destination , d[destination], path);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            

    }
}
