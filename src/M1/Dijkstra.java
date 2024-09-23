package src.M1;

import java.util.*;

public class Dijkstra {
    private List<String> expression;
    private Stack<Integer> val = new Stack<Integer>();
    private Stack<String> op = new Stack<String>();

    public Dijkstra(List<String> expression) {
        this.expression = expression;
    }

    public int result() {
        return this.val.pop();
    }

    public void execute() {
        for(String s : expression) {
            if(MainM1.isInteger(s)) {
                val.push(MainM1.toInt(s));
            } else if(isOp(s)) {
                op.push(s);
            } else if(s.equals(")")) {
                val.push(operate());
            }
        }
    }

    private int operate() {
        String top = op.pop();

        int a = val.pop();
        int b = val.pop();

        if(top.equals("+")) {
            return b + a;
        } else if (top.equals("-")) {
            return b - a;
        } else if (top.equals("x")) {
            return b * a;
        } else {
            return b / a;
        }
    }

    private boolean isOp(String c) {
        return (c.equals("-") || c.equals("+") || c.equals("x") || c.equals("/"));
    }
}
