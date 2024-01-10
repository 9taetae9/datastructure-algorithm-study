//Center Node 찾기
//Undirected 그래프에서 center node를 출력하세요.
//Center node : 다른 모든 노드와 연결된 노드
//다른 모드와 연결된 노드는 하나인 것으로 가정
//
//입력 그래프 : {{1,2},{2,3},{4,2}}
//출력:2
//
//입력 그래프 : {{1,2},{5,1},{1,3},{1,4}}
//출력:1


// center node의 특징 => 모든 노드와 연결되어 있으므로 (전체노드수 -1)개와 연결된 노드
//연결된 노드 개수 최대
// center node는 어느 간선에도 center node는 포함되어 있다는 특성 //비교하여 교집합

public class Practice5_Graph {
    public static int solution(int[][] e){
        MyGraphMatrix graph = new MyGraphMatrix(e.length+1); //노드 수 = 에지수 + 1

        for(int i=0; i<e.length; i++){
            graph.addEdge(e[i][0]-1, e[i][1]-1); //노드번호 - 1 =>인덱스
        }

        int[] edgeCnt = new int[e.length + 1];
        for(int i=0; i<graph.adjMat.length; i++){
            for(int j=0; j<graph.adjMat[i].length; j++){
                if(graph.adjMat[i][j] == 1){
                    edgeCnt[i] += 1;
                }
            }
        }

        int maxCnt = -1;
        int maxIdx = -1;
        for(int i =0; i<edgeCnt.length; i++){
            if(maxCnt<edgeCnt[i]){
                maxCnt = edgeCnt[i];
                maxIdx = i;
            }
        }

        return maxIdx + 1;
    }

    public static int solution2(int[][] e){
        return e[0][0]==e[1][0]||e[0][0]==e[1][1] ? e[0][0] : e[0][1];
    }
    public static void main(String[] args) {
        int[][] edges ={{1,2},{2,3},{4,2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();

        edges = new int[][]{{1,2},{5,1},{1,3},{1,4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();
    }
}
