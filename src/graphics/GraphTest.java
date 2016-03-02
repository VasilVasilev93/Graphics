package graphics;

import java.io.IOException;
import java.util.Random;

public class GraphTest extends Thread {

	public static void main(String[] args) throws IOException, InterruptedException {
		// long currentTimeMillis = System.currentTimeMillis();
		// for (int iCnter = 0; iCnter < 100; iCnter ++) {
		/*
		 * BinarizeThread } thread1 = new BinarizeThread(test1, test2, 0, 0,
		 * test1.getWidth() / 2, test1.getHeight() / 2); BinarizeThread thread2
		 * = new BinarizeThread(test1, test2, test1.getWidth() / 2, 0,
		 * test1.getWidth(), test1.getHeight() / 2); BinarizeThread thread3 =
		 * new BinarizeThread(test1, test2, 0, test1.getHeight() / 2,
		 * test1.getWidth() / 2, test1.getHeight()); BinarizeThread thread4 =
		 * new BinarizeThread(test1, test2, test1.getWidth() / 2,
		 * test1.getHeight() / 2, test1.getWidth(), test1.getHeight());
		 */

		// BinarizeThread thread1 = new BinarizeThread(test1, test2, 0, 0,
		// test1.getWidth() / 2, test1.getHeight() / 2);
		// BinarizeThread thread2 = new BinarizeThread(test1, test2, 0,
		// test1.getHeight() / 2, test1.getWidth() / 2, test1.getHeight());
		// BinarizeThread thread3 = new BinarizeThread(test1, test2,
		// test1.getWidth() / 2, 0, test1.getWidth(), test1.getHeight() / 2);
		// BinarizeThread thread4 = new BinarizeThread(test1, test2,
		// test1.getWidth() / 2, test1.getHeight() / 2, test1.getWidth(),
		// test1.getHeight());
		//
		/*
		 * BinarizeThread thread1 = new BinarizeThread(test1, test2, 0, 0,
		 * test1.getWidth() / 4, test1.getHeight()); BinarizeThread thread2 =
		 * new BinarizeThread(test1, test2, test1.getWidth() / 4, 0,
		 * test1.getWidth() / 2, test1.getHeight()); BinarizeThread thread3 =
		 * new BinarizeThread(test1, test2, test1.getWidth() / 2, 0, (3 *
		 * test1.getWidth())/ 4, test1.getHeight()); BinarizeThread thread4 =
		 * new BinarizeThread(test1, test2, (3 * test1.getWidth())/ 4, 0,
		 * test1.getWidth(), test1.getHeight());
		 */

		/*
		 * BinarizeThread thread1 = new BinarizeThread(test1, test2, 0, 0,
		 * test1.getWidth(), test1.getHeight() / 4); BinarizeThread thread2 =
		 * new BinarizeThread(test1, test2, 0, test1.getHeight() / 4,
		 * test1.getWidth(), test1.getHeight() / 2); BinarizeThread thread3 =
		 * new BinarizeThread(test1, test2, 0, test1.getHeight() / 2,
		 * test1.getWidth(), (3 * test1.getHeight()) / 4); BinarizeThread
		 * thread4 = new BinarizeThread(test1, test2, 0, (3 * test1.getHeight())
		 * / 4, test1.getWidth(), test1.getHeight());
		 */

		/*
		 * BinarizeThread thread1 = new BinarizeThread(test1, test2, 0, 0,
		 * test1.getWidth() / 2, test1.getHeight() / 4); BinarizeThread thread2
		 * = new BinarizeThread(test1, test2, test1.getWidth() / 2, 0,
		 * test1.getWidth(), test1.getHeight() / 4); BinarizeThread thread3 =
		 * new BinarizeThread(test1, test2, 0, test1.getHeight() / 4,
		 * test1.getWidth() / 2, test1.getHeight() / 2); BinarizeThread thread4
		 * = new BinarizeThread(test1, test2, test1.getWidth() / 2,
		 * test1.getHeight() / 4, test1.getWidth(), test1.getHeight() / 2);
		 * 
		 * BinarizeThread thread5 = new BinarizeThread(test1, test2, 0,
		 * test1.getHeight() / 2, test1.getWidth() / 2, (3 * test1.getHeight())
		 * / 4); BinarizeThread thread6 = new BinarizeThread(test1, test2,
		 * test1.getWidth() / 2, test1.getHeight() / 2, test1.getWidth(), (3 *
		 * test1.getHeight()) / 4); BinarizeThread thread7 = new
		 * BinarizeThread(test1, test2, 0, (3 * test1.getHeight()) / 4,
		 * test1.getWidth() / 2, test1.getHeight()); BinarizeThread thread8 =
		 * new BinarizeThread(test1, test2, test1.getWidth() / 2, (3 *
		 * test1.getHeight()) / 4, test1.getWidth(), test1.getHeight());
		 */

		/*
		 * BinarizeThread thread1 = new BinarizeThread(test1, test2, 0, 0,
		 * test1.getWidth() / 4, test1.getHeight() / 2); BinarizeThread thread2
		 * = new BinarizeThread(test1, test2, 0, test1.getHeight() / 2,
		 * test1.getWidth() / 4, test1.getHeight()); BinarizeThread thread3 =
		 * new BinarizeThread(test1, test2, test1.getWidth() / 4, 0,
		 * test1.getWidth() / 2, test1.getHeight() / 2); BinarizeThread thread4
		 * = new BinarizeThread(test1, test2, test1.getWidth() / 4,
		 * test1.getHeight() / 2, test1.getWidth() / 2, test1.getHeight());
		 * 
		 * BinarizeThread thread5 = new BinarizeThread(test1, test2,
		 * test1.getWidth() / 2, 0, ( 3 * test1.getWidth()) / 4,
		 * test1.getHeight() / 2); BinarizeThread thread6 = new
		 * BinarizeThread(test1, test2, test1.getWidth() / 2, test1.getHeight()
		 * / 2, ( 3 * test1.getWidth()) / 4, test1.getHeight()); BinarizeThread
		 * thread7 = new BinarizeThread(test1, test2, ( 3 * test1.getWidth()) /
		 * 4, 0, test1.getWidth(), test1.getHeight() / 2); BinarizeThread
		 * thread8 = new BinarizeThread(test1, test2, ( 3 * test1.getWidth()) /
		 * 4, test1.getHeight() / 2, test1.getWidth(), test1.getHeight());
		 */

		// thread1.start();
		// thread2.start();
		// thread3.start();
		// thread4.start();
		/*
		 * thread5.start(); thread6.start(); thread7.start(); thread8.start();
		 */
		// thread1.join();
		// thread2.join();
		// thread3.join();
		// thread4.join();
		/*
		 * thread5.join(); thread6.join(); thread7.join(); thread8.join();
		 */
		// }
		// thread2.join();
		// algo.binarize((Pgm)test1, (Pgm)test2, 7, -4);
		// System.out.println("Milliseconds: " + (System.currentTimeMillis() -
		// currentTimeMillis));*/
		// test2.write("/tmp4/test3.pgm");
		
		/*

		Image test1 = new Ppm();
		Image test2 = new Ppm();

		test1.read(new FileInputStream("src/random.ppm"));

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		test1.write(bos);

		test2.read(new ByteArrayInputStream(bos.toByteArray()));

		Algorithms.meanFilter(test1, test2);

		// dest.flush();
		Algorithms.binarize((Ppm)test1, (Ppm)test2, 3, -2, test1.getWidth(), test2.getHeight());
		test2.write(new FileOutputStream("/tmp/apple.ppm"));

		System.out.print("Ok");

		*/
		long x = 0, y = 0;
		int c1 = 0, c2 = 0;
		
		Random r = new Random();
		
		for(int i = 0; i < 1000000; i++){ 
			x = r.nextLong() % 100000L;
			y = r.nextLong() % 100000L;
			c1 ++;
			if(x * x + y * y < 10000000000L){
				c2 ++; 
				} 
			}
		 
		System.out.println(4 * ((double) c2 / (double) c1));
	}

}
