import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MakeMinValFromArr {
    /*  최솟값 만들기

        길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
        배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
기
        예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면

        A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
        A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
        A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
        즉, 이 경우가 최소가 되므로 29를 return 합니다.

        배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
     */

    public static int solution(int[] A, int[] B){

        int result = 0;

        //a의 배열에서 가장 작은 수를 b 배열에서의 가장 큰 수랑 곱
        //a를 오름차순, b를 내림차순으로 정렬, [i,i] 배열끼리 곱


        //효율성 테스트를 위해 O(NLogN)의 시간 복잡도를 가진 PriorityQueue를 사용.
        PriorityQueue<Integer> a = new PriorityQueue<>(); // 낮은 숫자가 우선순위
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());// 높은 숫자가 우선순위

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        while (!a.isEmpty()) {
            result += a.poll() * b.poll();
        }

        return result;
    }

    public static void main(String args[]){
        int[] a = {2,1};
        int[] b = {4,3};
        System.out.println(solution(a,b));
    }


}
