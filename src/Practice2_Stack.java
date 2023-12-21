//배열 이용한 기본 스택 구현
class MyStack2{
    int[] arr;
    int top = -1; //아무것도 없는 초기 상태

    MyStack2(int size){
        arr = new int[size];
    }

    public boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(this.top == this.arr.length-1){
            return true;
        }
        return false;
    }

    public void push(int data){
        if(this.isFull()){
            System.out.println("stack is full already!");
            return ;
        }

        this.top +=1;
        this.arr[this.top]=data;
        return ;
    }

    public Integer pop(){
        if(this.isEmpty()){
            System.out.println("stack is empty!");
            return null;
        }
        int data = this.arr[this.top];
        this.top -=1;
        return data;
        //data는 남아있음
    }

    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("stack is Empty!");
            return null;
        }
        return this.arr[this.top];
    }

    public void printStack(){
        for(int i=0; i<this.top+1; i++){
            System.out.print(this.arr[i]+" ");
        }
    }
}

public class Practice2_Stack {
    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2(5);
        System.out.println(myStack2.isEmpty());
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        myStack2.push(4);
        myStack2.push(5);
        myStack2.printStack();

        System.out.println(myStack2.peek());
        myStack2.printStack();

        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        myStack2.printStack();

        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        myStack2.printStack();
    }

}
