package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {

    /*
    *   1. 해 선택 : 현재 상테에서 가장 최선이라고 생각되는 해를 선택한다.
    *   2. 적절성 검사: 현재 선택한 해가 전체 문제의 제약 조건에 벗어나지 않는지 검사
    *   3. 해 검사 : 현재 까지 선택한 해 집합이 전체 문제를 해결할 수 있느지 검사.
    *               -> 전체 문제를 해결하지 못한다면 1로 돌아가 같은 과정을 반복
    *
    * */


    /*
    *   동전의 가치가 오름차순으로 주어진다.
    *   그럼 상식적으로 가장 큰 동전으로 합을 만들때 최솟값이 구해진다.
    *   예를 들어 1000월 구할때 백원짜리 10개보다 500원 짜리 2개가 더 최솟값이다.
    *   그럼 오름 차순으로 주어진다고 하였으니 배열 마지막 인덱스부터 / 가 되는지 판단하면 될듯
    *   만약 나누어 지면 % 로 그값을 변경해서 계속 반복하면 될거 같은데
    *
    *   for 문보다는 while문이 더 좋을듯하고 시간 복잡도에서도 충분할듯 하다.
    * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int index = arr.length - 1;

        while (k > 0 && index >= 0) {
            count += k / arr[index];
            k %= arr[index];
            index--;
        }

        System.out.println(count);
    }
}
