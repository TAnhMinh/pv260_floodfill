package practicalrefactorings.equationsolver;

public class SymbolPLusNode extends SymbolNode{
    public SymbolPLusNode(char symbol) {
        super(symbol);
    }
    public int evaluate(){
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String representation() {
        return "(" + left.representation() + " " + "+" + " " + right.representation() + ")";
    }
}
