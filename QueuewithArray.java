public class QueueWithArray {

    int[] arr;
    private int front;
    private int rear;
    private int size;

    public QueueWithArray() {
        // TODO Auto-generated constructor stub
        arr = new int[5];
        front = -1;
        rear = -1;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void enqueue(int data) {

        if(isEmpty()) {
            front = 0;
        }
        if(size == arr.length) {
            doubleCapacity();
        }
        rear  = (rear+1) % arr.length;
        arr[rear] = data;
        size++;
    }
    private void doubleCapacity() {

        int temp[] = arr;
        arr = new int[temp.length * 2];
        int k=0;
        for(int i=front;i<temp.length;i++) {
            arr[k++] = temp[i];
        }
        for(int i=0;i<front;i++) {
            arr[k++] = temp[i];
        }
        front = 0;
        rear = k-1;

    }
    public int dequeue() {

        if(isEmpty()) {
            System.out.println("Underflow");
        }
        int temp = arr[front];
        front = (front+1) % arr.length;
        size --;
        if(size==0) {
            front = -1;
            rear = -1;

        }
        return temp;
    }
    public int front() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
        }
        return arr[front];
    }


}