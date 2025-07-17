import java.util.*;

public class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addContact(String person1, String person2) {
        adjacencyList.putIfAbsent(person1, new ArrayList<>());
        adjacencyList.putIfAbsent(person2, new ArrayList<>());

        if (!adjacencyList.get(person1).contains(person2)) {
            adjacencyList.get(person1).add(person2);
        }
        if (!adjacencyList.get(person2).contains(person1)) {
            adjacencyList.get(person2).add(person1);
        }
    }

    public List<String> bfs(String start, String end) {
        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
            return new ArrayList<>(); // If start or end does not exist
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node.equals(end)) break;

            for (String neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, node);
                    queue.add(neighbor);
                }
            }
        }

        if (!parent.containsKey(end) && !start.equals(end)) {
            return new ArrayList<>(); // No path found
        }

        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public void printGraph() {
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    public Map<String, List<String>> getAdjacencyList() {
    return adjacencyList;
}

}


         
