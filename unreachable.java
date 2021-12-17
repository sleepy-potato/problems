/*
public class Edge {
    public Node from;
    public Node to;
    public int depart;
    public int arrive;
    public Edge(Node f, Node t, int d, int a) {
        from = f;
        to = t;
        depart = d;
        arrive = a;
    }
}

public class Node {
    public String city;
    public List<Edge> edges;
    public Node(String c) {
        city = c;
    }
    
    public void addEdge(Edge e) {
        edges.add(e);
    }
}
*/

class SortByArrivalTime implements Comparator<Edge> {
    public int compare(Edge a, Edge b)
    {
        return a.arrive - b.arrive;
    }
}

public class MyClass {
    public Set<Node> getUnreachableNodes(Set<Node> graph, Node node) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.size(), SortByArrivalTime);
        pq.add(new Edge(null, node, 0, 0));

        Set<Node> visited = new HashSet<>();
        int currTime = 0;
        while (!pq.isEmpty) {
            Edge e = pq.poll();
            Node nextCity = e.to;
            if (visited.contains(nextCity)) continue;
            visited.add(nextCity);
            currTime = e.arrive;
            for (Edge next : nextCity.edges) {
                if (next.depart < currTime) continue;
                pq.add(next);
            }
        }
        Set<Node> result = new HashSet<>(graph);
        result.removeAll(visited);
        return result;
    }
}
