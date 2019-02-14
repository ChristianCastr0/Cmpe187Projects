/**
 * Node elements that carry an int value and have references to the node behind and in front of it
 * @author Christian Castro
 * @version 1.0	9/19/2018
 */
public class Node {
	int value;
	Node prev;
	Node next;
	
	public Node(int value){
		this.value=value;
		prev=null;
		next=null;
	}
}
