/**
 * 
 */
package wordCount.observer;

/**
 * @author Harshit
 *
 */
public interface Observer {
	/**
	 * @param count
	 * update message
	 * @return void
	 */
	public void updateCount(Integer count);
}
