
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

import java.util.ArrayList;


public class Node {
  private int indexNumber;
  private String name;
  private int distanceFromSource = Integer.MAX_VALUE;
  private boolean visited = false;
  private ArrayList<Edge> myedges;
  
  public Node(int i, String string) {
	this.indexNumber = i;
	this.name = string;
	myedges = new ArrayList<Edge>();
}
  
 // each node has an edge
  public int getDistanceFromSource() {
    return distanceFromSource;
  }
  
  
  public void setDistanceFromSource(int distanceFromSource) {
    this.distanceFromSource = distanceFromSource;
  }
  
  
  public boolean isVisited() {
    return visited;
  }
  
  
  public void setIndexNumber(int index){
	  this.indexNumber = index;
  }
  
  
  public int getIndexNumber(){
	  return indexNumber;
  }
  public void setName(String name){
	  this.name = name;
  }
  
  
  public String getName(){
	  return name;
  }
  
  
  public void setVisited(boolean visited) {
    this.visited = visited;
  }
  
  
 public ArrayList<Edge> getEdges() {
    return myedges;
  }
 
 
  public void setEdges(ArrayList<Edge> edges) {
    this.myedges = edges;
  }
  
  
  public void addEdge(Edge edgee){
	  this.myedges.add(edgee);
  }
  
}