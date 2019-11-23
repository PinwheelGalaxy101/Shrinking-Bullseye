public class Dart 
{
	public static void main(String[] args) 
	{
		final int SIZE = 10000000;
		int[] score = new int[SIZE];
		int sum = 0;
		double radius, x, y, distance;

		long time1 = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			score[i] = 0;
			radius = 1.0;

			while(true) {
				score[i]++;
				x = 2.0*Math.random() - 1.0;
				y = 2.0*Math.random() - 1.0;
				distance = Math.sqrt(x*x + y*y);

				if(distance > radius)
					break;
				else
					radius = Math.sqrt(radius*radius - distance*distance);
			}

			sum += score[i];
		}
		long time2 = System.nanoTime();

		double average = (double) sum/SIZE, dev_tot = 0.0;

		for(int i=0; i < SIZE; i++) {
			dev_tot += (score[i] - average)*(score[i] - average);
		}

		double stdev = Math.sqrt(dev_tot / SIZE);

		System.out.println("3Blue1Brown's dart problem");
		System.out.println("Iteration no.: " + SIZE);
		System.out.println("Computation time: " + (time2 - time1)/1000000000.0);
		System.out.println("Mean score: " + average);
		System.out.println("Standard deviation of scores: " + stdev);
	}
}
