/**
 * 
 */
package wordCount.dsForStrings;

import wordCount.visitors.Visitor;

/**
 * @author Harshit
 *
 */
public class MyTree{
	private NodeI root;
	
	public NodeI getRoot() {
		return root;
	}

	public void setRoot(NodeI root) {
		this.root = root;
	}

	public void insert(String data){
		if(getRoot() != null){
			getRoot().insert(getRoot(), data);
		}else{
			setRoot(new Node(data));
		}
	}
	
	public String traverse(){
		return getRoot().traverse(getRoot());
	}
	
	public MyTree accept(Visitor visitor){
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return getRoot().toString();
	}
}
