import java.util.LinkedList;
import java.util.Queue;

class Node4{
    int key;
    int height;
    Node4 left;
    Node4 right;

    public Node4(int key, Node4 left, Node4 right){
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree{
    Node4 head;

    public int height(Node4 node){
        if(node == null) return -1;
        return  node.height;
    }

    public Node4 rightRotate(Node4 node){
        Node4 lNode = node.left;

        node.left = lNode.right;
        lNode.right = node;

        node.height = Math.max(height(node.left), height(node.right))+1;
        lNode.height = Math.max(height(lNode.left),height(lNode.right))+1;

        return lNode;
    }

    public Node4 leftRotate(Node4 node){
        Node4 rNode = node.right;

        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(height(node.left),height(node.right))+1;
        rNode.height = Math.max(height(rNode.left),height(rNode.right))+1;

        return rNode;
    }

    public Node4 lrRotate(Node4 node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public Node4 rlRotate(Node4 node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(Node4 node){
        if(node == null){
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    public void insert(int key) {
        this.head = insert(this.head,key);
    }

    public Node4 insert(Node4 node, int key){
        if(node == null){
            return new Node4(key, null, null);
        }

        if(key < node.key){
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right,key);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        int balance = getBalance(node);

        //LL
        if(balance > 1 && key<node.left.key){ //새로들어온 키값이 left의 키값 보다 작은 경우 ll case
            return rightRotate(node);
        }
        //LR
        if(balance > 1 && key>node.left.key){
            return lrRotate(node);
        }
        //RR
        if(balance < -1 && key>node.right.key){
            return leftRotate(node);
        }
        //RL
        if(balance < -1 && key<node.right.key){
            return rlRotate(node);
        }

        return node;
    }

    public void levelOrder(Node4 node){
        Queue<Node4> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node4 cur = queue.poll();

            System.out.print(cur.key + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}
public class Practice3_BST {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        //insert
        avl.insert(30);
        avl.insert(20);
        avl.insert(10); //LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50); //RR
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7); //LR
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55); //RL
        avl.levelOrder(avl.head);
    }
}
