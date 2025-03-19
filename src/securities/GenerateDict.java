package securities;

import java.util.Random;

public class GenerateDict {
	public static void main(String args[]) {
		Random rand = new Random();
		for(int i = 1; i <=41 ; i++) {
			System.out.println("admin"+rand.nextInt(150));
		}
	}
}
