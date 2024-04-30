import java.io.*;
import java.util.*;

/*
[1260번] DFS와 BFS
https://www.acmicpc.net/problem/1260
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
        int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
        int startNode = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<Integer, ArrayList<Integer>> edges = setEdges(edgeCount, bufferedReader);

        dfs(startNode, nodeCount, edges);
        bfs(startNode, nodeCount, edges);
    }

    private static void dfs(int startNode, int nodeCount, HashMap<Integer, ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[nodeCount];
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        visited[startNode - 1] = true;
        stack.push(startNode);
        stringBuilder.append(startNode).append(" ");

        while (!stack.isEmpty()) {
            Integer currNode = stack.peek();
            boolean isLeaf = true;

            if (!edges.containsKey(currNode)) {
                stack.pop();
                continue;
            }

            ArrayList<Integer> targetNodes = edges.get(currNode);
            for (Integer nextNode : targetNodes) {
                if (visited[nextNode - 1]) {
                    continue;
                }

                stack.push(nextNode);
                visited[nextNode - 1] = true;
                isLeaf = false;
                stringBuilder.append(nextNode).append(" ");
                break;
            }

            if (isLeaf) {
                stack.pop();
            }
        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int startNode, int nodeCount, HashMap<Integer, ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[nodeCount];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        visited[startNode - 1] = true;
        queue.offer(startNode);
        stringBuilder.append(startNode).append(" ");

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();

            if (!edges.containsKey(currNode)) {
                continue;
            }

            ArrayList<Integer> targetNodes = edges.get(currNode);
            for (Integer nextNode : targetNodes) {
                if (visited[nextNode - 1]) {
                    continue;
                }

                queue.offer(nextNode);
                visited[nextNode - 1] = true;
                stringBuilder.append(nextNode).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }

    private static HashMap<Integer, ArrayList<Integer>> setEdges(int edgeCount, BufferedReader bufferedReader) throws IOException {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int edgeIdx = 0; edgeIdx < edgeCount; edgeIdx++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int from = Integer.parseInt(stringTokenizer.nextToken());

            // 무방향 그래프이기 때문에 (1 -> 2) & (2 -> 1) 둘 경우를 넣어주기!
            if (hashMap.containsKey(to)) {
                ArrayList<Integer> edges = hashMap.get(to);
                edges.add(from);
                Collections.sort(edges);

            } else {
                ArrayList<Integer> edges = new ArrayList<>();
                edges.add(from);
                hashMap.put(to, edges);
            }

            if (hashMap.containsKey(from)) {
                ArrayList<Integer> edges = hashMap.get(from);
                edges.add(to);
                Collections.sort(edges);

            } else {
                ArrayList<Integer> edges = new ArrayList<>();
                edges.add(to);
                hashMap.put(from, edges);
            }
        }

        return hashMap;
    }
}