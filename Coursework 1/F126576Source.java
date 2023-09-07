import java.util.*;

public class F126576Source {
	static ArrayList<Node> finalList = new ArrayList<Node>();		//Represents the nodes generated and the order they are searched through
	static ArrayList<Node> exploredNodes = new ArrayList<Node>();	//Represents the nodes generated and the order they are generated
	static Stack<Node> nodesToBeExplored = new Stack<Node>();		//Represents the order in which nodes are searched through
	public static void main(String[] args) {
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("Enter the capacity of jug A:");
		int maxA = userInput1.nextInt();
		Scanner userInput2 = new Scanner(System.in);
		System.out.println("Enter the capacity of jug B:");
		int maxB = userInput2.nextInt();
		Scanner userInput3 = new Scanner(System.in);
		System.out.println("Enter the capacity of jug C:");
		int maxC = userInput3.nextInt();
		Node startNode = new Node(0, 0, 0, maxA, maxB, maxC);		//After taking user inputs the start node is generated
		exploredNodes.add(startNode);
		nodesToBeExplored.push(startNode);
		while (!(nodesToBeExplored.isEmpty())) {
			Node nodeToBeExplored = nodesToBeExplored.peek();
			finalList.add(nodeToBeExplored);
			nodesToBeExplored.pop();
			generateNewNodes(nodesToBeExplored, exploredNodes, nodeToBeExplored);
		}
		for (int i = 0; i < finalList.size(); i++) {
			Node node = finalList.get(i);
			System.out.println(node.getA() + ", " + node.getB() + ", " + node.getC());
		}
		System.out.println(finalList.size());
	}
	public static boolean sameNode(Node n1, Node n2) {					//Determines if two nodes are the same
		if ((n1.getA() == n2.getA()) && (n1.getB() == n2.getB()) && (n1.getC() == n2.getC())) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean inList(ArrayList<Node> nodes, Node node) {	//Determines if a node has already been generated
		boolean val = false;
		for (int i = 0; i < nodes.size(); i++) {
			Node x = nodes.get(i);
			if (sameNode(x, node)) {
				val = true;
				break;
			}
		}
		return val;
	}
	public static void generateNewNodes(Stack<Node> stack, ArrayList<Node> nodes, Node node) {	//Generates all new nodes from a start node
		Node newNode = node.emptyA();
		if (!(inList(nodes, newNode))) {	//Before adding a new node check to make sure it has not already been generated
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.emptyB();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.emptyC();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.fillA();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.fillB();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.fillC();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.pourAIntoB();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.pourAIntoC();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.pourBIntoA();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.pourBIntoC();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.pourCIntoA();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
		newNode = node.pourCIntoB();
		if (!(inList(nodes, newNode))) {
			nodes.add(newNode);
			stack.push(newNode);
		}
	}
}
