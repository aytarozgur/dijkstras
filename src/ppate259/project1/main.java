
 /* ------------------------------------------------ 
  * Prog 1: Mid Meeting * 
  *
  * Class: CS 342, Fall 2016  
  * System: OS X, Eclipse IDE
  * Author Code Number: 907P   
  *
  * -------------------------------------------------
  */

package ppate259.project1;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws FileNotFoundException {
	
		//scan CityNames and print cities with index number, store into array of city(node) objects
		Scanner sc = new Scanner(new File("src/CityNames.txt"));
		List<String> lines = new ArrayList<String>();
		String line1 = sc.nextLine(); //skip first line
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		}

		String[] arr = lines.toArray(new String[0]);
		
		ArrayList<Node> cities = new ArrayList<Node>();
		for(int i = 0; i<248; i++){ 
			cities.add(new Node(i+1,arr[i]));		
		}
		
		//checking to see if city information was stored correctly
		/*for(Node n: cities)
		{
			System.out.println(n.getIndexNumber() + n.getName());
		}*/
		sc.close();

		//read in city distances and set up edges and graph
		Scanner sc2 = new Scanner(new File("src/CityDistances.txt"));
		String firstline = sc2.nextLine(); //ignore first line
		int j = 0;		
		Edge[] edges2 = new Edge[711];
		while(sc2.hasNextLine()){
			int from = sc2.nextInt();
			int to = sc2.nextInt();
			int dist = sc2.nextInt();
			edges2[j] = new Edge(from,to,dist);
			j++;	
		}
	
		sc2.close();
		
	 System.out.println("Author Code Number: 907P");
     System.out.println("Class: CS 342, Fall 2016");
     System.out.println("Program: #1, Mid Meeting");	
     System.out.println();
	 Graph g = new Graph(cities,edges2);
	 g.printEdgeInfo(); //prints out most of adjacency list
	 g.GraphAdjacencyList(); //function I made to print out adjacency list, not properly working
	 g.calculateShortestDistances();
	// g.printprint();

	 g.printResult(); //prints out shortest distances from Chicago(City/Node 58)
	  }

	
}
