//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 2
//
// Implements StackInterface using a linked list to hold the elements.
//-----------------------------------------------------------------------

package assign3LS;
/*** COSC 2100 –Spring 2021
 * Assignment#3
 * Use tacks to implement the book check-in process at a library
 *  @author Gary Olson
 * I added a variable for length and is incremented by the push method, 
 * then returned by the size method
***/
public class LinkedStack<T> implements StackInterface<T>
{
	protected LLNode<T> top;   // reference to the top of this stack
	protected int length; // variable for length or "Size" of stack
	public LinkedStack()
	{
		top = null;
		length = 0;
	}

	public void push(T element)
	// Places element at the top of this stack.//Advances the length accumulator +1
	{ 
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
		length++;
	}     

	public void pop()
	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
	{                  
		if (isEmpty())
			throw new StackUnderflowException("Pop attempted on an empty stack.");
		else
			top = top.getLink();
			
	}

	public T top()
	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element of this stack.
	{                 
		if (isEmpty())
			throw new StackUnderflowException("Top attempted on an empty stack.");
		else
			return top.getInfo();
	}

	public boolean isEmpty()
	// Returns true if this stack is empty, otherwise returns false.
	{              
		return (top == null); 
	}

	public boolean isFull()
	// Returns false - a linked stack is never full
	{              
		return false;
	}
	public void clear() {
		while(!isEmpty())
			pop();
	}
	public int size() 
	//Returns the number of elements in the stack
	{
		return length;
	}
	


}

