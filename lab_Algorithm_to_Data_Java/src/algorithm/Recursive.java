package algorithm;

public class Recursive {

    public static void main(String[] args) {
       Recursive T = new Recursive();
       T.DFS(3);
    }

//    public void DFS(int n) {
//      if(n==0) {
//          return;
//      } else {
//          System.out.print(n + " ");
//          DFS(n-1);
//      }
//    }
    
    /*
     * 스택 프레임.
     * 메모리의 스택 영역은 함수의 호출과 관계되는 지역변수와 매개변수가 저장되는 영역
     * 스택 영역은 함수의 호출과 함께 할당. 함수의 호출이 완료되면 소멸.
     * 
     * 함수 호출시 스택에는 함수의 매개변수, 호출이 끝나면 반환 주소 값, 선언된 지역 변수 등이 저장
     * 이렇게 스택 영역에 차례대로 저장되는 함수의 호출 정보를 스택 프레임이라 부른다.
     * 
     * 스택 프레임을 활용하면 함수의 호출이 모두 끝난 뒤에 해당 함수가 호출되기 이전 상태로 되돌아 갈 수 있다.
     */
    
    public void DFS(int n) {
        if(n==0) {
            return;
        } else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }
    
}//end Recursive
