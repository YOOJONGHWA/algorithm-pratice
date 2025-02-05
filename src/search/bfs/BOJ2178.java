package search.bfs;

import java.io.*;
import java.util.*;

/*
 *   static 으로 이중 배열을 만들고
 *   static 으로 이중 boolean 배열을 만들고
 *   상하좌우 이동을 위한 dx, dy 배열을 만든다.
 *
 *   입력값 처리를 위해 BufferedReader, StringTokenizer를 사용
 *   이중 배열(board)에 값을 저장한다.
 *
 *   BFS 메서드 구현 (최단 거리 탐색)
 *   ArrayDeque<int[]>를 생성하여 큐를 만들고,
 *   초기값 X, Y를 저장한다.
 *
 *   while문을 사용하여 큐가 빌 때까지 반복
 *   탈출 조건: 목표 지점 (n-1, m-1) 도착 시 종료
 *
 *   이동 조건:
 *   1. 인덱스 범위를 벗어나지 않아야 한다.
 *   2. 이동하려는 위치(board[nx][ny])가 1이어야 한다.
 *   3. 아직 방문하지 않은 위치여야 한다.
 *
 *   이동이 가능하면:
 *   1. 방문 여부를 true로 변경
 *   2. 현재 위치의 최단 거리 값에 +1 하여 갱신
 *   3. 새로운 위치를 큐에 추가
 *
 *   이 과정을 반복하며 최단 거리를 구한다.
 *
 */


public class BOJ2178 {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = line[j] - '0';
            }
        }

        System.out.println(BFS(0, 0, n, m));
    }

    private static int BFS(int startX, int startY, int n, int m) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == n - 1 && y == m - 1) {
                return board[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    board[nx][ny] = board[x][y] + 1;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}
