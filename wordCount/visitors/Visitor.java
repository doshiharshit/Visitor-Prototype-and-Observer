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
public interface Visitor {
	public void setFileProcessor(FileProcessor fpIn);
	public FileProcessor getFileProcessor();
	public MyTree visit(MyTree myTree);
}
