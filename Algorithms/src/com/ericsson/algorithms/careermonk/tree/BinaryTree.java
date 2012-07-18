package com.ericsson.algorithms.careermonk.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	
	private static final int TYPE_NON_LEAF = 0;
	private static final int TYPE_LEAF = 1;
	
	private BinaryTreeNode root;

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public BinaryTree(List<BinaryTreeNode> inOrder, List<BinaryTreeNode> preOrder) {
		this.root = constructTree(inOrder, preOrder);
	}
	
	public BinaryTree(List<BinaryTreeNode> preOrder, int[] type) {
		this.root = constructTree(preOrder, 0, type);
	}
	
	private BinaryTreeNode constructTree(List<BinaryTreeNode> inOrder, List<BinaryTreeNode> preOrder) {
		
		BinaryTreeNode root = preOrder.get(0);
		int indexOfRootInOrder = inOrder.indexOf(root);
		if(indexOfRootInOrder == -1)
			return null;
		
		List<BinaryTreeNode> inOrderLeft = inOrder.subList(0, indexOfRootInOrder);
		List<BinaryTreeNode> inOrderRight = inOrder.subList(indexOfRootInOrder + 1, inOrder.size());
		List<BinaryTreeNode> preOrderLeft = preOrder.subList(1, 1 + inOrderLeft.size());
		List<BinaryTreeNode> preOrderRight = preOrder.subList(1 + inOrderLeft.size(), preOrder.size());
		
		root.left = constructTree(inOrderLeft, preOrderLeft);
		root.right = constructTree(inOrderRight, preOrderRight);
		
		return root;
	}
	
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode child) {
		parent.setLeft(child);
	}
	
	public void insertRight(BinaryTreeNode parent, BinaryTreeNode child) {
		parent.setRight(child);
	}
	
	public void inOrderRecursive(BinaryTreeNode root) {
		
		if(root != null) {
			preOrderRecursive(root.left);
			System.out.print(root + ", ");
			preOrderRecursive(root.right);
		}
	}
	
	public void preOrderRecursive(BinaryTreeNode root) {
		
		if(root != null) {
			System.out.print(root + ", ");
			
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	
	public void preOrderIterative(BinaryTreeNode root) {
		
		if(root != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.add(root);
			
			while(!stack.isEmpty()) {
				BinaryTreeNode node = stack.pop();
				
				System.out.print(node + ", ");
				if(node.right != null)
					stack.add(node.right);
				if(node.left != null)
					stack.add(node.left);
			}
		}
	}
	
	public void postOrderRecursive(BinaryTreeNode root) {
		if(root != null) {
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			System.out.print(root + ", ");
		}
	}
	
	public void postOrderIterative(BinaryTreeNode root) {
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(true) {
			
			if(root != null) {
				stack.add(root);
				root = root.left;
			} else {
				if(stack.isEmpty()) {
					return;
				}
				
				if(stack.peek().right == null) {
					root = stack.pop();
					//stack.pop();
					System.out.print(root + ", ");
					if(root == stack.peek().right) {
						System.out.print(stack.peek() + ", ");
						stack.pop();
					}
				} 
				
				if(!stack.isEmpty())
					root = stack.peek().right;
				else
					root = null;
			}
		}

	}
	
	public void printLevelOrderReverse(BinaryTreeNode root) {
		
		if(root != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.addFirst(root);
			
			while(queue.size() > 0) {
				BinaryTreeNode node = queue.removeLast();
				
				stack.add(node);
				if(node.right != null)
					queue.addFirst(node.right);
				if(node.left != null)
					queue.addFirst(node.left);
			}
			
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + ", ");
			}
		}
	}
	
	public int maximumSumLevel(BinaryTreeNode root) {
		if(root != null) {
			int maxSum = Integer.MIN_VALUE;
			LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.addFirst(root);
			
			while(queue.size() > 0) {
				BinaryTreeNode node = queue.removeLast();
			}
		}
		 
		 return -1;
	}
	
	public LinkedList<BinaryTreeNode> findMaxSumPath(BinaryTreeNode root, int[] maxSum) {
		if (root != null) {
			LinkedList<BinaryTreeNode> maxSumListLeft = findMaxSumPath(root.left, maxSum);
			LinkedList<BinaryTreeNode> maxSumListRight = findMaxSumPath(root.right, maxSum);

			int leftSum = 0;
			int rightSum = 0;
			if(root.left != null)
				leftSum = maxSum[root.left.id];
			if(root.right != null)
				rightSum = maxSum[root.right.id];

			if (leftSum >= rightSum) {
				maxSum[root.id] = leftSum + root.id;
				maxSumListLeft.addFirst(root);
				return maxSumListLeft;
			} else {
				maxSum[root.id] = rightSum + root.id;
				maxSumListRight.addFirst(root);
				return maxSumListRight;
			}
		}
		
		return new LinkedList<BinaryTreeNode>();
	}
	
	public void printAllPaths(BinaryTreeNode root, List<BinaryTreeNode> path) {
		
		if(root != null) {
			if(root.left == null && root.right == null) {
				path.add(root);
				System.out.println(path);
			}
			else {
				List<BinaryTreeNode> temp = null;
				if(root.left != null) {
					temp = new ArrayList<BinaryTreeNode>(path);
					temp.add(root);
					printAllPaths(root.left, temp);
				}
				if(root.right != null) {
					temp = new ArrayList<BinaryTreeNode>(path);
					temp.add(root);
					printAllPaths(root.right, temp);
				}
			}
		}
	}
	
	public boolean pathWithSumExists(BinaryTreeNode root, int S) {
		if (root != null) {
			if(S == 0)
				return true;
			else if(S < 0)
				return false;
			
			return pathWithSumExists(root.left, S - (root.id + 1))
					|| pathWithSumExists(root.right, S - (root.id + 1));
		}
		
		return false;
	}
	
	public void mirror(BinaryTreeNode root) {
		if(root != null) {
			BinaryTreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			mirror(root.left);
			mirror(root.right);
		}
	}
	
	public boolean printPath(BinaryTreeNode root, BinaryTreeNode destination) {
//		if(root != null) {
//			path.add(root);
//			if(root.equals(destination)) {
//				System.out.println(path);
//				return true;
//			}
//			else {
//				boolean isPrintedInLeft = false;
//				boolean isPrintedInRight = false;
//
//				if(root.left != null) {
//					List<BinaryTreeNode> leftPath = new ArrayList<BinaryTreeNode>(path);
//					isPrintedInLeft = printPath(root.left, destination, leftPath);
//				}
//				if(root.right != null) {
//					List<BinaryTreeNode> rightPath = new ArrayList<BinaryTreeNode>(path);
//					isPrintedInRight = printPath(root.right, destination, rightPath);
//				}
//				
//				if(isPrintedInLeft || isPrintedInRight)
//					return true;
//			}
//			
//		}
//		
//		return false;
		
		if (root == null || destination == null)
			return false;

		if (root != null) {
			if (root.equals(destination) || printPath(root.left, destination)
					|| printPath(root.right, destination)) {
				System.out.print(root + ", ");
				return true;
			}
		}

		return false;
	}
	
	public BinaryTreeNode leastCommonAncestor(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		if(root != null) {

			if(root.equals(a) || root.equals(b))
				return root;
			
			BinaryTreeNode lcaInLeft = leastCommonAncestor(root.left, a, b);
			BinaryTreeNode lcaInRight = leastCommonAncestor(root.right, a, b);
			
			if(lcaInLeft != null && lcaInRight != null)
				return root;
			else if(lcaInLeft != null) {
				return lcaInLeft;
			} else if(lcaInRight != null) {
				return lcaInRight;
			}
		}

		return null;
	}
	
	public List<BinaryTreeNode> findAllAncestors(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		
		if(root != null) {
			
			if(root.equals(a)) {
				List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
				list.add(a);
				return list;
			} else if(root.equals(b)) {
				List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
				list.add(b);
				return list;
			}
			
			List<BinaryTreeNode> allAncestorsLeft = findAllAncestors(root.left, a, b);
			List<BinaryTreeNode> allAncestorsRight = findAllAncestors(root.right, a, b);
			
			if(allAncestorsLeft != null && allAncestorsRight != null) {
				List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
				list.add(root);
				return list;
			} else if(allAncestorsLeft != null) {
				allAncestorsLeft.add(root);
				return allAncestorsLeft;
			} else if(allAncestorsRight != null) {
				allAncestorsRight.add(root);
				return allAncestorsRight;
			}
		}
		
		return null;
	}
	
	public void printLevelOrderZigZag(BinaryTreeNode root) {
		if(root != null) {
			int level = 0;
			LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			LinkedList<BinaryTreeNode> levelQueue = new LinkedList<BinaryTreeNode>();
			levelQueue.add(root);
			
			while(true) {
				while(queue.size() > 0) {
					BinaryTreeNode node = queue.removeLast();
					
					if(level % 2 == 1) {
						if(node.right != null)
							levelQueue.addFirst(node.right);
						if(node.left != null)
							levelQueue.addFirst(node.left);
					} else {
						if(node.left != null)
							levelQueue.addFirst(node.left);
						if(node.right != null)
							levelQueue.addFirst(node.right);
					}
				}
				
				level++;
				
				if(levelQueue.size() > 0) {
					while(levelQueue.size() > 0) {
						BinaryTreeNode node = levelQueue.removeLast();
						System.out.print(node + ", ");
						queue.add(node);
					}
				} else {
					return;
				}
			}
		}
	}
	
	public BinaryTreeNode constructTree(List<BinaryTreeNode> preOrder,
			int rootIndex, int[] type) {

		if (rootIndex >= preOrder.size()) {
			return null;
		}

		BinaryTreeNode root = preOrder.get(rootIndex);
		if (type[root.id] == TYPE_NON_LEAF) {
			root.left = constructTree(preOrder, rootIndex + 1, type);
			root.right = constructTree(preOrder, rootIndex + 2, type);
		}

		return root;
	}

	
	public BinaryTreeNode maxBinarySearchTree(BinaryTreeNode root, int[] max,
			int[] min) {

		if (root != null) {
			if (root.left == null && root.right == null)
				return root;

			BinaryTreeNode maxTreeLeft = maxBinarySearchTree(root.left, max,
					min);
			BinaryTreeNode maxTreeRight = maxBinarySearchTree(root.right, max,
					min);

			if (root.left != null && root.right != null) {
				max[root.id] = Math.max(root.id,
						Math.max(max[root.left.id], max[root.right.id]));
				min[root.id] = Math.min(root.id,
						Math.min(min[root.left.id], min[root.right.id]));
			} else if (root.left != null) {
				max[root.id] = Math.max(root.id, max[root.left.id]);
				min[root.id] = Math.min(root.id, min[root.left.id]);
			} else if (root.right != null) {
				max[root.id] = Math.max(root.id, max[root.right.id]);
				min[root.id] = Math.min(root.id, min[root.right.id]);
			}

			if (maxTreeLeft != null && maxTreeRight != null) {
				if (maxTreeLeft == root.left && maxTreeRight == root.right
						&& max[root.id] >= max[maxTreeLeft.id]
						&& min[root.id] < min[maxTreeRight.id]) {
					return root;
				} else {
					// return maxSize tree from right and left
				}
			} else if (maxTreeLeft != null) {
				if (maxTreeLeft == root.left && maxTreeLeft.id <= root.id
						&& max[root.id] >= max[maxTreeLeft.id])
					return root;
				else
					return maxTreeLeft;
			} else if (maxTreeRight != null) {
				if (maxTreeRight == root.right && maxTreeRight.id > root.id
						&& min[root.id] < min[maxTreeRight.id])
					return root;
				else
					return maxTreeRight;
			}
		}

		return null;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode node1 = new BinaryTreeNode(0);
		BinaryTreeNode node2 = new BinaryTreeNode(1);
		BinaryTreeNode node3 = new BinaryTreeNode(2);
		BinaryTreeNode node4 = new BinaryTreeNode(3);
		BinaryTreeNode node5 = new BinaryTreeNode(4);
		BinaryTreeNode node6 = new BinaryTreeNode(5);
		BinaryTreeNode node7 = new BinaryTreeNode(6);
		BinaryTreeNode node8 = new BinaryTreeNode(7);
		
		BinaryTree tree = new BinaryTree(node1);
		
		tree.insertLeft(node1, node2);
		tree.insertRight(node1, node3);
		tree.insertLeft(node2, node4);
		tree.insertRight(node2, node5);
		tree.insertLeft(node5, node7);
		tree.insertRight(node3, node6);
		tree.insertLeft(node6, node8);
		
		
		
		//tree.preOrderRecursive(node1);
//		System.out.println();
//		tree.preOrderIterative(node1);
		
//		tree.postOrderRecursive(node1);
//		System.out.println();
//		tree.postOrderIterative(node1);
		
		//tree.printLevelOrderReverse(node1);
		//System.out.println(tree.findMaxSumPath(node1, new int[8]));
		//tree.printAllPaths(node1, new ArrayList<BinaryTreeNode>());
		
		//System.out.println(tree.pathWithSumExists(node1, 10));
		
		//tree.printPath(node1, node8);
		//System.out.println(tree.findAllAncestors(node1, node8, node7));
		//tree.printLevelOrderZigZag(node1);
		
		List<BinaryTreeNode> preOrder = new ArrayList<BinaryTreeNode>(
				Arrays.asList(new BinaryTreeNode[] { node1, node2, node4,
						node5, node7, node3, node6, node8 }));
		int[] type = new int[] {0, 0, 0, 1, 0, 0, 1, 1};
		
		BinaryTree tree1 = new BinaryTree(preOrder, type);
		tree1.inOrderRecursive(node1);
	}
}
