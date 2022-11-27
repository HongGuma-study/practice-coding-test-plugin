import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
         int answer = bridge_length;

        Queue<Integer> trucks = new LinkedList<>(); //대기중 트럭
        Queue<Integer> bridge = new LinkedList<>(); //다리 지나가는 트럭
        int bridge_weight = 0; //다리 지나가는 트럭 무게

        for(int truck : truck_weights){
            trucks.add(truck);
        }

        while (!trucks.isEmpty()){
            int truck = 0;
            if(bridge.isEmpty()){
                truck = trucks.poll();
                bridge.add(truck);
                bridge_weight += truck;
            }else {
                if(bridge.size() == bridge_length){
                    bridge_weight -= bridge.poll();
                }
                //여기서 문제가 있었음...왜...?
                if(bridge_weight + trucks.peek() <= weight){
                    truck = trucks.poll();
                    bridge.add(truck);
                    bridge_weight += truck;
                }else{
                    if (bridge_weight > weight) {
                        bridge_weight -= bridge.poll();
                    } else {
                        bridge.add(0);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}