package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {

//    static ArrayList<Integer> list; 작성 -> 재귀 함수 사용 예정
//    static boolean[] visited 작성 -> 방문 여부 판단

//    간선 및 , 개수 입력 받기
//    정점이 1부터 시작 하기에 리스트 크기를 + 1을 한다 .
//    마찬가지 방문 배열도 + 1을 한다

//    그후 ArrayList 초기화
//    간선들을 입력 받아서 그래프 생성
//    방향 없는 그래프이기에 양쪽다 연결

//    연결 요소의 개수를 출력 하기에 방문 여부로 판단하면 될것 같음 예를 들어 방문 되어 있지 않은 요소 이면
//    카운트 1증가 아니면 카운트 하지않음

    // 그 판단은 재귀를 통해서 하면 될것 같음

    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {
                count++;
                dfs(i);
            }

        }
        System.out.println(count);
    }

    private static void dfs(int index) {

        if (visited[index]) {
            return;
        }

        visited[index] = true;
        for (int num : list[index]) {
            if (!visited[num]) {
                dfs(num);
            }
        }
    }
}
