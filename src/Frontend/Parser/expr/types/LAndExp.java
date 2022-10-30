package Frontend.Parser.expr.types;

import Config.Reader;
import Config.SyntaxWriter;
import Frontend.Lexer.Token;
import Config.Output;

import java.util.ArrayList;

public class LAndExp implements Output {
    // LAndExp → EqExp {'&&' EqExp}
    private final EqExp firstExp;
    private final ArrayList<EqExp> exps;
    private final ArrayList<Token> seps;

    public LAndExp(EqExp firstExp, ArrayList<EqExp> exps, ArrayList<Token> seps) {
        this.firstExp = firstExp;
        this.exps = exps;
        this.seps = seps;
    }

    public EqExp getFirstExp() {
        return firstExp;
    }

    public ArrayList<EqExp> getExps() {
        return exps;
    }

    public ArrayList<Token> getSeps() {
        return seps;
    }

    public int getLine() {
        if (exps.size() != 0) {
            return this.exps.get(exps.size() - 1).getLine();
        } else {
            return this.firstExp.getLine();
        }
    }

    @Override
    public void output() {
        firstExp.output();
        SyntaxWriter.print("<LAndExp>");
        for (int i = 0; i < exps.size(); i++) {
            SyntaxWriter.print(seps.get(i).toString());
            exps.get(i).output();
            SyntaxWriter.print("<LAndExp>");
        }
    }
}