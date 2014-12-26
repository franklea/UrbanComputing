import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implemention of a 2-d KdTree
 * 
 * @author lea
 *
 */

public class SimpleKdTree {	
	
	KdNode root;


	public int firstDim(ArrayList<Data> list) {
		// x_avg;
		double x_avg = 0;
		for (Data d : list) {
			x_avg += d.x / list.size();
		}
		// x_var
		double x_var = 0;
		for (Data d : list) {
			x_var += ((d.x - x_avg) * (d.x - x_avg)) / list.size();
		}

		// y_avg;
		double y_avg = 0;
		for (Data d : list) {
			y_avg += d.y / list.size();
		}
		// y_var
		double y_var = 0;
		for (Data d : list) {
			y_var += ((d.y - y_avg) * (d.y - y_avg)) / list.size();
		}
		
		return x_var >= y_var?0:1;
	}

	Comparator<Data> comparator_x = new Comparator<Data>(){
		public int compare(Data d1, Data d2){
			if (d1.x >= d2.x){
				return 1;
			}else{
				return 0;
			}
		}
	};
	
	Comparator<Data> comparator_y = new Comparator<Data>(){
		public int compare(Data d1, Data d2){
			if (d1.y >= d2.y){
				return 1;
			}else{
				return 0;
			}
		}
	};
	
	
	public ArrayList<Data> sortList(ArrayList<Data> list, int dim){
		if (dim == 0 /*x_dim*/){
			Collections.sort(list, comparator_x);
		}else if (dim == 1 /*y_dim*/){
			Collections.sort(list, comparator_y);
		}
		return list;
	}
	
	public KdNode buildTree(ArrayList<Data> list/*, int first_dim*/) {
		int first_dim = firstDim(list);
		if (list.isEmpty()){
			return null;
		}
		
		KdNode root = new KdNode();
		if(list.size() == 1){
			root.data = list.get(0);
			return root;
		}
		
		ArrayList<Data> sortedList = sortList(list,first_dim);
		//printList(sortedList);
		int median = sortedList.size()/2;
		root.data = sortedList.get(median);
		
		ArrayList<Data> left = new ArrayList();
		ArrayList<Data> right = new ArrayList();
		for (int i = 0; i< median; i++)
		{
			left.add(sortedList.get(i));
		}
		for(int j = median+1; j< sortedList.size(); j++){
			right.add(sortedList.get(j));
		}
		
		//int newDim = (first_dim+1)%2;
		
		//root.left = buildTree(left,newDim);
		//root.right = buildTree(right,newDim);
		root.left = buildTree(left);
		root.right = buildTree(right);
		return root;
	}


	public KdNode findNode(double x, double y) {
		

		return null;
	}

	public ArrayList<KdNode> NNQ(KdNode tree, double x, double y) {
		ArrayList<KdNode> res = new ArrayList<KdNode>();

		return res;
	}

	public ArrayList<KdNode> SRQ(KdNode tree, double x, double y) {
		ArrayList<KdNode> res = new ArrayList<KdNode>();

		return res;
	}
	
	public void printList(ArrayList<Data> list){
		for (Data d:list){
			d.printData();
		}
	}
	
	public void printKdTree(KdNode root){
		if (root != null){
			root.data.printData();
			System.out.println("=================");
			printKdTree(root.left);
			printKdTree(root.right);
		}
	}
}
