/*
**************************************************************************************************
*** ID                  : V00765211
*** Name                : Victoria Sahle
*** Date                : March 12, 2014
*** Program Name        : Node.java
*** Program Description : Assignment 4: Node class used for linked list implementaion LLStack.java
***                       the result of evaluating the expression. 
*** Program Input       : N/A
*** Program Output      : N/A
**************************************************************************************************
*/

public class Node<T>
{
	public T item;
	public Node next;
	
	//Default Constructor
	public Node()
	{
		item=null;
		next=null;
	}
	
	//Constructor: Item is equal to n, next is null
	public Node(T n)
	{
		item=n;
		next=null;
	}
	
	//Constructo: Item is equal to n, next is now equal to nextNode
	public Node(T n,Node nextNode )
	{
		item=n;
		next=nextNode;
	}
	
	//Get value of item
	public T getItem()
	{
		return item;
	}
	
	//Set value for item
	public void setItem(T newItem)
	{
		item=newItem;
	}
	
	//Get object next
	public Node getNext()
	{
		return next;
	}
	
	//Set next
	public void setNext(Node nextNode)
	{
		next=nextNode;
	}
}