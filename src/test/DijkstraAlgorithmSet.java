package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DijkstraAlgorithmSet {
	private int distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int number_of_nodes;
    private int adjacencyMatrix[][];
 
    public DijkstraAlgorithmSet(int number_of_nodes)
    {
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
    }
 
    public void dijkstra_algorithm(int adjacency_matrix[][], int source)
    {
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++)
            for (int j = 1; j <= number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
 
        for (int i = 1; i <= number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
 
        unsettled.add(source);
        distances[source] = 0;		
        while (!unsettled.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        } 
    }
 
    private int getNodeWithMinimumDistanceFromUnsettled()
    {
        int min ;
        int node = 0;
 
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++)
        {
            if (unsettled.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;			
                }
            }
        }
        return node;
    }
 
    private void evaluateNeighbours(int evaluationNode)
    {
        int edgeDistance = -1;
        int newDistance = -1;
 
        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }
 
    public static void main(String... arg) throws FileNotFoundException
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0;
        Edge[] edges2 = new Edge[711];
        Scanner scan = new Scanner(new File("src/CityDistances.txt"));
        String firstline = scan.nextLine(); //ignore first line
		int k = 0;		
		while(scan.hasNextLine()){
			int from = scan.nextInt();
			int to = scan.nextInt();
			int dist = scan.nextInt();
			edges2[k] = new Edge(from,to,dist);
			k++;
		}
            number_of_vertices = 248;
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
 
           // System.out.println("Enter the Weighted Matrix for the graph");
          for(Edge e: edges2){
              adjacency_matrix[e.getFromNodeIndex()][e.getToNodeIndex()] = e.getLength();
                    if (e.getFromNodeIndex() == e.getToNodeIndex())
                    {
                        adjacency_matrix[e.getFromNodeIndex()][e.getToNodeIndex()] = 0;
                        continue;
                    }
                    if (adjacency_matrix[e.getFromNodeIndex()][e.getToNodeIndex()] == 0)
                    {
                        adjacency_matrix[e.getFromNodeIndex()][e.getToNodeIndex()] =  Integer.MAX_VALUE;
                    }
                } 
           
          for (int i = 0; i < adjacency_matrix.length; i++) {
        	    for (int j = 0; j < adjacency_matrix[i].length; j++) {
        	        System.out.print(adjacency_matrix[i][j] + " ");
        	    }
        	    System.out.println();
        	}
            System.out.println("Enter the source ");
            source = 6;
            //scan.close();
 
            DijkstraAlgorithmSet dijkstrasAlgorithm = new DijkstraAlgorithmSet(number_of_vertices);
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
 
            System.out.println("The Shorted Path to all nodes are ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
            {
                System.out.println(source + " to " + i + " is "+ dijkstrasAlgorithm.distances[i]);
            }
        } 
        //scan.close();
    }

