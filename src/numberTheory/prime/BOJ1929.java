package numberTheory.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1929 {

    /*
    *
    *   에라토스테네스의 체원리
    *   1. 구할려는 소수의 범위만큼 1차원 배열을 생성
    *   2. 2부터 시작하고 현재 숫자가 지워지지 않을 떄는 현재 선택 된 숫자의 배수에 해당하는 수를 배열에서
    *       끝까지 탐색하면서 지움, 이때 처음으로 선택된 숫자는 지우지 않는다.
    *   3. 배열의 끝까지 2를 반복한 후 배열에서 남아 있는 모든 수를 출력
    *
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[last + 1];
        for (int i = 2; i <= last; i++) {
            isPrime[i] = true;
        }

        int maxLast = (int) Math.sqrt(last);

        for (int i = 2; i <= maxLast; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j <= last; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
