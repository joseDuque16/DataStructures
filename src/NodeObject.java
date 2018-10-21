/* This is the node object class which is universal and can be edited to represent any desired object for the Data Structures */

public class NodeObject {
	// object attributes
	public int key; // Used for creating organized data structures
	public String Name; // Name of object
	public NodeObject leftchild = null;
	public NodeObject rightchild = null;
	
	// Constructor
	public NodeObject(String NameIn, int keyIn) {
		Name = NameIn;
		key = keyIn;
	}
}
