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

	class Node {
		public Node parent;
		public Node leftChild;
		public Node rightChild;
		public Data data;

		public Node(){}
		
		public Node(Data data) {
			this.data = data;
			parent = null;
			leftChild = null;
			rightChild = null;
		}
		
		public Node(Data data, Node p, Node l, Node r) {
			this.data = data;
			parent = p;
			leftChild = l;
			rightChild = r;
		}
	}
	
	Node root;
	SimpleKdTree(){
		this.root = new Node();
	}

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
			Collections.sort(list, comparator_x);
		}
		return list;
	}
	
	public Node buildTree(ArrayList<Data> list, int first_dim) {
		ArrayList<Data> sortedList = sortList(list,first_dim);
		
		int index = sortedList.size()/2;
		Data target = sortedList.get(index);
		Node root = new Node(target);
		sortedList.remove(index);
		
		ArrayList<Data> left = new ArrayList();
		ArrayList<Data> right = new ArrayList();
		for (int i = 0; i< index; i++)
		{
			left.add(sortedList.get(i));
		}
		for(int j = index+1; j< sortedList.size(); j++){
			right.add(sortedList.get(j));
		}
		//buildSubTree(root, sortedList, first_dim);
		
		return root;
	}

	private void buildSubTree(Node parent, ArrayList<Data> list, int first_dim) {
		

		// TODO Auto-generated method stub
		int dim = (first_dim+1) % 2;
		list = sortList(list,dim);
		int median = list.size()/2;
		
		
	}

	public void printList(ArrayList<Data> list){
		for (Data d:list){
			d.printData();
		}
	}
	public Node findNode(double x, double y) {
		

		return null;
	}

	public ArrayList<Node> NNQ(Node tree, double x, double y) {
		ArrayList<Node> res = new ArrayList<Node>();

		return res;
	}

	public ArrayList<Node> SRQ(Node tree, double x, double y) {
		ArrayList<Node> res = new ArrayList<Node>();

		return res;
	}

}
