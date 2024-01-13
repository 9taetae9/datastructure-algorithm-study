public class Practice1_FloydWarshall {

    static int[][] dist;
    static final int INF = 1000000000; // Integer.MAX_VALUE로 설정시 더하기 연산 과정에서 오버플로 발생

    private static void floyWarshall(int v, int e, int[][] data, int start){
        dist = new int[v+1][v+1];
        for(int i=1; i<v+1; i++){
            for(int j=1; j<v+1; j++){
                if(i != j){
                    dist[i][j] = INF;
                } // 대각 성분은 생성했을 때 0인 것으로 유지
            }
        }

        for(int i=0; i<e; i++){
            dist[data[i][0]][data[i][1]] = data[i][2]; //인접한 노드들과 거리 업데이트
        }

        for(int k=1; k<v+1; k++){
            //i -> j (i->k->j k를 거쳐서 가는 경로가 더 짧을 때 업데이트)
            for(int i=1; i<v+1; i++){
                for(int j=1; j<v+1; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j]=Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        boolean isNegativeCycle = false;

        //출력
        for(int i=1; i<v+1; i++){
            for(int j=1; j<v+1; j++){
                if(dist[i][j] >= INF){
                    System.out.printf("%5s ","INF");
                }else{
                    System.out.printf("%5d ", dist[i][j]);
                }
                if(i == j && dist[i][j] <0 ){
                    isNegativeCycle = true;
                }
            }
            System.out.println();
        }

        if(isNegativeCycle){
            System.out.println("Negative cycle detected! Shortest path calculations may not be accurate.");
        }

        System.out.println();
    }


    public static void main(String[] args) {

        int[][] data = {{1,2,8},{1,3,6},{1,5,5},{2,3,-5},{2,4,1},{2,6,4},{3,4,4}, {4, 7,3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floyWarshall( 7, 11, data, 1);

        //when negative cycle exists
        data = new int[][]{{1, 2, 8} , {1, 3, 6}, {1, 5, 5} , {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floyWarshall( 7, 11, data, 1);
    }


}
