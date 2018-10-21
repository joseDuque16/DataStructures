
public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO test the addLeftChild, addRightChild, printTree
		
		// Test for addLeftChild, addRightChild
		testAddChildren();
		
	}
	
	// test for the addLeftChild, addRightChild, methods
	static int testAddChildren() {
		int testPass = 1; // start with the assumption that it works
		int output = 0; // output of the current test
		//       a
		//     b     c
		//   d  e   f g
		//  h
		NodeObject a = new NodeObject("a", 1);
		NodeObject b = new NodeObject("b", 1);
		NodeObject c = new NodeObject("c", 1);
		NodeObject d = new NodeObject("d", 1);
		NodeObject e = new NodeObject("e", 1);
		NodeObject f = new NodeObject("f", 1);
		NodeObject g = new NodeObject("g", 1);
		NodeObject h = new NodeObject("h", 1);
		
		Trees tree1 = new Trees(a);
		
		// First test is to add the nodes to the tree as seen above
		output = tree1.addLeftChild(a, b);
		testPass = testPass & output;
		output = tree1.addRightChild(a, c);
		testPass = testPass & output;
		output = tree1.addLeftChild(b, d);
		testPass = testPass & output;
		output = tree1.addRightChild(b, e);
		testPass = testPass & output;
		output = tree1.addLeftChild(c, f);
		testPass = testPass & output;
		output = tree1.addRightChild(c, g);
		testPass = testPass & output;
		output = tree1.addLeftChild(d, h);
		testPass = testPass & output;
		
		if (testPass == 0) { System.out.print("Failed test 1 - creating the tree");}
		
		// Now try to add a node to a place that already has children
		output = tree1.addRightChild(c, f);
		testPass = testPass & (output ^ 1);// xor with 1 because expected output is 0;
		output = tree1.addLeftChild(d, e);
		testPass = testPass & (output ^ 1);// xor with 1 because expected output is 0;
		
		if (testPass == 0) { System.out.print("Failed test 2 - creating the tree");}
		
		if (testPass == 1) {System.out.print("Result of testAddChildren: PASS");}
		else if (testPass == 0) {System.out.print("Result of testAddChildren: FAIL");}

		return testPass;
	}

}
