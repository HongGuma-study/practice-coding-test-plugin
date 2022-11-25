import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> answers = new ArrayList<>();
        HashMap<String,Integer> totalMap = new HashMap<>();
        PriorityQueue<Genre> totalQueue = new PriorityQueue<>();
        for(int i=0; i<genres.length; i++){
            if(!totalMap.containsKey(genres[i])){
                totalMap.put(genres[i],plays[i]);
            }else{
                int sum = totalMap.get(genres[i]);
                totalMap.put(genres[i],plays[i]+sum);
            }
        }

        for(String key : totalMap.keySet()){
            totalQueue.add(new Genre(key,totalMap.get(key)));
        }

        while(!totalQueue.isEmpty()){
            PriorityQueue<Genre> queue = new PriorityQueue<>();
            Genre genre = totalQueue.poll();
            for (int i = 0; i < genres.length; i++) {
                if(genre.genreName.equals(genres[i])){
                    queue.add(new Genre(genres[i],i,plays[i]));
                }
            }
            if(queue.size() > 1){
                answers.add(queue.poll().id);
                answers.add(queue.poll().id);
            }else{
                answers.add(queue.poll().id);
            }
        }

        answer = new int[answers.size()];
        int i=0;
        for(int ans : answers){
            answer[i] = ans;
            i++;
        }
        return answer;
    }
    
    class Genre implements Comparable<Genre>{
        String genreName;
        int id;
        int numberOfPlays;

        public Genre(String genre, int plays){
            this.genreName = genre;
            this.numberOfPlays = plays;
        }

        public Genre(String genre, int id, int plays){
            this.genreName = genre;
            this.id = id;
            this.numberOfPlays = plays;
        }

        @Override
        public int compareTo(Genre o) {
            if(this.numberOfPlays == o.numberOfPlays)
                return this.id > o.id ? 1 : -1;
            return this.numberOfPlays < o.numberOfPlays ? 1 : -1;
        }
    }

}