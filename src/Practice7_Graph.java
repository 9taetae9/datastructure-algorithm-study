//주어진 그래프를 두개의 그래프로 분리할 수 있는지 확인하는 프로그램을 작성하세요.
//분리조건 : 인접하지 않은 노드끼리 분리
//
//모든 노드는 연결되어 있다
//분리가능하면 true, 불가능하면 false 출력
//
//ex)
//그래프 : {{1,3},{0,2},{1,3},{0,2}}
// 0번 노드는 1,3에 연결
// 1번 노드는 0,2에 연결 ...
//출력: true
//
//그래프 : {{1,2,3},{0,2},{0,1,3},{0,2}}
//출력: false

//인접 노드로 옮기면서 부호를 다르게 설정 => 충돌 발생할 경우 false
public class Practice7_Graph {
    public static void solution(int[][] graph){
        int[] flags = new int[graph.length];

        if(checkSplit(graph, flags, 1, 0) == true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    public static boolean checkSplit(int[][] graph, int[] flags, int flag, int node){
        if(flags[node] !=0){
            return flags[node] == flag; //setting 하려고 했던 flag 값과 setting된 값이 동일하면 true
        }

        flags[node] = flag;
        for(int adjacentNode: graph[node]){
            if(!checkSplit(graph, flags, -flag, adjacentNode)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        solution(graph);

        graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        solution(graph);
    }
}
