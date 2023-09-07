public class Node {
	private final int a;		//Represents the current amount in jug A
	private final int b;		//Represents the current amount in jug B
	private final int c;		//Represents the current amount in jug C
	private final int maxA;		//Represents the capacity of jug A
	private final int maxB;		//Represents the capacity of jug B
	private final int maxC;		//Represents the capacity of jug C
	public Node(int a, int b, int c, int maxA, int maxB, int maxC) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.maxA = maxA;
		this.maxB = maxB;
		this.maxC = maxC;
	}
	public int getA() {			//Gets the current amount in jug A
		return a;
	}
	public int getB() {			//Gets the current amount in jug B
		return b;
	}
	public int getC() {			//Gets the current amount in jug C
		return c;
	}
	public int getMaxA() {		//Gets the capacity of jug A
		return maxA;
	}
	public int getMaxB() {		//Gets the capacity of jug B
		return maxB;
	}
	public int getMaxC() {		//Gets the capacity of jug C
		return maxC;
	}
	public Node emptyA() {		//Generates the node created by emptying jug A
		int a = 0;
		int b = getB();
		int c = getC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node emptyB() {		//Generates the node created by emptying jug B
		int a = getA();
		int b = 0;
		int c = getC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node emptyC() {		//Generates the node created by emptying jug C
		int a = getA();
		int b = getB();
		int c = 0;
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node fillA() {		//Generates the node created by filling jug A
		int a = getMaxA();
		int b = getB();
		int c = getC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node fillB() { 		// Generates the node created by filling jug B
		int a = getA();
		int b = getMaxB();
		int c = getC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node fillC() {		//Generates the node created by filling jug C
		int a = getA();
		int b = getB();
		int c = getMaxC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node pourAIntoB() {	//Generates the node created by pouring the contents of jug A into jug B
		int a;
		int b;
		int x = getB();
		int y = getA();
		int z = getMaxB();
		if (x + y <= z) {
			b = x + y;
			a = 0;
		} else {
			a = x + y - z;
			b = z;
		}
		int c = getC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node pourAIntoC() {	//Generates the node created by pouring the contents of jug A into jug C
		int a;
		int c;
		int x = getC();
		int y = getA();
		int z = getMaxC();
		if (x + y <= z) {
			c = x + y;
			a = 0;
		} else {
			a = x + y - z;
			c = z;
		}
		int b = getB();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node pourBIntoA() {	//Generates the node created by pouring the contents of jug B into jug A
		int a;
		int b;
		int x = getA();
		int y = getB();
		int z = getMaxA();
		if (x + y <= z) {
			a = x + y;
			b = 0;
		} else {
			b = x + y - z;
			a = z;
		}
		int c = getC();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node pourBIntoC() {	//Generates the node created by pouring the contents of jug B into jug C
		int b;
		int c;
		int x = getC();
		int y = getB();
		int z = getMaxC();
		if (x + y <= z) {
			c = x + y;
			b = 0;
		} else {
			b = x + y - z;
			c = z;
		}
		int a = getA();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node pourCIntoA() {	//Generates the node created by pouring the contents of jug C into jug A
		int a;
		int c;
		int x = getA();
		int y = getC();
		int z = getMaxA();
		if (x + y <= z) {
			a = x + y;
			c = 0;
		} else {
			c = x + y - z;
			a = z;
		}
		int b = getB();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
	public Node pourCIntoB() {	//Generates the node created by pouring the contents of jug C into jug B
		int b;
		int c;
		int x = getB();
		int y = getC();
		int z = getMaxB();
		if (x + y <= z) {
			b = x + y;
			c = 0;
		} else {
			c = x + y - z;
			b = z;
		}
		int a = getA();
		int maxA = getMaxA();
		int maxB = getMaxB();
		int maxC = getMaxC();
		Node newNode = new Node(a, b, c, maxA, maxB, maxC);
		return newNode;
	}
}
