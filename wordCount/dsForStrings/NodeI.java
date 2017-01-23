/**
 * 
 */
package wordCount.dsForStrings;

import wordCount.observer.Observer;
import wordCount.observer.Subject;

/**
 * @author Harshit
 *
 */
public interface NodeI extends Subject, Observer, Cloneable {
	public NodeI getLeft();
	public NodeI getRight();
	public String getData();
	public Integer getCount();
	public void setLeft(NodeI left);
	public void setRight(NodeI right);
	public void setData(String data);
	public void setCount(Integer count);
	
	public NodeI insert(NodeI key, String data);
	public String traverse(NodeI key);
	public Boolean registerObserver(NodeI observerNode);
	public void notifyObservers(NodeI key);
	@Override
	String toString();
	
	public Object clone() throws CloneNotSupportedException;
}
