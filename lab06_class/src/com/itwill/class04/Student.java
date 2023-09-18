package com.itwill.class04;



public class Student {

    //필드
    int studentNo;
    String StudentName;
    Score score; //그 학생의 수강 과목 점수.
   
    
    //생성자
    //기본 생성자.
    public Student() {
      //필드 int studentNo = 0;
      //필드 String studentName = null;
      //필드 Score score  = null;
            
    }
    
    public Student(int studentNo, String StudentName, Score score) {
        this.studentNo = studentNo;
        this.StudentName = StudentName;
        this.score = score;
    }
    
    //메서드
    //학생의 정보를 출력하는 메서드
    //번호, 이름, 국어점수, 영어점수, 수학점수, 총점, 평균 출력.
    
    public void studentInfo() {
        System.out.println("student No = "+studentNo);
        System.out.println("student Name = "+StudentName);
        if(score != null) {
            System.out.println("student Korean Score = "+score.korean);
            System.out.println("student English Score = "+score.english);
            System.out.println("student Math Score = "+score.math);
            System.out.println("student Exam Total Score = "+score.getTotal());
            System.out.println("student Exam Mean Score = "+score.getMean());
        } else {
            System.out.println("출력 불가. score == null ");
        }
    }
}

