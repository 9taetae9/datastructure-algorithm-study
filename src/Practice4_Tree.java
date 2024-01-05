//종이 접기
//종이를 반으로 접었을 때, 안으로 파인 부분은 0, 볼록 튀어나온 부분은 1
//종이를 접을 때는 오른쪽에서 왼쪽으로 접는다.
//종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성하시오.


//입력 : 3
//출력 
public class Practice4_Tree {

    public static void solution(int n){
        int[] binaryTree = new int[(int)Math.pow(2,n)];

        binaryTree[0]=0;
        for(int i=0; i<(int)Math.pow(2,n-1)-1; i++){
            binaryTree[i*2 + 1]=0;
            binaryTree[i*2 + 2]=1;
        }

        inOrder(binaryTree, 0);
        System.out.println();
    }

    public static void inOrder(int[] arr, int idx){
        int left = 2*idx +1;
        int right =2*idx +2;

        if(left < arr.length - 1){
            inOrder(arr,left); //재귀적으로 좌측으로 파고 들어가 왼쪽 노드부터 출력하게 된다
        }

        if(idx==arr.length-2)
            System.out.print(arr[idx]);
        else
            System.out.print(arr[idx]+", ");

        if(right< arr.length-1){
            inOrder(arr, right);
        }
    }
    public static void main(String[] args) {
        solution(1);
        solution(2);
        solution(3);
    }
}
