import java.sql.Array;

class MyQueue2{
    //원형 큐
    int[] arr;
    int front = 0;
    int rear = 0;
    MyQueue2(int size){
        arr = new int[size+1]; //rear, front 같은 곳 포인팅하는 빈 상황.
    }

    public boolean isEmpty(){
        return this.rear==this.front;
    }

    public boolean isFull(){
        return (this.rear+1) % this.arr.length == this.front; //한칸 더 가면 길이의 배수이므로
    }

    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is full!");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length; //rear++
        this.arr[this.rear] = data;
    }

    public Integer dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public void printQueue(){
        int start= (this.front+1)%this.arr.length;
        int end = (this.rear +1)%this.arr.length;

        for(int i= start; i!=end; i=(i+1)%this.arr.length){
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }
}
public class Practice2_Queue {
    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);

        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.printQueue();
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.dequeue();
    }
}
