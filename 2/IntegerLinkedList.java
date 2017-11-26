/*
 * IntegerLinkedList.java
 *
 * This is the "stub" implementation of the IntegerList interface
 * provided to you as part of assignment 2.
 * 
 * Your task is to complete the implementation of all the methods
 * such that they meet the specifications defined both in 
 * IntegerList.java and in the assignment PDF.
 *
 * Except for the constructor, you should remove all the supplied code
 * from the methods and replace it with working code.  The supplied code
 * in the methods is just so that this file compiles and runs.
 *
 */
 
 /*
***************************************************************************************************
*** ID                  : xxxxxxxxx
*** Name                : Victoria Sahle
*** Date                : February 3, 2014
*** Program Name        : IntegerLinkedList.java
*** Program Description : Assignment 2: This program implements an IntegerList interface to create
***			  an Array List.
*** Program Input       : -IntegerList.java
***			  -IntegerNode.java
*** Program Output      : Report (passing of test cases 0-22(23 total)) to the console.
***************************************************************************************************
*/

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode	head;
	private IntegerNode	tail;

	private	int		count;

	public IntegerLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{
		//Create new node
		//Assign value of parameter x
		IntegerNode newNode = new IntegerNode(x);
		//If head is empty (list is empty)
		if(head == null){			
			tail = newNode;			
		} else {
			//If head is not empty (list contains some element)
			head.prev = newNode;
			newNode.next = head;
		}
		//Assign head to newNode
		head = newNode;
		//Increase number of nodes in count
		count++;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */	
	public void addBack (int x)
	{
		//Create new node
		//Assign value of parameter x
		IntegerNode newNode = new IntegerNode(x);
		//If list is empty assign head to be newNode
		if(head == null){
			head = newNode;
		
		}else{
			//If list is not empty
			//Add to end of list
			tail.next = newNode;
			newNode.prev = tail;
		}
		//Assign tail to newNode
		tail = newNode;
		//Increase number of nodes in count
		count++;
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *                                                                                                                                
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}
	
	/* 
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 * 
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		//Assign temporary value to head
		IntegerNode temp = head;
                int x = 0;
                //Loop through until position is found
                for (int i = 0; i < count; i++) {
                    if (i == pos){
                    	//Store value in specific position as an integer value
                        x = temp.value;
                        //Leave loop once value is found
                        break;
                    }
                    //Check for null pointer
                    if (temp.next != null)
                    	//Traverse through list using temp
                        temp = temp.next;
 
                }
                //Return value at requested position
                return x;
	}
	
	/* 
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{
		head = null;
		count = 0;
	}

	/* 
	 * PURPOSE:
	 *   Remove all instances of value from the list. 
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{
		//Assign temporary value to head
		IntegerNode temp = head;
		//Check for null pointer	
		while(temp != null){
			//If list value is equal to parameter value
			//Continue check with 3 cases
			if(temp.value == value){
				//Only one node (head)
				if(temp == head){
					head = temp.next;
				//Requested node for removal is the tail
				} else if(temp == tail){
					tail = temp.prev;
				} else {
				//Requested node for removal is located somewhere other than first/last node
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				//Decrement count once node is removed
				count--;
			}
			//Traverse through list
			temp = temp.next;
		}
	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		//If list is empty
		if(head==null){
			return "{}";
		}
		//Else
		//Traverse through list and print
		String print = "{";
		IntegerNode temp = head;
		while(temp.next != null){
			print += temp.value + ",";
			temp = temp.next;
		}		
		return print + temp.value + "}";
		
	}	
	
}
