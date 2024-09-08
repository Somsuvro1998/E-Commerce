package generic_utilities;

import java.util.Random;

public class Java_Utility {
	/*
	 * Used to generate a random number between 0 to 1000
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
		
	}

}
