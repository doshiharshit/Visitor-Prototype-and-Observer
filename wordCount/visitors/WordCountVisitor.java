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
public class WordCountVisitor implements Visitor {
	FileProcessor fp;
	
	@Override
	public void setFileProcessor(FileProcessor fpIn){
		fp = fpIn; 
	}
	
	@Override
	public FileProcessor getFileProcessor(){
		return fp;
	}
	
	public WordCountVisitor(FileProcessor fpIn) {
		setFileProcessor(fpIn);
	}
	
	@Override
	public MyTree visit(MyTree myTree){
		Integer[] nodesSum = sumCount(myTree.getRoot());
		getFileProcessor().writeToFile("No. of Distinct Words: " + nodesSum[0] + ", No. of Words: " + nodesSum[1] + ", No. of Characters: " + nodesSum[2]);
		return myTree;
	}
	
	public Integer[] sumCount(NodeI node){
		Integer[] nSum = { 0, 0, 0 };
		if(node != null){
			sumIntArray(nSum, sumCount(node.getLeft()));
			sumIntArray(nSum, new Integer[]{ 1, node.getCount(), (node.getCount() * node.getData().length()) });
			sumIntArray(nSum, sumCount(node.getRight()));
		}
		return nSum;
	}
	
	public Integer[] sumIntArray(Integer[] dest, Integer[] src){
		for(int i=0; i<dest.length; i++){
			dest[i] = dest[i] + src[i];
		}
		return dest;
	}
}
