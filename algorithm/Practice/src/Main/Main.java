package Main;
import java.util.Scanner;
import java.util.Arrays;
 
import java.util.Comparator;
 
 
public class Main {
	static int dy[] = new int[101];
	static int DFS(int n) {
		if(dy[n]>0) return dy[n];
		if(n==1||n==2) return n;
		else return dy[n]=DFS(n-1)+DFS(n-2);
	}
	
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
		
		int n;
		n = in.nextInt();
		System.out.println(DFS(n));
		
	}
}