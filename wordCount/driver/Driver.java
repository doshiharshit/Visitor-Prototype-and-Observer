/**
 * 
 */
package wordCount.driver;

import wordCount.dsForStrings.MyTree;
import wordCount.util.FileProcessor;
import wordCount.visitors.DSModifingVisitorI;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.WordCountVisitor;

/**
 * @author Harshit
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args!=null && args.length==3){}else{
			System.exit(0);
		}
		FileProcessor fp = new FileProcessor(args[0], args[1]);
		MyTree myTreeObj = new MyTree();
		
		Integer NUM_ITERATIONS = Integer.parseInt(args[2]);
		
		long startTime = System.currentTimeMillis();
		for(int i=0; i<NUM_ITERATIONS; i++){
			myTreeObj.accept(new PopulateVisitor(fp));
			myTreeObj.accept(new WordCountVisitor(fp));
		}
		long finishTime = System.currentTimeMillis();
		System.out.println((finishTime-startTime)/NUM_ITERATIONS);
		
		MyTree bkupTree = myTreeObj.accept(new DSProcessingVisitorI(fp));
		
		myTreeObj.accept(new DSModifingVisitorI(fp));
		WordCountVisitor wcV = new WordCountVisitor(fp);
		System.out.println("Original Tree Word Count: " + wcV.sumCount(bkupTree.getRoot())[1]);
		System.out.println("Backup Tree Word Count: " + wcV.sumCount(myTreeObj.getRoot())[1]);
	}

}
