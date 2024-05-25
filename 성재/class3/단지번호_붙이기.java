import java.io.*;
import java.util.*;

/*
[2667번] 단지번호 붙이기
https://www.acmicpc.net/problem/2667
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int mapSize = Integer.parseInt(bufferedReader.readLine());

        // 지도 세팅
        boolean[][] map = setMap(mapSize, bufferedReader);

        // 단지 내 아파트 수 확인
        ArrayList<Integer> result = checkHouses(map, mapSize);
        Collections.sort(result);

        System.out.println(result.size());
        for (Integer houseCount : result) {
            System.out.println(houseCount);
        }
    }

    private static ArrayList<Integer> checkHouses(boolean[][] map, int mapSize) {
        boolean[][] visited = new boolean[mapSize][mapSize];
        ArrayList<Integer> resultArr = new ArrayList<>();

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                if (!visited[row][col] && map[row][col]) {
                    int[] startLoc = {row, col};
                    int houseCount = dfs(startLoc, map, visited, mapSize);

                    resultArr.add(houseCount);
                }
            }
        }

        return resultArr;
    }

    private static int dfs(int[] startLoc, boolean[][] map, boolean[][] visited, int mapSize) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(startLoc);
        visited[startLoc[0]][startLoc[1]] = true;
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
        int houseCount = 1;

        while (!queue.isEmpty()) {
            int[] currLoc = queue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nextRow = currLoc[0] + move[idx][0];
                int nextCol = currLoc[1] + move[idx][1];

                if (nextRow < 0 || nextRow >= mapSize || nextCol < 0 || nextCol >= mapSize) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && map[nextRow][nextCol]) {
                    queue.offer(new int[]{nextRow, nextCol});
                    houseCount++;
                }

                visited[nextRow][nextCol] = true;
            }
        }

        return houseCount;
    }

    private static boolean[][] setMap(int mapSize, BufferedReader bufferedReader) throws IOException {
        boolean[][] map = new boolean[mapSize][mapSize];

        for (int row = 0; row < mapSize; row++) {
            String colInfo = bufferedReader.readLine();
            char[] colsArr = colInfo.toCharArray();

            for (int col = 0; col < colsArr.length; col++) {
                if (colsArr[col] == '1') {
                    map[row][col] = true;
                }
            }
        }

        return map;
    }
}