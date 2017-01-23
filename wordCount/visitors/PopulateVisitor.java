/**
 * 
 */
package wordCount.visitors;

import java.util.StringTokenizer;

import wordCount.dsForStrings.MyTree;
import wordCount.util.FileProcessor;

/**
 * @author Harshit
 *
 */
public class PopulateVisitor implements Visitor {
	FileProcessor fp;
	
	@Override
	public void setFileProcessor(FileProcessor fpIn){
		fp = fpIn; 
	}
	
	@Override
	public FileProcessor getFileProcessor(){
		return fp;
	}
	
	public PopulateVisitor(FileProcessor fpIn) {
		setFileProcessor(fpIn);
	}
	
	@Override
	public MyTree visit(MyTree myTreeObj){
		String fileLine = null;
		while ( (fileLine = getFileProcessor().readFileContents()) != null){
			StringTokenizer strTok = new StringTokenizer(fileLine, " \t\n\r\f");
			String term = null;
			while (strTok.hasMoreTokens()) {
				term = strTok.nextToken();
//				term = term.replaceAll("[^\\p{L}\\p{N}]", "");
				myTreeObj.insert(term);
			}
		}
		return myTreeObj;
	}
}
