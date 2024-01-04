//배열을 이용한 이진 트리 구성, 순회

class BinaryTree{
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data.clone();
    }

    public void preOrder(int idx) { //전위 순회 : 현 -> 왼 -> 오
        System.out.print(this.arr[idx]+" ");
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        if(left<this.arr.length){
            this.preOrder(left); //왼쪽을 재귀적으로 우선적으로 처리
        }

        if(right<this.arr.length){
            this.preOrder(right);
        }

    }

    public void inOrder(int idx) { //왼 -> 현 -> 오
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < this.arr.length){
            inOrder(left);
        }

        System.out.print(this.arr[idx]+" ");

        if(right < this.arr.length){
            inOrder(right);
        }

    }

    public void postOrder(int idx) { // 왼 -> 오 -> 현
        int left = idx*2 + 1;
        int right = idx*2 + 2;

        if(left<this.arr.length){
            postOrder(left);
        }

        if(right<this.arr.length){
            postOrder(right);
        }

        System.out.print(this.arr[idx]+" ");
    }

    public void levelOrder(int idx) {
        for(int i=idx; i<arr.length; i++){
            System.out.print(this.arr[i]+" ");
        }
    }
}
public class Practice1_BinaryTree {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for(int i=0; i<arr.length; i++){
            arr[i]=(char)('A'+i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }


}
