/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.equationsolver;

public abstract class Node implements Evaluable {
//
//	private boolean isNumber;
//	private int value;
//	private char operator;
	protected Node left;
	protected Node right;

	public abstract boolean hasLeft();

	public void setLeft(Node left) {
	}

	public void setRight(Node right) {
	}

//	/** Construct number node */
//	public Node(int value) {
//		this.isNumber = true;
//		this.value = value;
//	}
//
//	/** Construc operator node */
//	public Node(char symbol) {
//		this.isNumber = false;
//		this.operator = symbol;
//	}


//	@Override
//	public int evaluate() {
//		return 0;
//	}

//	@Override
//	public String representation() {
//		if (isNumber) {
//			return String.valueOf(value);
//		} else {
//			return "(" + left.representation() + " " + operator + " " + right.representation() + ")";
//		}
//	}

}
