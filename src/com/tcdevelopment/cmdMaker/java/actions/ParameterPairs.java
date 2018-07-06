package com.tcdevelopment.cmdMaker.java.actions;

public class ParameterPairs {

    private String docParam;

    private String mmlParam;

    public String getDocParam() {
        return docParam;
    }

    public String getMmlParam() {
        return mmlParam;
    }

    public ParameterPairs(String parameter) {
        this.docParam = "<"+parameter+">";
        this.mmlParam = "{"+parameter+"}";
    }
}
