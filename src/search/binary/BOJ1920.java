package search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    // N개의 정수 즉 ..  A[1], A[2], …, A[N]이 주어져 있을 때,
    // X라는 정수가 존재하는지 알아내는 것을 목표

    // 완전탐색으로 풀수는 있겟지만 시간초과 예상 시간 제한이 1초라서
    // 그럼 정렬을 해서 해야되는데 이분 탐색이 맞을 듯
    // 최대 값이 100,000 인데  연산 횟수가 17번 정도 될같음

    // 이분 탐색은 배열이 정렬되어 있어야 동작 할수 있음
    // 입력 받은 배열을 정렬하고

    // 중간 값을 선택 이떄 인덱스를 활용

    // 그 값이 작은 지 큰지 비교
    // 크면 중간 값을 부터 오른쪽 인덱스들을 살피고
    // 작으면 처음 부터 중간 값을 기준으로 살펴서
    // 중간값 인덱스를 변경하면서 중간값이 원하는 값이 있는지 없는지 판단하면 될듯

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] findArr = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(findNumber(arr, target)).append("\n");
        }
        System.out.println(sb);

    }

    private static int findNumber(int[] arr, int findArr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            // 중앙값이 같은 경우
            if (arr[mid] == findArr) return 1;
            // 중앙값이 찾는 숫자보다 큰경우
            if (arr[mid] < findArr) left = mid + 1;
            // 중앙값이 찾는 숫자보다 작을경우
            if (arr[mid] > findArr) right = mid - 1;

        }

        return 0;
    }
}
