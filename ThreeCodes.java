import java.util.Scanner;
import java.util.LinkedList;
class ThreeCodes {
	int V;
    /*private int getV() {
        return V;
    }*/
    public void setV(int v) {
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
        int a=1;
        while (bfs(rGraph, s, t, parent))
        {
      
            int pathFlow = Integer.MAX_VALUE;
            System.out.print("S"+a+": ");
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
                if(v%2!=0) System.out.print(v/2+1+" ");
            }
            System.out.println("0");
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
            a++;
        }
    }
    public static void main (String[] args) throws java.lang.Exception {
      
        int graph[][] =new int[][] {{0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        ThreeCodes HL = new ThreeCodes();
        int[][] rgraph = HL.TransformingGraph(graph);
        int V = rgraph[0].length;
        HL.setV(V);
        
        System.out.println("The maximum possible flow is " +
                           HL.fordFulkerson(rgraph, 0, V-1));
        HL.fordFulkerson1(rgraph, 0, V-1);
        System.out.println("-------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the positive integer k: ");
        int k = sc.nextInt();
        int m = HL.fordFulkerson(rgraph, 0, V-1);
        int l,r,i,j;
        if(m<k) System.out.print("No schedule can achieve k-barrier coverage.");
        else{
            if (m % k == 0) {
                l = m / k;
                System.out.println("The maximum lifetime network is "+m+" units of time.");
            } else {
                l = m / k - 1;
                System.out.println("The maximum lifetime network is "+m+"/"+k+" units of time.");
            }

            for (j = 0; j < l; j++) {
                System.out.print("(");
                for (i = k * j + 1; i <= k * (j + 1); i++) {
                    if (i != k * (j + 1)) {
                        System.out.print("S" + i + ",");
                    } else {
                        System.out.print("S" + i);
                    }
                }
                System.out.println(") Time : 1 unit");
            }

            r = m - l * k;
            if (r != 0) {
                int n = l * k + 1;
                for (j = n; j <= m - k + 1; j++) {
                    System.out.print("(");
                    for (i = j; i <= j + k - 1; i++) {
                        if (i != j + k - 1) {
                            System.out.print("S" + i + ",");
                        } else {
                            System.out.print("S" + i);
                        }
                    }
                    System.out.println(") Time : 1/" + k + " unit");
                }

                for (j = m - k + 2; j <= m; j++) {
                    System.out.print("(");
                    for (i = j; i < j + k - 1; i++) {
                        if (i > m) {
                            System.out.print("S" + (i - m + n - 1) + ",");
                        } else {
                            System.out.print("S" + i + ",");
                        }
                    }
                    i = j + k - 1;
                    if (i > m) {
                        System.out.print("S" + (i - m + n - 1));
                    } else {
                        System.out.print("S" + i);
                    }
                    System.out.println(") Time : 1/" + k + " unit");
                }
            }
            
        }
        sc.close();
    }
}