/**
 * 
 */
package wordCount.dsForStrings;

import java.util.ArrayList;
import java.util.Iterator;

import wordCount.util.Logger;

/**
 * @author Harshit
 *
 */
public class Node implements NodeI {
	private NodeI left;
	private NodeI right;
	private String data;
	private Integer count;
	private ArrayList<NodeI> observersList;
	private Boolean oberserverRegisteredFlag = false;
	
	/**
	 * @see wordCount.observer.Subject#getOberserverRegisteredFlag()
	 *//*
	@Override
	public Boolean getOberserverRegisteredFlag() {
		return oberserverRegisteredFlag;
	}

	*//**
	 * @see wordCount.observer.Subject#setOberserverRegisteredFlag(Boolean)
	 *//*
	@Override
	public void setOberserverRegisteredFlag(Boolean oberserverRegisteredFlag) {
		this.oberserverRegisteredFlag = oberserverRegisteredFlag;
	}*/
	
	/**
	 * @see wordCount.observer.Subject#getObserversList()
	 */
	@Override
	public ArrayList<NodeI> getObserversList() {
		return observersList;
	}

	/**
	 * @see wordCount.observer.Subject#setObserversList(ArrayList)
	 */
	@Override
	public void setObserversList(ArrayList<NodeI> observersList) {
		this.observersList = observersList;
	}

	/**
	 * @return 
	 */
	@Override
	public NodeI getLeft() {
		return left;
	}

	/**
	 * @see wordCount.dsForStrings.NodeI#getRight()
	 */
	@Override
	public NodeI getRight() {
		return right;
	}

	/**
	 * @see wordCount.dsForStrings.Node#getData()
	 */
	@Override
	public String getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see wordCount.wordCount.dsForStrings.Node#getCount()
	 */
	@Override
	public Integer getCount() {
		return count;
	}

	/* (non-Javadoc)
	 * @see wordCount.wordCount.dsForStrings.Node#setLeft(wordCount.wordCount.dsForStrings.Node)
	 */
	@Override
	public void setLeft(NodeI left) {
		this.left = left;
	}

	/* (non-Javadoc)
	 * @see wordCount.wordCount.dsForStrings.Node#setRight(wordCount.wordCount.dsForStrings.Node)
	 */
	@Override
	public void setRight(NodeI right) {
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see wordCount.wordCount.dsForStrings.Node#setData(java.lang.String)
	 */
	@Override
	public void setData(String data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see wordCount.wordCount.dsForStrings.Node#setCount(java.lang.Integer)
	 */
	@Override
	public void setCount(Integer count) {
		this.count = count;
	}

	public Node() {
		Logger.writeMessage("Node Constructor called", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public Node(String data) {
		Logger.writeMessage("Node Constructor called", Logger.DebugLevel.CONSTRUCTOR);
		setData(data);
		setCount(1);
		setObserversList(new ArrayList<NodeI>());
	}
	
	@Override
	public NodeI insert(NodeI key, String data){
		if(key == null){
			return new Node(data);
		}else{
			if( data.compareTo( key.getData() ) < 0 ){
				key.setLeft( key.insert(key.getLeft(), data) );
			}else if( data.compareTo( key.getData() ) > 0 ){
				key.setRight( key.insert(key.getRight(), data) );
			}else{
				key.updateCount(key.getCount() + 1);
			}
		}
		return key;
	}
	
	@Override
	public Boolean registerObserver(NodeI observerNode){
		if(observerNode != null){
			getObserversList().add(observerNode);
			return true;
		}
		return false;
	}
	
	@Override
	public void notifyObservers(NodeI key){
		for (Iterator<NodeI> iterator = key.getObserversList().iterator(); iterator.hasNext();) {
			NodeI nodeI = (NodeI) iterator.next();
			nodeI.updateCount(key.getCount());
		}
	}
	
	@Override
	public void updateCount(Integer count){
		setCount(count);
		if(oberserverRegisteredFlag){
			notifyObservers(this);
		}
	}
	
	@Override
	public String traverse(NodeI key){
		String leftNodes = null;
		if(key.getLeft() != null){
			leftNodes = traverse(key.getLeft());
		}else{
			leftNodes = "|<";
		}
		String keyData = " - " + key.getData() + " - ";
		String rightNodes = null;
		if(key.getRight() != null){
			rightNodes = traverse(key.getRight());
		}else{
			rightNodes = ">|";
		}
		return leftNodes + keyData + rightNodes;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		NodeI bkupNode = (NodeI) super.clone();
		if(this.getLeft() != null){
			bkupNode.setLeft( (NodeI) this.getLeft().clone() );
		}
		if(this.getRight() != null){
			bkupNode.setRight( (NodeI) this.getRight().clone() );
		}
		this.oberserverRegisteredFlag = this.registerObserver(bkupNode);
		return bkupNode;
	}
	
	@Override
	public String toString() {
//		return (getLeft() == null ? "|<" : getLeft()) + " - [" + (getData() + ":" + getCount()) + "] - " + (getRight() == null ? ">|" : getRight());
		return getData() + ":" + getCount();
	}
}
