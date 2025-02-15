package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int col, row;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCount; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int bachuo = Integer.parseInt(st.nextToken());

            arr = new int[col][row];
            visited = new boolean[col][row];

            for (int j = 0; j < bachuo; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }


            int count = 0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < col && ny >= 0 && ny < row && !visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
