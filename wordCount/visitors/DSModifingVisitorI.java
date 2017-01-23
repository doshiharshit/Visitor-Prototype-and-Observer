/**
 * 
 */
package wordCount.visitors;

import wordCount.dsForStrings.MyTree;
import wordCount.util.FileProcessor;

/**
 * @author Harshit
 *
 */
public class DSModifingVisitorI implements Visitor {
	FileProcessor fp;
	
	@Override
	public void setFileProcessor(FileProcessor fpIn){
		fp = fpIn; 
	}
	
	@Override
	public FileProcessor getFileProcessor(){
		return fp;
	}
	
	public DSModifingVisitorI(FileProcessor fpIn) {
		setFileProcessor(fpIn);
	}
	
	@Override
	public MyTree visit(MyTree myTreeObj){
		myTreeObj.getRoot().updateCount(myTreeObj.getRoot().getCount() + 200);
//		myTreeObj.insert("a");
		return myTreeObj;
	}
}
