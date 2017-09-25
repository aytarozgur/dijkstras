
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


//Edge class used for ArrayList of Edges in Node class 
public class Edge {
	  private int fromNodeIndex;
	  private int toNodeIndex;
	  private int length;
	  public Edge(int fromNodeIndex, int toNodeIndex, int length) {
	    this.fromNodeIndex = fromNodeIndex;
	    this.toNodeIndex = toNodeIndex;
	    this.length = length;
	  }
	  
	  
	  public int getFromNodeIndex() {
	    return fromNodeIndex;
	  }
	  
	  
	  public int getToNodeIndex() {
	    return toNodeIndex;
	  }
	  
	  
	  //the distance between the fromNode and toNode
	  public int getLength() {
	    return length;
	  }
	  
	  
	  //returns the index of the neighboring node, based on the edges connected to it 
	  public int getNeighborIndex(int nodeIndex) {
	    if (this.fromNodeIndex == nodeIndex) {
	      return this.toNodeIndex;
	    } else {
	      return this.fromNodeIndex;
	   }
	  }
	  
	}