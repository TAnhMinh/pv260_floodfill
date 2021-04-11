package practicalrefactorings.equationsolver;

public class SymbolNode extends Node{
    private char operator;

    public SymbolNode(char symbol) {
        this.operator = symbol;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int evaluate() {
        switch (operator) {
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
            default:
                throw new IllegalStateException("Unknown operator: " + operator);
        }
    }


	@Override
	public String representation() {
        return "(" + left.representation() + " " + operator + " " + right.representation() + ")";
	}
}
