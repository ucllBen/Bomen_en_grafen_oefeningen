package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		BinaryTree<String> nodeA = new BinaryTree<>("A");

		BinaryTree<String> nodeD = new BinaryTree<>("D",nodeC,nodeE);
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH,null);



		BinaryTree<String> nodeB = new BinaryTree<>("B",nodeA,nodeD);
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);


		BinaryTree<String> boom = new BinaryTree<>("F",nodeB,nodeG);

		boom.printPreorder();
		System.out.println();
		boom.printInorder();
		System.out.println();

		boom.printPostorder();


	}

}
