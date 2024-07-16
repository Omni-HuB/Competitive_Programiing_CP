
// import java.util.*;

// public class D {
//     static class Edge {
//         int node;
//         int wt;

//         public Edge(int node, int wt) {
//             this.node = node;
//             this.wt = wt;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         int q = sc.nextInt();

//         Map<Integer, List<Edge>> graph = new HashMap<>();
//         for (int i = 0; i <= n; i++) {
//             graph.put(i, new ArrayList<>());
//         }

//         rge(sc, m, graph);

//         for (int i = 0; i < q; i++) {
//             int xi = sc.nextInt();
//             int xj = sc.nextInt();
//             int[] dist = sol(n, graph, xi);

//             pDis(dist, xj);
//         }
//     }

//     public static void rge(Scanner sc, int m, Map<Integer, List<Edge>> graph) {
//         for (int i = 0; i < m; i++) {
//             int ni = sc.nextInt();
//             int nj = sc.nextInt();
//             int w = sc.nextInt();
//             graph.get(ni).add(new Edge(nj, w));
//             graph.get(nj).add(new Edge(ni, w));
//         }
//     }

//     public static void pDis(int[] dist, int xj) {
//         if (dist[xj] == Integer.MAX_VALUE) {
//             System.out.println(-1);
//         } else {
//             System.out.println(dist[xj]);
//         }
//     }

//     public static int[] sol(int n, Map<Integer, List<Edge>> graph, int start) {
//         int[] dist = new int[n + 1];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[start] = 0;

//         PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
//         pq.offer(new Edge(start, 0));

//         while (!pq.isEmpty()) {
//             Edge current = pq.poll();
//             int cSta = current.node;
//             int cDis = current.wt;

//             if (cDis > dist[cSta]) {
//                 continue;
//             }

//             for (Edge nbr : graph.get(cSta)) {
//                 int nbrNode = nbr.node;
//                 int tTravel = nbr.wt;
//                 int tDis = cDis + tTravel;

//                 if (tDis < dist[nbrNode]) {
//                     dist[nbrNode] = tDis;
//                     pq.offer(new Edge(nbrNode, tDis));
//                 }
//             }
//         }

//         return dist;
//     }
// }

import java.util.*;
import org.apache.commons.collections4.PriorityQueue;
import org.apache.commons.collections4.functors.DefaultPriorityQueueComparator;

public class D {
    static class Edge {
        int node;
        int wt;

        public Edge(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        rge(sc, m, graph);

        for (int i = 0; i < q; i++) {
            int xi = sc.nextInt();
            int xj = sc.nextInt();
            int[] dist = sol(n, graph, xi);

            pDis(dist, xj);
        }
    }

    public static void rge(Scanner sc, int m, Map<Integer, List<Edge>> graph) {
        for (int i = 0; i < m; i++) {
            int ni = sc.nextInt();
            int nj = sc.nextInt();
            int w = sc.nextInt();
            graph.get(ni).add(new Edge(nj, w));
            graph.get(nj).add(new Edge(ni, w));
        }
    }

    public static void pDis(int[] dist, int xj) {
        if (dist[xj] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[xj]);
        }
    }

    public static int[] sol(int n, Map<Integer, List<Edge>> graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(DefaultPriorityQueueComparator.<Edge>getInstance());
        pq.setComparator((a, b) -> a.wt - b.wt);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int cSta = current.node;
            int cDis = current.wt;

            if (cDis > dist[cSta]) {
                continue;
            }

            for (Edge nbr : graph.get(cSta)) {
                int nbrNode = nbr.node;
                int tTravel = nbr.wt;
                int tDis = cDis + tTravel;

                if (tDis < dist[nbrNode]) {
                    dist[nbrNode] = tDis;
                    pq.add(new Edge(nbrNode, tDis));
                }
            }
        }

        return dist;
    }
}
