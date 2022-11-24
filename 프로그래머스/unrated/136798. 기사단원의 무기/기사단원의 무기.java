class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            int cnt = 0; //약수의 개수
            int num = i+1;
            for (int j = 1; j * j <= num; j++) {
                if ((num % j) == 0) {
                    cnt++;
                    if (j * j < num)
                        cnt++;
                }
            }
            if (cnt > limit)
                numbers[i] = power;
            else
                numbers[i] = cnt;
        }
        
        for (int n : numbers) {
            answer += n;
        }

        return answer;
    }
}