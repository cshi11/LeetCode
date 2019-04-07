package pid641;

class MyCircularDeque {

    private int[] queue;
    int front, rear, size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if(k == 0)   queue = null;
        else{
            queue = new int[k + 1];
            front = 0;
            rear = 0;
            size = k + 1;
        }
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())    return false;
        if(front == 0){
            queue[size - 1] = value;
            front = size - 1;
        }else{
            queue[front - 1] = value;
            front --;
        }
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())    return false;
        queue[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())   return false;
        front = (front + 1) % size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())   return false;
        if(rear == 0){
            rear = size - 1;
        }else{
            rear --;
        }
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())   return -1;
        return queue[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())   return -1;
        if(rear == 0){
            return queue[size - 1];
        }else{
            return queue[rear - 1];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }


    public String toString() {
        String res = "queue : ";
        for(int i = front; i != rear; i = (i + 1) % size){
            res += queue[i];
        }
        res += " front = " + front + " rear = " + rear;
        return res;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */