//연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    char data;
    Node3 left;
    Node3 right;

    public Node3(char data, Node3 left, Node3 right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class BinaryTree2{
    Node3 head;

    BinaryTree2(){}
    BinaryTree2(char[] arr){
        Node3[] nodes = new Node3[arr.length];
        for(int i=0; i<arr.length; i++){
            nodes[i] = new Node3(arr[i], null, null);
        }

        for(int i=0; i<arr.length; i++){
            int left = 2*i+1;
            int right = 2*i+2;

            if(left < arr.length){
                nodes[i].left = nodes[left];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
            }
        }

        this.head = nodes[0];
    }

    public void preOrder(Node3 node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node3 node){
        if(node == null){
            return;
        }

        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);

    }

    public void postOrder(Node3 node){
        if(node == null){
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");

    }

    public void levelOrder(Node3 node){
        Queue<Node3> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node3 cur = queue.poll();

            System.out.print(cur.data + " "); //현재 노드 데이터 출력
            if(cur.left != null){
                queue.offer(cur.left); //왼쪽 자식 노드 존재할 경우 큐에 다시 넣기
            }
            if(cur.right != null){
                queue.offer(cur.right); //오른쪽 자식 노드 존재할 경우 큐에 다시 넣기
            }

        }
    }
}
public class Practice2_BinaryTree {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for(int i=0; i<arr.length; i++){
            arr[i]=(char)('A'+i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
