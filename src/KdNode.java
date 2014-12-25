class KdNode {
		public KdNode left;
		public KdNode right;
		public Data data;

		public KdNode(){}
		
		public KdNode(Data data) {
			this.data = data;
			left = null;
			right= null;
		}
	}