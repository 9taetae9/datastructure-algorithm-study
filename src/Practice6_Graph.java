//주어진 그래프 시작 노드에서 끝 노드로 가는 길이 있는지 확인하시오
//path가 존재하면 true 없다면 false return
//
//ex)
//노드 개수 = 3
//간선 정보 = {{0,1},{1,2},{2,0}}
//출발 노드 = 0
//종착 노드 = 2
//출력 : true

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice6_Graph {
    public static void solution(int n, int[][] edges, int source, int dest){
        MyGraphList graph = new MyGraphList(n);

        for(int i=0; i<n; i++){
            graph.addVertex(i);
        }

        for(int i=0; i<edges.length; i++){
            graph.addEdge(edges[i][0],edges[i][1]);
        }

        List<Integer> visitedItem = new ArrayList<>();
        dfs(graph, 0, visitedItem);

        if(visitedItem.contains(source)&&visitedItem.contains(dest)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void dfs(MyGraphList graph, int id, List<Integer> visitedItem){
        boolean[] visted = new boolean[graph.vertices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visted[id] = true;
        while(!stack.isEmpty()){
            int curId = stack.pop();

            visitedItem.add(curId);

            Node_ cur = graph.adjList[curId];
            while(cur != null){
                if(!visted[cur.id]){
                    visted[cur.id] = true;
                    stack.push(cur.id);
                }
                cur = cur.next;
            }
        }
        System.out.println(visitedItem);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int dest = 2;
        solution(n, edges, source, dest);

        n = 6;
        edges = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        source = 0;
        dest = 5;
        solution(n, edges, source, dest);
    }
}
