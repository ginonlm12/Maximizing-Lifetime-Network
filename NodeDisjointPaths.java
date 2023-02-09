import java.util.LinkedList;
class NodeDisjointPaths {
	int V;
    /*private int getV() {
        return V;
    }*/
    private void setV(int v) {
        V = v;
    }
	boolean bfs(int rGraph[][], int s, int t, int parent[]) {

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
    
        while (queue.size()!=0)
        {
            int u = queue.poll();
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
    
        return (visited[t] == true);
    }
    
    int[][] TransformingGraph(int OGraph[][]){
        int n = OGraph[0].length;
        int[][] RGraph = new int[2 * n - 2][2 * n - 2];
        for (int i = 0; i < 2 * n - 2; i++) {
            for (int j = 0; j < 2 * n - 2; j++) {
                RGraph[i][j] = 0;
            }
        }
        RGraph[0][0] = OGraph[0][0];
        for (int i = 1; i < n - 1; i++) {
            RGraph[0][2 * i - 1] = OGraph[0][i];
        }
        for (int i = 1; i < n - 1; i++) {
            RGraph[2 * i][2 * n - 3] = OGraph[n - 1][i];
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (i == j) {
                    RGraph[2 * i - 1][2 * i] = 1;
                    RGraph[2 * i][2 * i - 1] = OGraph[i][i];
                } else {
                    if (OGraph[i][j] != 0) {
                        RGraph[2 * i][2 * j - 1] = OGraph[i][j];
                    }
                }
            }
        }
        return RGraph;
    }

   
    int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;
   
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
   
        int parent[] = new int[V];
        int max_flow = 0;  

        while (bfs(rGraph, s, t, parent))
        {
      
            int pathFlow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }
          
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
     
            max_flow += pathFlow;
        }
    
        return max_flow;
    }
    void fordFulkerson1(int graph[][], int s, int t){
        int u, v;
        
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
   
        int parent[] = new int[V];
        
        while (bfs(rGraph, s, t, parent))
        {
      
            int pathFlow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
                System.out.print(v+" ");
            }
            System.out.println("0");
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
        }
    }
    public static void main (String[] args) throws java.lang.Exception {
      
        int graph[][] =new int[][] { {0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0}
                                   };
        NodeDisjointPaths m = new NodeDisjointPaths();
        int[][] rgraph = m.TransformingGraph(graph);
        int V = rgraph[0].length;
        m.setV(V);
        
        System.out.println("The maximum possible flow is " +
                           m.fordFulkerson(rgraph, 0, V-1));
        m.fordFulkerson1(rgraph, 0, V-1);
    }
}