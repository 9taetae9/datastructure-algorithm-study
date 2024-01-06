//주어진 이진 탐색 트리에서 N번째로 작은 수 구하기

//입력 트리 : 3, 1, 4, null, 2
//N : 1
//결과 : 1

//입력 트리 : 5, 3, 6, 2, 4, null, null, 1
//N : 3
//결과 : 3

import java.util.ArrayList;

//Node(int key, Node left, Node right)
public class Practice6_BST {
    public static void solution(Integer[] data, int n){
        BinarySearchTree bst = new BinarySearchTree(data[0]);

        for(int i=1; i<data.length; i++){
            if(data[i]==null) {
                continue;
            }

            bst.addNode(data[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(bst.head, list);
        System.out.println(list.get(n-1));
    }

    public static void inOrder(Node node, ArrayList list){
        if(node == null){
            return;
        }

        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }
    public static void main(String[] args) {
        Integer[] data = {3,1,4,null,2};
        int n=1;
        solution(data,n);

        data = new Integer[]{5,3,6,2,4,null,null,1};
        n=3;
        solution(data,n);
    }
}
