package practicalrefactorings.equationsolver;

public class NumberNode extends Node {
    private int value;


    public NumberNode(int value) {
        this.value = value;
    }

    public boolean hasLeft() {
        throw new IllegalStateException("Numbers dont have children");
    }

    public void setLeft(Node left) {
        throw new IllegalStateException("Numbers dont have children");
    }

    public void setRight(Node right) {
        throw new IllegalStateException("Numbers dont have children");
    }


    @Override
    public int evaluate() {
        return value;
    }

	@Override
	public String representation() {
        return String.valueOf(value);
    }

}
