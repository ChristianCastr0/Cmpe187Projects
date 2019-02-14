
/**
 * Circular doubly linked list
 * @author Christian Castro
 *@version 1.0	9/19/2018
 */
public class LinkedList {
	private Node head;
	
	public LinkedList() {
		head=null;
	}
	
	/**
	 * Method to get head of linked list
	 * @return Node
	 */
	public Node getHead() {
		return head;
	}
	
	/**
	 * Adds node to the end of the linked list
	 * @param newNode new node to be added
	 * Precondition: None
	 * Postcondition: Node is added to the linked list and all references are updated
	 */
	public void append(Node newNode) {
		Node current=head;

		//if empty
		if(current==null) {
			head=newNode;
			head.next=head;
			head.prev=head;
		}
		else {
			//iterate through linked list to find end
			while(current.next.value!=head.value)
				current=current.next;
			
			current.next=newNode;
			newNode.prev=current;
			newNode.next=head;
			head.prev=newNode;
		}	
	}
	
	/**
	 * deletes node of a given value from linked list
	 * @param value value of node
	 * Precondition: Node with given value must be present within the linked list
	 * Postcondition: Node will be deleted from link list and all remaining references will be updated
	 */
	public void delete(int value) {
		Node current=head;
		Node previous=current.prev;
		Node next=current.next;
		//One node
		if(head.value==value&&head.next.value==head.value) {
			head=null;
		}
		//Delete head
		else if(head.value==value) {
			head=next;
			head.next=next.next;
			head.prev=current.prev;
			previous.next=head;
		}
		else {
			//iterate through list for given value
			while(current.value!=value) {
				//Gone through whole list and not found
				if(current.next.value==head.value) {
					System.out.println("Node is not present in the list.");
					return;
				}
				//Go to next number
				current=current.next;
				previous=current.prev;
				next=current.next;
			}
			previous.next=current.next;
			next.prev=previous;
		}
	}
	
	/**
	 * Calculates the length of the linked list
	 * @return count number of nodes in the linked list
	 */
	public int length() {
		Node current=head;
		int count=0;
		boolean end=false;
		while(end!=true&&head!=null) {
			count+=1;
			if(current.next.value==head.value)
				end=true;
			current=current.next;
		}
		return count;
	}
	
	/**
	 * Checks to see if the linked list is empty
	 * @return True or false depending on if there is a head
	 */
	public boolean isEmpty() {
		if(head==null)
			return true;
		return false;
	}
	
	/**
	 * displays all the node values present in the linked list
	 * @return String containing values of Linked List in order
	 */
	public String contents() {
		Node current=head;
		boolean end=false;
		String list="";
		
		//if List is empty
		if(current==null)
			end=true;

		//While not at end of List add value to string
		while(end!=true) {	
			list+=(current.value+" ");
			current=current.next;
			if(current.value==head.value)
				end=true;
		}
		return list;
	}
}
