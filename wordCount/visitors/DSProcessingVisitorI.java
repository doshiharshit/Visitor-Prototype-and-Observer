/**
 * 
 */
package wordCount.visitors;

import wordCount.dsForStrings.MyTree;
import wordCount.dsForStrings.NodeI;
import wordCount.util.FileProcessor;

/**
 * @author Harshit
 *
 */
public class DSProcessingVisitorI implements Visitor {
	FileProcessor fp;
	
	@Override
	public void setFileProcessor(FileProcessor fpIn){
		fp = fpIn; 
	}
	
	@Override
	public FileProcessor getFileProcessor(){
		return fp;
	}
	
	public DSProcessingVisitorI(FileProcessor fpIn) {
		setFileProcessor(fpIn);
	}
	
	@Override
	public MyTree visit(MyTree myTree){
		try {
			MyTree treeBkup = new MyTree();
			treeBkup.setRoot((NodeI) myTree.getRoot().clone());
			return treeBkup;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} finally {
			
		}
		return null;
	}
}
