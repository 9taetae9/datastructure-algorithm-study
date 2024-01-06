//non-linear - binary search tree
//red-black tree - insertion

import java.util.LinkedList;
import java.util.Queue;

class Node5{
    int key;
    int color;
    Node5 left;
    Node5 right;
    Node5 parent;

    public Node5(int key, int color, Node5 left, Node5 right, Node5 parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree{
    static final int BLACK = 0;
    final int RED = 1;

    Node5 head;

    public void insert(int key) {
        Node5 checkNode = null;
        if(this.head == null){
            this.head = new Node5(key, BLACK, null, null, null);
        }else {
            Node5 cur = this.head;

            while(true){
                Node5 pre = cur;

                if(key<cur.key){
                    cur=cur.left;
                    if(cur == null){
                        pre.left = new Node5(key, RED, null, null, pre);
                        checkNode = pre.left; //rebalancing point
                        break;
                    }
                }else{
                    cur = cur.right;

                    if(cur == null){
                        pre.right= new Node5(key, RED, null, null, pre);
                        checkNode = pre.right;
                        break;
                    }
                }
            }
            reBalance(checkNode);
        }
    }

    private void reBalance(Node5 node) {
        while(node.parent != null && node.parent.color == RED){
            Node5 silbling = null;

            if(node.parent == node.parent.parent.left){
                silbling = node.parent.parent.right;
            } else{
                silbling = node.parent.parent.left;
            }

            if(silbling != null && silbling.color == RED){ //recoloring
                node.parent.color = BLACK;
                silbling.color = BLACK;
                node.parent.parent.color = RED;

                if(node.parent.parent == this.head){
                    node.parent.parent.color = BLACK;
                    break;
                }else {
                    node = node.parent.parent;
                    continue;
                }
            }else{ //restructuring
                if(node.parent == node.parent.parent.left){
                    if(node == node.parent.right){
                        node = node.parent;
                        //rotate
                        leftRotate(node);
                    }

                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                }else if(node.parent == node.parent.parent.right){
                    if(node == node.parent.left){
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(Node5 node){
        if(node.parent == null){
            Node5 rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent =this.head;
            this.head.parent = rNode;
            rNode.left =this.head;
            rNode.parent = null;
            this.head =rNode;
        }else{
            if(node == node.parent.left){
                node.parent.left = node.right;
            }else{
                node.parent.right = node.right;
            }

            node.right.parent = node.parent;
            node.parent = node.right;

            if (node.right.left != null) {
                node.right.left.parent =node;
            }

            node.right =node.right.left;
            node.parent.left=node;
        }
    }

    public void rightRotate(Node5 node){
        if(node.parent == null){
            Node5 lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent =this.head;
            this.head.parent = lNode;
            lNode.right =this.head;
            lNode.parent = null;
            this.head =lNode;
        }else{
            if(node == node.parent.left){
                node.parent.left = node.left;
            }else{
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != null) {
                node.left.right.parent =node;
            }

            node.left =node.left.right;
            node.parent.right=node;
        }
    }
    public void levelOrder(Node5 node){
        char[] color = {'B','R'};

        Queue<Node5> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node5 cur = queue.poll();

            System.out.print("["+color[cur.color]+"]"+cur.key+" ");
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
public class Practice5_BST {
    public static void main(String[] args) {
        RedBlackTree rbTree =new RedBlackTree();

        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(20);
        rbTree.levelOrder(rbTree.head);
    }
}
