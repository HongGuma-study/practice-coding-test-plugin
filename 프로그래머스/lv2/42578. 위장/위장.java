import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String[] clothe : clothes){
            if(hashMap.containsKey(clothe[1])){
                int cnt = hashMap.get(clothe[1]);
                hashMap.put(clothe[1],++cnt);
            }else{
                hashMap.put(clothe[1],1);
            }
        }

        System.out.println(hashMap.values());

        for(int n : hashMap.values()){
            answer *= (1+n);
        }

        return answer-1;
    }
}