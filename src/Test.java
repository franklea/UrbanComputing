import java.io.IOException;
import java.util.ArrayList;


/**
 * @author lea
 *
 */
public class Test {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "sampledata.txt";
		String poiFileName = "POIYP.xls";
		
		XlsParse parser = new XlsParse();
		String[][] resPoi = null;
		try {
			resPoi = parser.readXls(poiFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parser.printRes(resPoi);
		
		
		ArrayList<Data> res = new ArrayList<Data>();
		Data data = new Data();
		res = data.readFromFile(fileName);
		/*
		for (Data d:res){
			d.printData();
		}
		*/
		SimpleKdTree kdTree = new SimpleKdTree();
		int first_dim = kdTree.firstDim(res);
		//System.out.println("first_dim: "+ first_dim);
		KdNode root = new KdNode();
		//root = kdTree.buildTree(res, first_dim);
		root = kdTree.buildTree(res);
		//kdTree.printKdTree(root);
		KdNode nearest = new KdNode();
		nearest = kdTree.NNQ(root, 2, 4.5);
		nearest.data.printData();
	}
}
