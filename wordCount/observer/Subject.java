/**
 * 
 */
package wordCount.observer;

import java.util.ArrayList;

import wordCount.dsForStrings.NodeI;

/**
 * @author Harshit
 *
 */
public interface Subject {	
	/**
	 * @return the observerList
	 */
	public ArrayList<NodeI> getObserversList();
	
	/**
	 * @param observersList the observersList (DataStructure) to set
	 * @return void
	 */
	public void setObserversList(ArrayList<NodeI> observersList);
	
	/**
	 * @param observerNode
	 * Registers Observer
	 * @return true if observer added successfully
	 */
	public Boolean registerObserver(NodeI observerNode);
	
	/**
	 * @param NodeI
	 * broadcasts message
	 * @return void
	 */
	public void notifyObservers(NodeI key);
}
