//2차원 배열 data에 그래프 데이터가 주어졌다.
//무방향이고 간선이 가중치 값이 있는 그래프이다.
//1번 정점에서 N번 정점으로 최단 경로로 이동하려고 하는데,
//두 정점을 경유해서 가려고 한다.
//1번 정점에서 출발하여 두 정점을 경유하여 N번 정점으로 가는 최단 경로를 구하세요

//case 1 : start(1) --> via1 ---> via2 ---> end
//case 2 : start(1) --> via2 ---> via1 ---> end
//
//        case 1:
//            start(1) --> via1 의 최단 경로 + via1 ---> via2 의 최단 경로 + via2 ---> end 의 최단 경로
//        case 2:
//            start(1) --> via2 의 최단 경로 + via2 ---> via1 의 최단 경로 + via1 ---> end 의 최단 경로
//
//        return min(case1, case2)

import java.util.ArrayList;
import java.util.PriorityQueue;

//입출력 에시)
//입력
//        int[][] data = {{1,2,3},{1,3,5},{1,4,4},{2,3,3},{2,4,5},{3,4,1}};
//        int v = 4;
//        int via1 = 2;
//        int via2 = 3;
//        int start = 1;
//        int n = 4;
//
//출력     7
public class Practice1_ShortestPath {
    static ArrayList<ArrayList<Node>> graph;
    final static int INF = 1000000000;

    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public static int solution(int[][] data, int v, int via1, int via2, int start, int n){
        int case1 = 0;
        int case2 = 0;

        graph = new ArrayList<>();
        for(int i=0; i<v+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i< data.length; i++){
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        //case 1 : start(1) --> via1 ---> via2 ---> end
        case1 += dijkstra(v, start, via1) + dijkstra(v,via1,via2) + dijkstra(v, via2, n);

        //case 2 : start(1) --> via2 ---> via1 ---> end
        case2 += dijkstra(v, start, via2) + dijkstra(v,via2,via1) + dijkstra(v, via1, n);

        if(case1 >= INF && case2 >= INF){
            return -1;
        }

        return Math.min(case1, case2);
    }

    public static int dijkstra(int v, int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)->x.weight - y.weight); //min heap
        pq.offer(new Node(start, 0));

        int[] dist = new int[v+1];
        for(int i=0; i<v+1; i++){
            dist[i] = INF;
        }
        dist[start] = 0;

        boolean[] visited = new boolean[v+1];

        while(!pq.isEmpty()){
            Node curNode = pq.poll();

            if(visited[curNode.to]){ //이미 방문했으면 visited[x] => true
                continue;
            }

            for(int i=0; i<graph.get(curNode.to).size(); i++){
                Node adjNode = graph.get(curNode.to).get(i);

                if(!visited[adjNode.to] && dist[adjNode.to]>curNode.weight + adjNode.weight){
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) {
        int[][] data = {{1,2,3},{1,3,5},{1,4,4},{2,3,3},{2,4,5},{3,4,1}};
        int v = 4;
        int via1 = 2;
        int via2 = 3;
        int start = 1;
        int n = 4;

        System.out.println(solution(data,v,via1,via2,start,n));
    }
}
