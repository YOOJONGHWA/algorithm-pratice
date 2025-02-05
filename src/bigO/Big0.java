package bigO;

import java.util.Arrays;

public class Big0 {

    public static void main(String[] args) {

        // 1초에 1억번 연산이 가능 하다른 전제 하에 생각하자

        // O(1) - 상수 시간
        // 입력 크기 n과 관계없이 실행 시간이 일정한 경우

        System.out.println("Hello World");

        // 입력이 1 개든 100만 개든, 실행 시간은 항상 1번
        // 계산법: 그냥 1번 실행되니깐  O(1)

        // O(n) - 선형 시간
        // 입력 크기 n에 비례해서 실행 시간이 증가하는 경우

        int n = 1_000_000;
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        // n = 1,000,000 이면 1,000,000번 실행
        // 계산법: 반복문이 n번 실행되므로 O(n)

        // O(n2) - 이차 시간 (중첩 반복문)
        // 반복문이 2번 중첩된 경우, 실행 횟수가 n2에 비례

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + j);  // O(n²)
            }
        }

        // n=1,000,000이면 1,000,000 × 1,000,000 = 1조번 실행
        // 계산법: 바깥 반복문 n번 × 안쪽 반복문 n번 = n2

        // O(log n) - 로그 시간 (이진 탐색 같은 경우)
        // 입력을 반씩 줄여가며 실행하는 경우
        int i = 1;
        while (i < n) {
            i *= 2;  // 매번 2배씩 증가
        }

        // 1 → 2 → 4 → 8 → 16 → … 이런 식으로 증가
        // n = 1,000,000이면 약 20번만 실행

        // O(n log b) - 로그 선셩 시간(퀵정렬)
        // 반복문 + 로그 복잡도가 섞인 경우

        int[] arr = {2 , 1, 6, 3, 6, 8};
        Arrays.sort(arr);

        // On 과 0(log n) 이 섞여 있음

        // O(2n) - 지수 시간 (피보나치 재귀 함수)
        // 입력이 증가할수록 실행 횟수가 폭발적으로 증가

//        int fib(int n) {
//            if (n <= 1) return n;
//            return fib(n-1) + fib(n-2);  // O(2^n)
//        }

        // n = 30만 되어도 10억 번 실행
        // n = 1,000,000이면 우주가 멸망해도 못 끝남
    }
}
