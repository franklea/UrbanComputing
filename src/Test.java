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
		String fileName = "F:\\workspace2\\UrbanComputing\\src\\sampledata.txt";
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
		System.out.println("first_dim: "+ first_dim);
		//kdTree.buildTree(res,first_dim);
		
		

	}

}