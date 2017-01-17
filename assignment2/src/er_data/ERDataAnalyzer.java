package er_data;


public class ERDataAnalyzer {
	// private methods here
	// If you find yourself writing the same code over and over, 
	// consider creating a private method which you can call instead.
	final static int NUM_WEEKS = 4;
	final static int NUM_DAYS = 7;
	final static int NUM_HOURS = 24;
	/**
	 * Returns the total number of patients for each week
	 * 
	 * @param data	a 3-d integer array corresponding to the number of visitations. 
	 * 				1st dimension corresponds to the week, 2nd dimension the day, 3rd dimension the hour 				
	 * @return 		an 1-d integer array of weekly totals
	 */
	public static int[] patientsPerWeek(int[][][] data) {
		int[] ppw = new int[NUM_WEEKS];
		
		for(int h=0;h<4;h++){
			for(int j=0;j<7;j++){
				for(int k=0;k<24;k++){
					ppw[h] = ppw[h] + data[h][j][k];
				}
			}
		}
		return ppw;
	}
	
	/**
	 * Returns the total number of visits for each day, for each week.
	 * 
	 * @param data	
	 * @return		2-d integer array of daily totals. 1st dimension is the week, 2nd is the day
	 */
	public static int[][] patientsPerDayPerWeek(int[][][] data) {
		int[][] ppdpw = new int[NUM_WEEKS][NUM_DAYS];
		for(int h=0;h<4;h++){
			for(int j=0;j<7;j++){
				for(int k=0;k<24;k++){
					ppdpw[h][j] = ppdpw[h][j] + data[h][j][k];
				}
			}
		}
		return ppdpw;
	}
	
	/**
	 * Returns the average number of patients seen in a day for each week.
	 * For example, given the following two weeks of daily visitations:
	 * 
	 * twoWeekDailyTotals = [[10, 10, 10, 15, 20, 20 20], [20, 20, 20, 30, 40, 40, 40]]
	 * assert averagePatientsPerWeek(twoWeekDailyTotals) == [15.0, 30.0]
	 * 
	 * @param data
	 * @return 		1-d double array of the average number of daily patients for each week
	 */
	public static double[] averagePatientsPerWeek(int[][][] data) {
		double[] appw = new double[NUM_WEEKS];
		
		for(int h=0;h<4;h++){
			for(int j=0;j<7;j++){
				for(int k=0;k<24;k++){
					appw[h] = appw[h] + data[h][j][k];
				}
			}
			appw[h] = appw[h]/NUM_DAYS;
		}
		return appw;
	}
	
	/**
	 * Returns the average number of patients seen on Sundays, Mondays, Tuesdays, etc. 
	 * over an n week period.
	 * 
	 * @param data
	 * @return 		a 1-d double array of daily average visitations
	 * 				where the 1st dimension corresponds to the day
	 */
	public static double[] averagePatientsPerDayAcrossWeeks(int[][][] data) {
		double[] appdaw = new double[NUM_DAYS];
		for(int j=0;j<7;j++){
			for(int h=0;h<4;h++){
				for(int k=0;k<24;k++){
					appdaw[j] = appdaw[j] + data[h][j][k];
				}
			}
			appdaw[j]= appdaw[j]/NUM_WEEKS;
		}
		return appdaw;
	}
	
	/**
	 * Returns an array of integers indexing the busiest day (most visits)
	 * of the week, for each week. For example, if the daily total visits
	 * over a two week period are:
	 * 
	 * twoWeekDailyTotals = [[10, 50, 20, 15, 30, 9 25], [20, 30, 60, 60, 10, 15, 5]]
	 * assert busiestDayPerWeek(twoWeekDailyTotals) == [1,  2]
	 * (In case of ties, just choose one of the busiest days)
	 * 
	 * 
	 * @param data
	 * @return		1-d integer array of array indices indicating, for each
	 *              week, the (or one of the) day(s) with the most visits 
	 */
	public static int[] busiestDayPerWeek(int[][][] data) {
		int[] bdpw = new int[NUM_WEEKS];
		for(int h=0;h<4;h++){
			int highest = 0;
			int[] dailyTotal = new int[NUM_DAYS];
			for(int j=0;j<7;j++){
				for(int k=0;k<24;k++){
					dailyTotal[j] = dailyTotal[j] + data[h][j][k];
				}
				if(dailyTotal[j]>highest){
					highest = dailyTotal[j];
					bdpw[h]=j;
				}
			}
		}
		return bdpw;
	}
	
	/**
	 * Returns an array of integers indexing the least busy day (fewest visits)
	 * of the week, for each week.
	 * 
	 * @param data
	 * @return		1-d integer array of array indices indicating, for each
	 * 				week, the (or one of the) day(s) with the fewest visits 
	 */
	public static int[] leastBusyDayPerWeek(int[][][] data) {
		int[] ldpw = new int[NUM_WEEKS];
		for(int h=0;h<4;h++){
			int lowest = Integer.MAX_VALUE;
			int[] dailyTotal = new int[NUM_DAYS];
			for(int j=0;j<7;j++){
				for(int k=0;k<24;k++){
					dailyTotal[j] = dailyTotal[j] + data[h][j][k];
				}
				if(dailyTotal[j]<lowest){
					lowest = dailyTotal[j];
					ldpw[h]=j;
				}
			}
		}
		return ldpw;	
	}
}
