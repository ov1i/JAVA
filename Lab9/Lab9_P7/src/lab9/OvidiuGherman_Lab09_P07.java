package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/* 7. 
 * There is an urn which contains 1000 losing tickets and 1 winning ticket. There are N people around the urn (N is read
 * from the keyboard) which simultaneously extract tickets from it. The tickets are not placed back into the urn. When one
 * person extracts the winning ticket, the game stops.
 * Alternatives: 1) the persons extract the tickets in a predefined order; 2) the tickets are placed back into the urn
 */

class checkWin implements Callable<Integer> {
	
	private static volatile boolean found = false;
	private List<Boolean> urn;
	private Random random; 
	final private int threadId;
	
	public checkWin(List<Boolean> urn, Random random, int id) {
		this.threadId = id;
		this.urn = urn;
		this.random = random;
	}
	@Override
	public Integer call() throws Exception {
	    while (true) {
	        if (found) {
	            break;
	        }
	        int index = random.nextInt(0, urn.size());
	        if (urn.get(index)) {  
	        	System.out.println("Winner winner chicken dinner -> Thread: " + this.threadId);
	            found = true;	           
	        } else {
	            urn.remove(index);
	        }
	        if (urn.size() == 0) {
	            break;
	        }
	    }
	    return null;
	}

	
}

public class OvidiuGherman_Lab09_P07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		List<Boolean> urn = new ArrayList<>(Collections.nCopies(1000, false));
		urn.add(true);
		Collections.shuffle(urn);


		System.out.print("Please enter the number of persons: ");
		int ppl = scanner.nextInt();	
		scanner.close();
		
		ExecutorService people = Executors.newFixedThreadPool(ppl);
		
		for(int i = 0; i < ppl;i++) {
			people.submit(new checkWin(urn,random,i));
		}
		
		
		people.shutdown();
	}

}
