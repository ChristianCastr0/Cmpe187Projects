
/**
 * Linked list
 * @author Christian Castro
 * @version 1.0	2/17/2019
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
	 * Postcondition: Node is added to the linked list and references are updated
	 */
	public void append(Node newNode) {
		//if empty
		if(head==null) {
			head=newNode;
		}
		else {
			Node current=head;
			Node next=current.next;
	
			//iterate through linked list to find end
			while(next!=null) {
				current=next;
				next=current.next;
			}
			//Update node variables
			current.next=newNode;
		}
	}
	
	/**
	 * deletes node of a given value from linked list
	 * @param value value of node
	 * @return String Status of deletion
	 * Precondition: Node with given value must be present within the linked list
	 * Postcondition: Node will be deleted from link list and all remaining references will be updated
	 */
	public String delete(int value) {
		Node current=head;
		Node next=current.next;
		
		//Empty List
		if(head==null) {
			return "List is already empty.";
		}
		//One node in list
		else if(next==null&&value==head.value) {
			head=null;
		}
		//Head is target
		else if(value==head.value&&next!=null) {
			head.next=next.next;
			head=next;
		}
		else {
			Node previous=null;
			
			//iterate through list for given value
			while(current.value!=value) {
				if(current.next==null) {
					return "Node is not present in the list.";
				}
				//Go to next number
				previous=current;
				current=next;
				next=next.next;
			}
			//Update node variables
			previous.next=next;
		}
		return "Node with value of "+value+" was deleted";
	}
	
	/**
	 * Calculates length of list
	 * @return number of nodes in the linked list
	 */
	public int length() {
		int count=0;
		Node current=head;
		
		while(current!=null) {
			count++;
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
		String list="";
		
		//if List is empty
		if(current==null) {
			return "Empty";
		}
		//Add values in list to string
		else {
			list+=current.value;
			while(current.next!=null) {	
				list+=(" "+current.next.value);
				current=current.next;
			}
		}
		return list;
	}
}
