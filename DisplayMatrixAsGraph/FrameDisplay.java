import java.util.ArrayList;

import javax.swing.*;

//this class displays the panel built in the graph display path

public class FrameDisplay extends JFrame{
    int WIDTH = 450;
    int HEIGHT = 450;

    public FrameDisplay(int numVertices, int[][] edges, int sourceVertex, int destVertex, int shortestDistance, ArrayList<Integer> shortestPath)
    {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        GraphDisplay panel = new GraphDisplay(numVertices, edges, sourceVertex, destVertex, shortestDistance, shortestPath);
        add(panel);
    }
}
