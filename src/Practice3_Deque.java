import java.util.ArrayList;
import java.util.stream.IntStream;

//배열을 이용한 기본 데크 구현
class MyDeque3{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque3(int size){
        this.arr=new int[size+1];
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear+1)%this.arr.length == this.front;
    }

    public void increaseSize(){
        int[] arrTmp = this.arr.clone();
        this.arr = new int[this.arr.length*2];

        int start = (this.front + 1)%arrTmp.length;
        int end = (this.rear +1)%arrTmp.length;

        int idx = 1;
        for(int i=start; i!=end; i = (i+1)%arrTmp.length){
            this.arr[idx++]=arrTmp[i];
        }

        this.front=0;
        this.rear=idx-1;
    }
    public void addFirst(int data){
        if(this.isFull()){
            this.increaseSize();
        }

        this.arr[this.front] = data;
        this.front = (this.front -1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if(this.isFull()){
            this.increaseSize();
        }
        
        this.rear = (this.rear+1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;

        return this.arr[this.front];
    }

    public Integer removeLast(){
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear=(this.rear -1 + this.arr.length) % this.arr.length;
         
        return data;
    }

    public void addMiddle(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }
        int elements = this.rear-this.front;
        if(elements<0){
            elements = this.arr.length + elements; //최대 길이 - 공백 칸
        }

        int mid = (this.rear - elements/2 + this.arr.length) % this.arr.length + 1;

        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements/2 + this.arr.length) % this.arr.length;

        for(int i=start; i!=end; i = (i - 1 +this.arr.length)%this.arr.length){
            this.arr[i]=this.arr[(i-1+this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear + 1)%this.arr.length;
    }
    public void printDeque(){
        int start = (this.front+1) %this.arr.length;
        int end = (this.rear + 1) % this.arr.length;
        
        for(int i=start; i!=end; i=(i+1)%this.arr.length){
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }
}

public class Practice3_Deque {
    public static void main(String[] args) {
        MyDeque3 myDeque3 = new MyDeque3(5);
        //Front 부분 입력
        myDeque3.addFirst(1);
        myDeque3.addFirst(2);
        myDeque3.addFirst(3);
        myDeque3.addFirst(1);
        myDeque3.addFirst(2);
        myDeque3.addFirst(3);
        myDeque3.addFirst(1);;
        myDeque3.addFirst(2);
        myDeque3.addFirst(3);
        myDeque3.printDeque();

        //Rear 부분 입력
        myDeque3.addLast(10);
        myDeque3.addLast(20);
        myDeque3.addLast(30);
        myDeque3.printDeque();


        myDeque3.addMiddle(777);
        myDeque3.printDeque();

        //Front 부분 출력
        System.out.println(myDeque3.removeFirst());
        myDeque3.printDeque();

        //Rear 부분 출력
        System.out.println(myDeque3.removeLast());
        myDeque3.printDeque();

        myDeque3.addMiddle(777);
        myDeque3.printDeque();

        System.out.println(myDeque3.removeLast());
        System.out.println(myDeque3.removeLast());
        System.out.println(myDeque3.removeLast());
        System.out.println(myDeque3.removeLast());
        myDeque3.printDeque();
    }
}
