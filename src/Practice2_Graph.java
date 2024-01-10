//인접리스트를 활용한 그래프 구현
class Node_{
    int id;
    Node_ next;

    public Node_(int id, Node_ next){
        this.id = id;
        this.next = next;
    }
}

class MyGraphList{
    char[] vertices;
    Node_[] adjList;
    int elemCnt;

    public MyGraphList() {}
    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new Node_[size];
        this.elemCnt = 0;
    }

    public boolean isFull(){
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data){
        if(isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y){
        this.adjList[x] = new Node_(y, this.adjList[x]); //리스트 앞에 추가 Node_(int id, Node_ next)
        //Node_(새 노드 id, 기존의 adjList[x]가 가리키고 있던 노드) =>를 adjList[x]가 참조
        this.adjList[y] = new Node_(x, this.adjList[y]);
    }

    public void addDirectedEdge(int x, int y){
        this.adjList[x] = new Node_(y,this.adjList[x]);
    }

    public void printAdjacentList(){
        for(int i=0; i<this.elemCnt; i++){
            System.out.print(this.vertices[i] + ": ");

            Node_ cur = this.adjList[i];
            while(cur != null){
                System.out.print(this.vertices[cur.id]+" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
public class Practice2_Graph {
    public static void main(String[] args) {
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printAdjacentList();
    }
}
