/**
 * Node elements that carry an int value and have references to the node behind and in front of it
 * @author Christian Castro
 * @version 1.0	2/17/2019
 */
public class Node {
	int value;
	Node next;
	
	public Node(int value){
		this.value=value;
		next=null;
	}
}
