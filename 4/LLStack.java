/*
***************************************************************************************************
*** ID                  : V00765211
*** Name                : Victoria Sahle
*** Date                : March 12, 2014
*** Program Name        : LLStack.java
*** Program Description : Assignment 4: Implements the Stack interface (Stack.java) using a linked 
***                       list structure.
*** Program Input       : N/A
*** Program Output      : N/A
***************************************************************************************************
*/

import java.util.LinkedList;

public class LLStack<T> implements Stack<T>{
	
	private LinkedList<T> list;
	
	//Default Constructor
	public LLStack()
	{
		list = new LinkedList<T>();
	}
	
	//Check if Stack is empty
	public boolean empty()
	{
		if(list.size() != 0){
			return false;
		}
		return true;
	}
	
	//Get top element of Stack, does not remove it
	public T peek() throws StackEmptyException
	{
		if(list.isEmpty()){
			throw new StackEmptyException("");
		}
		return list.peek();
	}
	
	//Get top element of Stack and remove it
	public T pop() throws StackEmptyException
	{
		if(list.isEmpty()){
			throw new StackEmptyException("");
		}
		return list.pop();
	}
	
	//Push an element onto the Stack
	public void push(T element)
	{
		list.push(element);
	}
	
	//Returns the number of elements(size) of the Stack
	public int size()
	{
		return list.size();
	}
	
	//Remove all elements from the Stack
	public void makeEmpty()
	{
		list.clear();
	}
	
	//Gets String representation of all the elements in the Stack
	public String toString()
	{
		return list.toString();
	}
}
