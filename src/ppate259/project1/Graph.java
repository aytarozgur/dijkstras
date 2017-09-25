
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//creating graph object and implementing dijkstra's algorithm
public class Graph {
 private ArrayList<Node> cities;
 private Edge[] edges;
 private int noOfEdges;
 private int noOfNodes;
 
 
 //constructor 
 public Graph(ArrayList<Node> cities2,Edge[] edges){
  this.edges = edges;
  this.cities = cities2;
 
 // create all nodes ready to be updated with the edges
	
 
 // add edges to nodes
 /* goes through cities array and the edges array, 
    for each edge in the edges array, which is the information stored from
    the city distances file, for every fromNodeIndex, go to the corresponding
    Node(city) in cities and add to the empty Edge arrayList so each node
    has a corresponding Edge arrayList 
 */

  // if(cities.get(i).getEdges().isEmpty()){
     for (Edge e: edges){
    	// System.out.println("Edge:" + e.getFromNodeIndex() + "," + e.getToNodeIndex() + "," + e.getLength());
           
         cities.get(e.getFromNodeIndex()-1).addEdge(e); 
         cities.get(e.getToNodeIndex()-1).addEdge(e);
         }
 }
 
// Test function to test that the edge lists were added to the Node objects
 // in the cities (node) ArrayList
 
 public void printprint(){    
 for(int i = 0; i<248; i++){
	 System.out.println("Adding edge:" + cities.get(i).getEdges().get(i).getFromNodeIndex() + "-->" + cities.get(i).getEdges().get(i).getToNodeIndex());
   
	 System.out.println(cities.get(i).getEdges().get(i).getToNodeIndex());
 }

 }

 
 // Test function to receive the edge info from the arrayList of edges for each node
 // Prints out ADJACENCY LIST
 public void printEdgeInfo(){
	 for (int nodenumber= 0; nodenumber < 248; nodenumber++) {
		   ArrayList<Edge> myedgess = this.cities.get(nodenumber).getEdges();		   
		   System.out.print(+nodenumber+1 + ": { ");
		   for (Edge e: myedgess){
		   System.out.print(e.getFromNodeIndex() + " ");// }
		   System.out.print("-->" + e.getToNodeIndex() + " ");
		  
		 } System.out.println(" } ");
		   }
	 
 }
 // Another function to receive the Adjacency List but I receive an error 
 // Error: Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 248, Size: 248
 public void GraphAdjacencyList()
 {
	 Map<Integer, Integer> Adjacency_List;
     Adjacency_List = new HashMap<Integer, Integer>();	
     for (int i = 0 ; i < 248 ; i++)
     { 
		   ArrayList<Edge> myedgess = this.cities.get(i).getEdges();	
		   for (Edge e: myedgess){
			   	Adjacency_List.put(e.getFromNodeIndex(), e.getToNodeIndex());
     }
 }
 }


// Dijkstra's algorithm
 public void calculateShortestDistances() {
 // node 0 as source
  cities.get(58).setDistanceFromSource(0);
  int nextNode = 0;
  // visit every node
  for (int i = 0; i < this.cities.size(); i++) {
   // loop around edges of current node
    ArrayList<Edge> currentNodeEdges = cities.get(nextNode).getEdges();
    for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
      int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighborIndex(nextNode);
     // only if not visited
      if (!cities.get(neighbourIndex).isVisited()) {
        int tentative = cities.get(nextNode).getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
        if (tentative < cities.get(neighbourIndex).getDistanceFromSource()) {
          cities.get(neighbourIndex).setDistanceFromSource(tentative);
       }
      }
    }
   // node is visited, all neighbors have been checked
    cities.get(nextNode).setVisited(true);
   // next node must be with shortest distance
    nextNode = getNodeShortestDistanced();
}
 }
 
 
 
// check for next node with shortest distance from source
 private int getNodeShortestDistanced() {
  int storedNodeIndex = 0;
  int storedDist = Integer.MAX_VALUE;
  for (int i = 0; i < this.cities.size(); i++) {
    int currentDist = this.cities.get(i).getDistanceFromSource();
    if (!cities.get(i).isVisited() && currentDist < storedDist) {
      storedDist = currentDist;
      storedNodeIndex = i;
    }
  }
  return storedNodeIndex;
 }
 
		   
// display result
 public void printResult() {
  String output = "";
  
  for (int i = 0; i < this.cities.size(); i++) {
    output += ("\nThe shortest distance from node 58 (chicago) to node " + i + " is " + cities.get(i).getDistanceFromSource());
  }
  System.out.println(output);
 }
 
 
 //functions to get private elements 
 public ArrayList<Node> getNodes() {
  return cities;
 }
 
 
 public int getNoOfNodes() {
  return noOfNodes;
 }
 
 
 public Edge[] getEdges() {
  return edges;
 }
 
 
 public int getNoOfEdges() {
  return noOfEdges;
 }
 
}

