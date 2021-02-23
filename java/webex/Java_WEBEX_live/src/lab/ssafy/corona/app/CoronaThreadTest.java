package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaRunnable;

public class CoronaThreadTest {

	public static void main(String[] args) {
		for( int t=0; t<1000; t++ ) {
			
			CoronaRunnable cr = new CoronaRunnable(t);
			Thread thread = new Thread(cr);
			thread.start();
			
		}
	}
}