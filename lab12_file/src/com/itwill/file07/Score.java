package com.itwill.file07;

import java.io.Serializable;

public class Score implements Serializable {

    private int java;
    private int sql;
    private int web;

    public Score() {}

    public Score(int java, int sql, int web) {
        this.java = java;
        this.sql = sql;
        this.web = web;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }


@Override
public String toString() {
    
    return "( java : "+this.java+
            ", sql : "+this.sql+
            ", web : "+this.web+
            " )";
}

}
