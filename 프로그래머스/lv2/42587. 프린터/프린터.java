import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Printout> queue = new LinkedList<>();

        int i=0;
        for(int num : priorities){
            queue.add(new Printout(i,num));
            i++;
        }

        while(!queue.isEmpty()){
            Printout job = queue.poll();
            boolean check = true;
            for(Printout p : queue){
                if(job.priority < p.priority){
                    queue.add(job);
                    check = false;
                    break;
                }
            }

            if(check){
                if(job.index == location){
                    return answer;
                }
                answer++;
            }
        }

        return answer;
    }

    class Printout implements Comparable<Printout>{
        int index;
        int priority;

        public Printout(int index, int priority){
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Printout o) {
            return this.priority < o.priority ? 1 : -1;
        }
    }
}