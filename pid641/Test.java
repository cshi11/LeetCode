package pid641;
// ["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
// [[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
public class Test{
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(4); // set the size to be 3
        circularDeque.insertFront(9);			// return true
        circularDeque.deleteLast();			// return true
        System.out.println(circularDeque.toString()); 
        circularDeque.getRear();
        circularDeque.getFront();
        circularDeque.getFront();
        circularDeque.deleteFront();
        System.out.println(circularDeque.toString()); 
        circularDeque.insertFront(6);			// return true
        circularDeque.insertLast(5);			// return true
        circularDeque.insertFront(9);			// return true
        circularDeque.getFront();			// return true
        circularDeque.insertFront(6);			// return true
        System.out.println(circularDeque.toString()); 
        // circularDeque.insertFront(4);			// return false, the queue is full
        // circularDeque.getRear();  			// return 2
        // circularDeque.isFull();				// return true
        // circularDeque.deleteLast();			// return true
        // System.out.println(circularDeque.toString()); 
        // circularDeque.insertFront(4);			// return true
        // circularDeque.getFront();			// return 4
        // System.out.println(circularDeque.toString()); 
    }
}