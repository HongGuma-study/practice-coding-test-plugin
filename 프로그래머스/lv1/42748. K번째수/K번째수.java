import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> splitArr = new ArrayList<>();
        int repeat = 0;
        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            for(int num = i; num<j+1; num++){
                splitArr.add(array[num-1]);
            }
            Collections.sort(splitArr);
            answer[repeat] = splitArr.get(k-1);
            repeat++;
            splitArr.removeAll(splitArr);
        }
        return answer;
    }
}