import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
       int[] answer;
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<3; i++){
            students.add(new Student(i+1,0));
        }

        for(int i = 0; i<answers.length; i++){
            // System.out.println("ans = "+answers[i]+", s1 = "+student1[i%5]+",s2 = "+student2[i%8]+",s3 = "+student3[i%10]);
            if( answers[i] == student1[i%5] ) students.get(0).score++;
            if( answers[i] == student2[i%8] ) students.get(1).score++;
            if( answers[i] == student3[i%10] ) students.get(2).score++;
        }

        Collections.sort(students);

        Student maxStudent = new Student(students.get(0).idx,students.get(0).score);

        //max값 찾기
        for(Student student : students){
//            System.out.println(student.idx+", "+student.score);
            if(maxStudent.idx != student.idx) continue;
            if(maxStudent.score  < student.score ){
                maxStudent = student;
            }
        }

        ans.add(maxStudent.idx);

        //max값이랑 같은 값 있는지 확인하기
        for(Student student : students){
            if(maxStudent.idx == student.idx) continue;
            if(maxStudent.score == student.score){
                ans.add(student.idx);
            }
        }

        answer = new int[ans.size()];

        int idx = 0;
        for(int a : ans){
            answer[idx++] = a;
        }

        return answer;
    }

    class Student implements Comparable<Student> {
        int idx;
        int score;

        public Student(int idx, int score){
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if(this.score == o.score){
                return this.idx < o.idx ? -1 : 1;
            }else{
                return this.score < o.score ? 1 : -1;
            }
        }
    }
}