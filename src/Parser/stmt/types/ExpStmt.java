package Parser.stmt.types;

import Parser.expr.types.Exp;

public class ExpStmt implements StmtInterface {
    // Exp ';'
    private final Exp exp;

    public ExpStmt(Exp exp) {
        this.exp = exp;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public void output() {
        exp.output();
    }

    @Override
    public int getSemicolonLine() {
        return exp.getLine();
    }
}