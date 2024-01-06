import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree2{
    Node head;

    BinarySearchTree2(int key){
        this.head = new Node(key, null, null);
    }

    public Node addNodeRecursive(Node cur, int key){
        if(cur == null){
            return new Node(key, null,null);
        }

        if(key< cur.key){
            cur.left = addNodeRecursive(cur.left, key);
        }else {
            cur.right = addNodeRecursive(cur.right, key);
        }

        return cur;
    }

    public Node removeNodeRecursive(Node cur, int key){
        if(cur == null){
            return null;
        }

        if(key<cur.key){
            cur.left = removeNodeRecursive(cur.left, key);
        }else if(key> cur.key){
            cur.right = removeNodeRecursive(cur.right,key);
        }else {
            if(cur.left == null){ //삭제하려는 노드의 왼쪽 또는 오른쪽 자식노드가 없는 경우
                return cur.right; //오른쪽 또는 왼쪽 자식이 있다면 해당 노드 리턴 없다면 null 리턴
            } else if(cur.right == null){
                return cur.left;
            } else { //자식 노드가 두개인경우 -> 둘 중 하나 올린다
                Node predecessor = cur;
                Node succesor = cur.left;

                while(succesor.right != null){
                    predecessor = succesor;
                    succesor = succesor.right;
                }
                predecessor.right = succesor.left;
                cur.key = succesor.key; //해당 노드 위치 자리의 데이터만 변경
            }
        }


        return cur;
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.key +" ");
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
public class Practice2_BST {
    public static void main(String[] args) {
        //노드 삽입
        BinarySearchTree2 bst = new BinarySearchTree2(20);
        bst.head = bst.addNodeRecursive(bst.head, 10);
        bst.head = bst.addNodeRecursive(bst.head, 30);
        bst.head = bst.addNodeRecursive(bst.head, 1);
        bst.head = bst.addNodeRecursive(bst.head, 15);
        bst.head = bst.addNodeRecursive(bst.head, 25);
        bst.head = bst.addNodeRecursive(bst.head, 13);
        bst.head = bst.addNodeRecursive(bst.head, 35);
        bst.head = bst.addNodeRecursive(bst.head, 27);
        bst.head = bst.addNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);

        //노드 삭제
        bst.head = bst.removeNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head, 25);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head, 20);
        bst.levelOrder(bst.head);
    }
}
