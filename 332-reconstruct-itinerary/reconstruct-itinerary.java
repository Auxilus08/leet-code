import java.util.*;

class Solution {
    // Map to store the graph: Source -> PriorityQueue of Destinations
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Build the graph
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // 2. Start DFS from JFK
        dfs("JFK");
        
        return result;
    }

    private void dfs(String departure) {
        PriorityQueue<String> arrivals = map.get(departure);
        
        // While there are available tickets from this airport
        while (arrivals != null && !arrivals.isEmpty()) {
            // Remove the lexicographically smallest destination and visit it
            dfs(arrivals.poll());
        }
        
        // 3. Add to the front of the list (equivalent to reversing at the end)
        result.addFirst(departure);
    }
}