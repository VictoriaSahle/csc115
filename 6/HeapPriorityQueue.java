/*
 * HeapPriorityQueue.java
 *
 * CSC 115: Assignment 6 sample code.
 *
 * Comments from the sample solution:
 *
 * An implementation of a PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 * 
 * However, this implementation maintains the 
 * complete binary tree as a protected array, not a distinct class.
 *
 * I have also removed the Comparator from the code.  It is a
 * good practice to make a Priority Queue generic, but I think it
 * makes the code too complicated for our purposes.
 *
 * Instead, we will rely on the Comparable interface that is implemented
 * by Objects and their subclasses (although if you define your own class
 * you will need to implement the compareTo method to return something
 * meaningfull)
 *
 * I have also removed the Entry interface.  This priority queue only deals
 * with keys.
 */
 
 /*
************************************************************************************************
*** ID                  : V00765211
*** Name                : Victoria Sahle
*** Date                : April 1, 2014
*** Program Name        : HeapPriorityQueue.java
*** Program Description : Assignment 6: Implement the Priority Queue interface using a Heap data 
***                       structure.The heap will store objects that implement the Comparable 
***                       interface. Pass all 53 test cases.
*** Program Input       : Tests from a6tester.java.
*** Program Output      : Results from testing with a6tester.java. Pass/Fail.
************************************************************************************************
*/
public class HeapPriorityQueue implements PriorityQueue
{
        protected final static int DEFAULT_SIZE = 10000;
      
        /* This array is where you will store the elements in the heap */
        protected Comparable storage[];
        /* Keep track of the current number of elements in the heap */
        protected int currentSize;
                      
        /* Default Constructor */
        public HeapPriorityQueue ()
        {
                this(DEFAULT_SIZE);
        }
        /* Constructor */
        public HeapPriorityQueue(int size)
        {
                storage = new Comparable[size + 1];
                currentSize = 0;
        }
      
        /*
        ************************************
        * Method Name : size
        *       Input : N/A
        *     Purpose : Return size of heap.
        ************************************
        */
        public int size ()
        {
                return currentSize;
        }
        
        /*
        **************************************************************
        * Method Name : isEmpty
        *       Input : N/A
        *     Purpose : Find out if heap is empty. Returns true/false.
        **************************************************************
        */
        public boolean isEmpty ( )
        {
                return size() == 0;
        }
        
        /*
        ***************************************************************************
        * Method Name : removeMin
        *       Input : N/A
        *     Purpose : Remove the smallest element in the heap. Call bubbleDown to 
        *               ensure every element is in correct positioning.
        ***************************************************************************
        */
        public Comparable removeMin () throws HeapEmptyException
        { 
            // Throw exception if heap is empty
            if (this.isEmpty()) {
                throw new HeapEmptyException();
            }
            // Swap last element with first element(min)
            Comparable value = storage[1];
            storage[1] = storage[currentSize];
            // Remove min
            storage[currentSize] = null;
            currentSize--;
            // Call "bubble down"
            bubbleDown();
            // Return min value
            return value;
        }
        
        /*
        ***************************************************************************
        * Method Name : insert
        *       Input : Comparable k
        *     Purpose : Insert new Comparable value into the heap. Call bubbleUp to
        *               place element in correct position.
        ***************************************************************************
        */
        public void insert ( Comparable k  ) throws HeapFullException
        {     
            currentSize++;
            int index = currentSize;
            // Put new elelment into heap (last position)
            storage[index] = k;
            // 	Call "bubble up"
            bubbleUp();
        }
        
        /*
        **************************************************************************
        * Method Name : bubbleUp
        *       Input : N/A
        *     Purpose : A new value has just been added to the bottom of the heap,
        *               "bubble up" until it is in the correct position.
        **************************************************************************
        */
        private void bubbleUp ( )
        {
            int index = this.currentSize;
            // Compare value with it's parent
            // Swap while the value is smaller than parent
            while (index > 1
                && (storage[parent(index)].compareTo(storage[index]) > 0)) {
                swapElement(index, parent(index));
                index = parent(index);
            }
        }
        
        /*
        ***************************************************************
        * Method Name : bubbleDown
        *       Input : N/A
        *     Purpose : "bubble down" until it is in the right position
        ***************************************************************
        */
        private void bubbleDown()
        {
            int i = 1;
            
            while (hasLeft(i)) {
            // Chose min value to be left child	    
            int min = leftChild(i);
 
            // If the element has a right child, and left is greater than right, chose right child for min
            if (hasRight(i) && storage[leftChild(i)].compareTo(storage[rightChild(i)]) > 0) {
                min = rightChild(i);
            } 
            // Compare min element with parent, swap if parent is greater
            if (storage[i].compareTo(storage[min]) > 0) {
                swapElement(i, min);
            } else {
                break;
            }
 
            // index is now starting from left/right child
            i = min;
            }
        } 
        
        /*
        *****************************************************************************
        * Method Name : swapElement
        *       Input : int p1, int p2
        *     Purpose : Swap the element at position p1 in the array with the element
        *               at position p2.
        *****************************************************************************
        */
        private void swapElement ( int p1, int p2 )
        {
            Comparable cmpVal = storage[p1];
            storage[p1] = storage[p2];
            storage[p2] = cmpVal;
        }
        
        /*
        ******************************************************************
        * Method Name : parent
        *       Input : int pos
        *     Purpose : Return the index of the parent of the node at pos
        ******************************************************************
        */
        private int parent ( int pos )
        {
        	int index = 0;
                index = pos / 2;
                               
                return index;
        }
        
        /*
        **********************************************************************
        * Method Name : leftChild
        *       Input : int pos
        *     Purpose : Return the index of the left child of the node at pos
        **********************************************************************
        */
        private int leftChild ( int pos )
        {
                int index = 0;
                index = pos * 2;
                               
                return index;
        }
        
        /*
        ***********************************************************************
        * Method Name : rightChild
        *       Input : int pos
        *     Purpose : Return the index of the right child of the node at pos
        ***********************************************************************
        */
        private int rightChild ( int pos )
        {     
                int index = 0;
                index = (pos * 2) + 1;
                               
                return index;
        }
        
        /*
        ***************************************************************************
        * Method Name : hasLeft
        *       Input : int pos
        *     Purpose : Given the current number of elements in the heap, does the
        * 		node at pos have a left child? Note that all internal nodes 
        *               have at least a left child.
        ***************************************************************************
        */
        private boolean hasLeft ( int pos )
        {
               return leftChild(pos) <= currentSize;       
        }
        
        /*
        **************************************************************************
        * Method Name : hasRight
        *       Input : int pos
        *     Purpose : Given the current number of elements in the heap, does the
        *               node at pos have a right child?
        **************************************************************************
        */  
        private boolean hasRight ( int pos )
        {
                return rightChild(pos) <= currentSize;
                               
        }
}
