import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] compltetions = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int n = 1;
            while(progresses[i] + speeds[i] * n < 100){
                n++;
            }
            compltetions[i] = n;
        }

        int choice = compltetions[0];
        int next = compltetions[1];
        int cnt = 1;
        for(int i=2; i<compltetions.length; i++){
            if(choice >= next){
                cnt++;
            }else{
                arrayList.add(cnt);
                cnt = 1;
                choice = next;
            }
            next = compltetions[i];
            if(i == compltetions.length-1){
                if(choice >= next){
                    arrayList.add(++cnt);
                }else{
                    arrayList.add(cnt);
                    arrayList.add(1);
                }
            }
        }

        answer = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}