package com.ericsson.algorithms.cormen;

public class TreeNode {

	public int key;
	public Object value;
	public int size;
	
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int key, Object value) {
		this.key = key;
		this.value = value;
		this.size = 1;
	}
	
	@Override
	public String toString() {
		return key + "";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TreeNode) {
			TreeNode node = (TreeNode) obj;
			if(key == node.key && value.equals(node.value)) {
				if(!(left == null && node.left == null))
					return false;
				if(!(right == null && node.right == null))
					return false;
				
				if(left.equals(node.left) && right.equals(node.right))
					return true;
			}
		}
		
		return false;
	}
	
	

}
