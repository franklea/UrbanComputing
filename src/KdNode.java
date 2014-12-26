class KdNode {
		public KdNode left;
		public KdNode right;
		public Data data;

		public KdNode(){
			this.data = null;
			this.left = null;
			this.right = null;
		}
		
		public KdNode(Data data) {
			this.data = data;
			this.left = null;
			this.right= null;
		}
	}