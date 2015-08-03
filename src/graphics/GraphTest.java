package graphics;

import java.io.IOException;

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

		/*Image test1 = new Pgm();
		Image test2 = new Pgm();

		test1.read(new FileInputStream("src/text.pgm"));

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		test1.write(bos);

		test2.read(new ByteArrayInputStream(bos.toByteArray()));

		Algorithms.meanFilter(test1, test2);

		// dest.flush();
		Algorithms.binarize((Pgm)test1, (Pgm)test2, 11, -3, 25, 25, test1.getWidth(), test2.getWidth());
		test2.write(new FileOutputStream("/tmp/apple.ppm"));

		System.out.print("Ok");*/

		
		int x = 0, y = 0, c1 = 0, c2 = 0;
		
		for(int i = 0; i < 1000000; i++){ 
			x = (int) (Math.random() * 100);
			y = (int) (Math.random() * 100);
			c1 ++;
			if(Math.sqrt(x * x + y * y) <= 100){
				c2 ++; 
				} 
			}
		 
		System.out.println(3.95 * ((double) c2 / (double) c1));
	}

}
