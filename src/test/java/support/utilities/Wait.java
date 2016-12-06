package support.utilities;

import java.util.concurrent.TimeUnit;

/**
 * Methods related to sleep/wait_time
 * @author Chris
 */
public class Wait {
	
	/**
	 * Sleep/wait desired amount of time in seconds.
	 * @param wait_time - time to wait in seconds.
	 * @param message - message to display.
	 * @throws InterruptedException
	 */
	public static void sleep(int wait_time, String message) throws InterruptedException{
		if (message != ""){
			TestLog.info(message + " - wait time: " + String.valueOf(wait_time) + " seconds.");
		}
		else {
			TestLog.info("Wait Time: " + String.valueOf(wait_time) + " second(s).");
		}
		TimeUnit.SECONDS.sleep(wait_time);
	}
	
	/**
	 * Sleep/wait desired amount of time in seconds.
	 * @param wait_time - time to wait in seconds
	 * @throws InterruptedException
	 */
	public static void sleep(int wait_time) throws InterruptedException{
		String message = "";
		sleep(wait_time, message);
	}
	
	/**
	 * Sleep/wait desired amount of time in milliseconds
	 * @param wait_time - time to wait in milliseconds
	 * @throws InterruptedException 
	 */
	public static void sleep_ms(int wait_time) throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(wait_time);
	}
	
	/**
	 * Wait prior to or after performing an action on element.
	 * @param wait - true: wait
	 *               false: don't wait
	 * @param wait_time - amount of time in milliseconds to wait.
	 * @throws InterruptedException
	 */
	public static void wait_during_action(Boolean wait, int wait_time) throws InterruptedException{
		if (wait){
			sleep_ms(wait_time);
		}
	}
}
