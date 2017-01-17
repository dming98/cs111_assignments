package er_data;

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ERDataReader {
	public static int[][][] readData(String dataFile) throws FileNotFoundException, NoSuchElementException, IllegalStateException  {	
		Scanner file = new Scanner(new FileReader(dataFile));
		
		final int NUM_WEEKS = 4;
		final int NUM_DAYS = 7;
		final int NUM_HOURS = 24;
		
		int[][][] data = new int[NUM_WEEKS][NUM_DAYS][NUM_HOURS];
		
		for(int h=0;h<NUM_WEEKS;h++){
			for(int j=0;j<NUM_DAYS;j++){
				for(int k=0;k<NUM_HOURS;k++){
						data[h][j][k] = file.nextInt();
				}
			}
		}
		return data;
	}
}
