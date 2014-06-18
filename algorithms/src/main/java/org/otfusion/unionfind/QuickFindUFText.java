package org.otfusion.unionfind;

import java.util.List;

public class QuickFindUFText {

    private String _description;

    public QuickFindUFText() {
        _description = "";
    }

    public void parseDescription(List<String> lines) {
        UnionFind quickFindUF = null;
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            // first line contains n
            if (quickFindUF == null) {
                quickFindUF = new QuickFindUF(Integer.parseInt(line));
                continue;
            }
            String[] pair = line.split(" ");
            int p = Integer.parseInt(pair[0]);
            int q = Integer.parseInt(pair[1]);
            if (quickFindUF.connected(p, q)) {
                continue;
            }
            quickFindUF.union(p, q);
            sb.append(p).append(" ").append(q).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        _description = sb.toString();
    }

    @Override
    public String toString() {
        return _description;
    }
}
