import java.util.ArrayList;
import java.util.HashSet;

/* Tree class allows for the creations of various types of trees (Binary Search Trees), Min Heap, Max Heap, and unorganized trees.
 * Unorganized trees will also have a method to organize the tree and sort it into whatever tree type is desired by the user (see types
 * above). Additionally there is also a self balancing tree method that will ad the functionality to balance any binary search tree.
 * 
 */

// Available methods: addLeftChild, addRightChild, isBinarySearchTree, isMinHeapTree, isMaxHeapTree, CreateBinarySearchTree,
//						CreateMinHeap, CreateMaxHeap, nodeExists
// Tested methods: addLeftChild, addRightChild,
// Currently working on : CreateBinarySearchTree

public class Trees {
	NodeObject root = null;
	
	public Trees(NodeObject rootIn) {
		root = rootIn;
	}
	
	// Checks if the tree is organized into a BST form
	public boolean isBinarySearchTree() {
		
		return false;
	}
	
	// Orders an existing tree into a well balanced BST
	public boolean CreateBinarySearchTree() {
		// We can't reorganize the tree as we recurse because it might change the tree
		// so first we have to store the tree nodes in an array list and then we can start reorganizing
		HashSet<NodeObject> DFTOrderedSet = new HashSet<NodeObject>();
		ArrayList<NodeObject> unorderedList = new ArrayList<NodeObject>();
		
		DFTOrderedSet = DFTOrderTree(root, DFTOrderedSet);

		// To make the best possible tree we must find a good middle node for the root
		// the best way to arrange the tree to make it balanced is to order the nodes by increasing order
		// then pick the middle of each sector as the root of each branch
		
		// Loop through the set adding it to an ArrayList
		for (NodeObject nodes : DFTOrderedSet) {
			unorderedList.add(nodes);}
		
		//perform quick sort on the array
		NodeObject[] orderedList = unorderedList.toArray(new NodeObject[unorderedList.size()]);
		
		// perform quick sort on the list
		orderedList = quickSort(orderedList, 0, orderedList.length);
		
		
		// TODO: Used the orderedList to create a balanced BST
		
		return false;
		
	}
	
	private NodeObject[] quickSort(NodeObject[] orderedList, int min, int max) {
		// first pick set pivot using the right most node, and then perform quick sort on both left and right halves
		
		if (min <= max) { return orderedList; } // stop if the list has been split to the max
		
		int middleNode = setPivot(orderedList, min, max);
		
		orderedList = quickSort(orderedList, min, middleNode-1);
		orderedList = quickSort(orderedList, middleNode+1, max);
		
		return orderedList;
	}
	
	// loops through the array organizing it into values smaller than and greater than pivot
	private int setPivot(NodeObject[] orderedList, int min, int max) {
		NodeObject pivot = orderedList[max];
		NodeObject temp;
		int k = min -1;
		
		for (int j=0; j<max-1; j++) { //loop through the array except for the last element (pivot)
			if (orderedList[j].key <= pivot.key) { /// swap arr[k] and arr[j] if the current value is less than pivot
				k +=1;
				
				// Swap array k and j
				temp = orderedList[j];
				orderedList[j] = orderedList[k];
				orderedList[k] = temp;}
		}
		
		// perform one last swap of the pivot and the current value at index k+1
		orderedList[max] = orderedList[k+1];
		orderedList[k+1] = pivot;
		
		return (k+1); // return the new index of the pivot
	}
	
	// Recurse through the tree adding the nodes to a set (use a set to avoid having to check if node was already added)
	private HashSet<NodeObject> DFTOrderTree(NodeObject curNode, HashSet<NodeObject> DFTOrderedList){
		if (curNode == null) { return DFTOrderedList;}
		
		if (curNode.leftchild != null) {
			DFTOrderedList = DFTOrderTree(curNode, DFTOrderedList);}
		if (curNode.rightchild != null) {
			DFTOrderedList = DFTOrderTree(curNode, DFTOrderedList);}
			
		return DFTOrderedList;
	}
		
	
	// Checks if the tree is organized as a Min Heap tree
	public boolean isMinHeapTree() {
		return false;
	}
	
	// Checks if the tree is organized as a Min Heap tree
	public boolean isMaxHeapTree() {
		return false;
	}
	
	// Orders an existing tree into Min Heap form
	public boolean CreateMinHeap() {
		return false;
	}
	
	// Orders Max Heap into Max Heap form
	public boolean CreateMaxHeap() {
		return false;
	}
	
	// Recursively find the given node and return node if the node exists
	public boolean nodeExists(NodeObject curNode, NodeObject searchNode) {
		boolean objectExists = false;
		
		if (curNode == null) {return false;} // return if the end of a branch is reached
		
		if (curNode == searchNode) { return true;} // if the searched node is found, return true
		
		if (curNode.leftchild != null) { // recurse the left branch
			objectExists = nodeExists(curNode.leftchild, searchNode);
			if (objectExists == true) { return true;} // The object has been found, return up the recursion stack	
		}
		
		if (curNode.rightchild != null) { // recurse the right branch
			objectExists = nodeExists(curNode.rightchild, searchNode);
		}
		
		return objectExists;
	}
	// Add a left child to a given node
	public int addLeftChild(NodeObject parentIn, NodeObject leftchildIn) {
		if (parentIn == leftchildIn) { 
			System.out.print("The parent Node cannot also be the child");
			return 0;}
		
		if (nodeExists(root, parentIn)) {// check if the parent node exists
			if(parentIn.leftchild == null) { // check that a child does not already exist
				parentIn.leftchild = leftchildIn;
				return 1;}
			else {
				System.out.println("The specified parent already has a left child");
				return 0;}
		}
		else { // the given Node has not been added to the tree yet
			System.out.println("The parent node does not yet exist in the tree");
			return 0;}
		}
	
	// Add right child to a given node
	public int addRightChild(NodeObject parentIn, NodeObject rightchildIn) {
		if (parentIn == rightchildIn) { 
			System.out.print("The parent Node cannot also be the child");
			return 0;}
		
		if (nodeExists(root, parentIn)) {// check if the parent node exists
			if(parentIn.rightchild == null) { // check that a child does not already exist
				parentIn.rightchild = rightchildIn;
				return 1;}
			else {
				System.out.println("The specified parent already has a right child");
				return 0;}
		}
		else { // the given Node has not been added to the tree yet
			System.out.println("The parent node does not yet exist in the tree");
			return 0;}
	}

}
