import java.util.Arrays;

public class Practice1_MST {

    static int parents[];

    public static int kruskal(int[][] data, int v, int e){
        int weightSum = 0;

        Arrays.sort(data, (x,y) -> x[2] - y[2]);

        parents = new int[v+1]; // 1번부터 시작

        for(int i=1; i<v+1; i++){
            parents[i]=i;
        }

        for(int i=0; i<e; i++){
            if(find(data[i][0]) != find(data[i][1])){
                union(data[i][0],data[i][1]);
                weightSum+=data[i][2];
            }
        }

        return weightSum;
    }

    public static void union(int a, int b){  // 연결한 바로 인접노드간 업데이트
       int aP = find(a);
       int bP = find(b);

         if(aP<bP) {
             parents[bP] = aP;
         }else{
             parents[aP] = bP;
         }
    }

    public static int find(int a){
        if(a == parents[a]){ //parents[a]에 있는 값은 연결된 집합에서 최소 노드 값 5-3  =>
            //parent[5]==3 -> 재귀적으로 find(3)  -> 3 == parents[3] 같으면 3리턴 => find(5)는 3리턴
            return a;
        }


        return parents[a] = find(parents[a]);

        //1-3-5 연결인 상황에   find(5) -> find(3) 이때 parent[5]에 find(3)으로 업데이트(union에서는 인접 노드와만 갱신이 되었기 때문)
    }

    public static void main(String[] args) {
        int v=7;
        int e=10;
        int[][] graph = {{1,3,1},{1,2,9},{1,6,8},{2,4,13},{2,5,2},{2,6,7},{3,4,12},{4,7,17},{5,6,5},{5,7,20}};

        System.out.println(kruskal(graph, v, e));
    }
}
