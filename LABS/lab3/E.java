import java.util.*;

class E {
    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Create adjacency list
        List<List<Map.Entry<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int t = scanner.nextInt();
            adjList.get(x).add(new AbstractMap.SimpleEntry<>(y, t));
            adjList.get(y).add(new AbstractMap.SimpleEntry<>(x, t));
        }

        // Store traffic jams
        List<List<Integer>> trafficJams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> jamTimes = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                jamTimes.add(scanner.nextInt());
            }
            trafficJams.add(jamTimes);
        }

        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        priorityQueue.add(new AbstractMap.SimpleEntry<>(0, 1));
        Set<Integer> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> current = priorityQueue.poll();
            int currentTime = current.getKey();
            int currentIntersection = current.getValue();

            if (visited.contains(currentIntersection)) {
                continue;
            }

            visited.add(currentIntersection);

            if (currentIntersection == n) {
                return currentTime;
            }

            if (currentIntersection != 1 && trafficJams.get(currentIntersection - 1).contains(currentTime)) {
                currentTime += 1;
            }

            for (Map.Entry<Integer, Integer> neighbor : adjList.get(currentIntersection)) {
                int neighborIntersection = neighbor.getKey();
                int travelTime = neighbor.getValue();
                int newTime = currentTime + travelTime;

                if (newTime < distances[neighborIntersection]) {
                    distances[neighborIntersection] = newTime;
                    priorityQueue.add(new AbstractMap.SimpleEntry<>(newTime, neighborIntersection));
                }
            }
        }

        return -1;
    }
}
