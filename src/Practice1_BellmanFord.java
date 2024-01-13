public class Practice1_BellmanFord {

    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void bellmanFord(int v, int e, int[][] data, int start){
        Edge[] edge = new Edge[e];
        for(int i=0; i<e; i++){
            edge[i] = new Edge(data[i][0],data[i][1],data[i][2]);
        }

        int[] dist = new int[v+1]; //1번 노드 부터 시용하기위함

        for(int i=1; i<v+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        boolean isNegativeCycle = false;
        for(int i=0; i< v+1; i++){
            for(int j=0; j<e; j++){
                Edge cur = edge[j];

                if(dist[cur.from] == Integer.MAX_VALUE){
                    continue;
                }

                if(dist[cur.to] > dist[cur.from] + cur.weight){
                    dist[cur.to] = dist[cur.from] + cur.weight;
                    //cur.to(cur의 목적지) 노드의 기존 dist 값 > cur.from(현재 cur까지) 노드의 dist 값 + (cur.to 노드로 가는 weight값)

                    if(i == v){ //마지막 추가 1번 반복 돌릴때  바뀐 값이 있다면 => 음수 사이클 존재
                        isNegativeCycle = true;
                    }
                }
            }
        }

        System.out.println("음수 사이클 발생 : "+ isNegativeCycle);
        for(int i=1; i<v+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            }
            else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,8},{1,3,6},{1,5,5},{2,3,-5},{2,4,1},{2,6,4},{3,4,4}, {4, 7,3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord( 7, 11, data, 1);
        data = new int[][]{{1, 2, 8} , {1, 3, 6}, {1, 5, 5} , {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord( 7, 11, data, 1);
    }
}
