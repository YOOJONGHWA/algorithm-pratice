package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {


    /*
    *   일단 고민인게 스택틱으로 만들어서 관리하면 초기화하가 필요거 같은데 따로 분리 할필요도 없을거 같고
    *   어레이 리스트로 배열 만들고
    *   방문도 만들고
    *
    *   입력은 스트링 토큰으로 받아오는데 개수 간선 개수 탐색을 시작 번호 를 받아오네
    *
    *   아 양방향이군 그럼 각자 연결
    *
    *   그 후에 DFS BFS 메서드를 따로 만들고 동작 을 해야 겟군
    *   DFS 재귀함수로 풀고
    *   BFS 를 어레이 데큐로
    *
    *
    * */

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        dfs(first);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(first);
        System.out.println();
    }
    private static void dfs(int node) {

        System.out.print(node + " ");

        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int ans : graph[node]) {
            if (!visited[ans]) {
                dfs(ans);
            }
        }

    }

    private static void bfs(int node) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int ans : graph[cur]) {
                if (!visited[ans]) {
                    queue.add(ans);
                    visited[ans] = true;
                }
            }
        }

    }
}
