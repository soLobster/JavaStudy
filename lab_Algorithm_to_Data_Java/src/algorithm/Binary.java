package algorithm;

public class Binary {

    public static void main(String[] args) {
       Binary T = new Binary();
       T.DFS(13);
    }

    public void DFS(int n) {
        if(n == 0) {
            return;
        } else {
            DFS(n/2);
            System.out.print(n%2 + " ");
        }
    }
}
