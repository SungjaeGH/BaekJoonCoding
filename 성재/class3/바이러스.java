import java.io.*;
import java.util.*;

/*
[2606번] 바이러스
https://www.acmicpc.net/problem/2606
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int computerCount = Integer.parseInt(bufferedReader.readLine());
        int networkCount = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, ArrayList<Integer>> networkMap = new HashMap<>();

        for (int idx = 0; idx < networkCount; idx++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            // 무방향 그래프이기 때문에 두 방향 모두 저장
            setNetworkMap(networkMap, firstNode, secondNode);
            setNetworkMap(networkMap, secondNode, firstNode);
        }

        int result = bfs(networkMap, computerCount);
        System.out.println(result);
    }

    private static int bfs(HashMap<Integer, ArrayList<Integer>> networkMap, int computerCount) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        boolean[] visited = new boolean[computerCount + 1];
        int virusCount = 0;

        nodeQueue.offer(1);
        visited[1] = true;

        while (!nodeQueue.isEmpty()) {
            Integer currComputer = nodeQueue.poll();

            if (!networkMap.containsKey(currComputer)) {
                continue;
            }

            ArrayList<Integer> targetNodes = networkMap.get(currComputer);
            for (Integer node : targetNodes) {
                if (!visited[node]) {
                    visited[node] = true;
                    nodeQueue.offer(node);
                    virusCount++;
                }
            }
        }

        return virusCount;
    }

    private static void setNetworkMap(HashMap<Integer, ArrayList<Integer>> networkMap, int firstNode, int secondNode) {
        if (networkMap.containsKey(firstNode)) {
            ArrayList<Integer> targetNodes = networkMap.get(firstNode);
            targetNodes.add(secondNode);

        } else {
            ArrayList<Integer> targetNodes = new ArrayList<>();
            targetNodes.add(secondNode);
            networkMap.put(firstNode, targetNodes);
        }
    }
}