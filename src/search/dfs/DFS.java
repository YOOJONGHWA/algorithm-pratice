package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
        }

        boolean result = DFS(1, 5);
        System.out.println(result ? "YES" : "NO");
    }

    private static boolean DFS(int node, int findNumber) {
        visited[node] = true;
        System.out.println("방문한 노드: " + node);

        if (findNumber == node) {
            return true;
        }

        for (Integer child : graph[node]) {
            if (!visited[child]) {
                System.out.println("자식 노드 방문 전: " + child);
                if (DFS(child, findNumber)) {
                    return true;
                }
            }
        }

        return false;
    }
}
