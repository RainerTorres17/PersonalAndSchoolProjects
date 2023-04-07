import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


//this class displays the graph along with the shortest path calculated
public class GraphDisplay extends JPanel{

    int numVertices;
    int[][] edges;
    int source;
    int destination;
    int shortestDistance;
    ArrayList<Integer> shortestPath;

    public GraphDisplay(int numVertices, int[][] edges, int source, int destination, int shortestDistance, ArrayList<Integer> shortestPath) {
        this.numVertices = numVertices;
        this.edges = edges;
        this.source = source;
        this.destination = destination;
        this.shortestDistance = shortestDistance;
        this.shortestPath = shortestPath;
    }

    public void paint(Graphics g)
    {        
        int vertexCount = edges.length;
       

        int maxColumns = (int) Math.ceil(Math.sqrt(vertexCount));
        
        int padding = 50;
        int diameter = 30;

        //draw vertices
        for (int i = 0; i < vertexCount; i++) {
            int column = i % maxColumns;
            int row = i / maxColumns;

            int x = padding + column * (diameter + padding);
            int y = padding + row * (diameter + padding);

            g.setColor(Color.ORANGE);
            g.fillOval(x, y, diameter, diameter);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, diameter, diameter);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            g.drawString(String.valueOf(i), x + diameter / 2, y + diameter / 2);

            //draw edges
            
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i][j] != 0) {
                    int destColumn = j % maxColumns;
                    int destRow = j / maxColumns;
                    int destX = padding + destColumn * (diameter + padding);
                    int destY = padding + destRow * (diameter + padding);
                    if (shortestPath.contains(i) && shortestPath.contains(j)) {
                        // draw red line for shortest path
                        g.setColor(Color.RED);
                        g.drawLine(x + diameter / 2, y + diameter / 2, destX + diameter / 2, destY + diameter / 2);
                        g.setColor(Color.BLACK);
                    } else {
                        // draw black line for other edges
                        g.drawLine(x + diameter / 2, y + diameter / 2, destX + diameter / 2, destY + diameter / 2);
                    }
                }
            }
        }

        

    }
    
        
}


