/**
 * Circular doubly linked list
 * @author Christian Castro
 *@version 1.0	9/19/2018
 */
public class LinkedList {
	Node head;
	
	public LinkedList() {
		head=null;
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
	 * Traverses the linked list by k and removes the corresponding number, repeats
	 * process until one node is left
	 * @param numPrisoners Defines number of nodes to be created in the linked list
	 * @param k number by which the prisoners are counted off
	 * @return Number of winning position/0 if invalid number of prisoners entered
	 * Precondition: Linked list has at least one element
	 * Postcondition: Linked list is narrowed down to one node 
	 */
	public int execution(int numPrisoners, int k) {
		LinkedList prisoners=new LinkedList();
		
		if(numPrisoners>0) {
			for(int i=1;i<=numPrisoners;i++) {
				Node node=new Node(i);
				prisoners.append(node);
			}
			
			Node current=prisoners.head;
			
			if(prisoners.length()>1) {
				while(prisoners.length()>1) {
					prisoners.display();
					for(int i=0;i<k;i++) {
						current=current.next;
					}
					prisoners.delete(current.value);
					//start count from next prisoner in line
					current=current.next;
				}
			}
			return prisoners.head.value;
		}
		return 0;
	}
	
	/**
	 * displays all the node values present in the linked list
	 */
	public void display() {
		Node current=head;
		boolean end=false;
		while(end!=true) {
			System.out.print(current.value+" ");
			current=current.next;
			if(current.value==head.value)
				end=true;
		}
		System.out.println("");
	}
}
