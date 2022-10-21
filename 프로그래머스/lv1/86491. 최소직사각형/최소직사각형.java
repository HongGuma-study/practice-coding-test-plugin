class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wMax=0, hMax=0;

        for(int[] size : sizes){
            if(size[0] < size[1]){
                int tmp = size[0];
                size[0] = size[1];
                size[1] = tmp;
            }
        }

        for (int[] size : sizes) {
            if(wMax < size[0]) wMax = size[0];
            if(hMax < size[1]) hMax = size[1];
        }

        answer = wMax * hMax;

        return answer;
    }
}