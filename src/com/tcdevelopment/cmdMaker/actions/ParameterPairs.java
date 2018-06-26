package com.tcdevelopment.cmdMaker.actions;

public class ParameterPairs {

    private String docParam;

    private String mmlParam;

    public String getDocParam() {
        return docParam;
    }

    public void setDocParam(String docParam) {
        this.docParam = docParam;
    }

    public String getMmlParam() {
        return mmlParam;
    }

    public void setMmlParam(String mmlParam) {
        this.mmlParam = mmlParam;
    }

    public ParameterPairs(String parameter) {
        this.docParam = "<"+parameter+">";
        this.mmlParam = "{"+parameter+"}";
    }
}
