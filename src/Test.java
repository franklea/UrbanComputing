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
		kdTree.printKdTree(root);
	}
}
