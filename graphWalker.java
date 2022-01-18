class GraphWalker {
    public static void bfs(Node source) {
        Set<Node> visited = new HashSet<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(source);
        while (!q.isEmpty()) {
            Node curr = q.pollFirst();
            if (visited.contains(curr)) continue;
            visited.add(curr);
            System.out.println(curr.val);
            for (Node n : curr.neighbors) {
                q.offerLast(n);
            }
        }
    }
    
    public static void dfs(Node source) {
        Set<Node> visited = new HashSet<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(source);
        while (!q.isEmpty()) {
            Node curr = q.pollLast();
            if (visited.contains(curr)) continue;
            visited.add(curr);
            System.out.println(curr.val);
            for (Node n : curr.neighbors) {
                q.offerLast(n);
            }
        }
    }
}
