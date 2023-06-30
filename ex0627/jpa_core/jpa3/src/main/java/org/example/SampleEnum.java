package org.example;

public enum SampleEnum {
    Sample1("sample1"), Sample2("sample2");
    private String str;
    SampleEnum(String str){
        this.str = str;
    }
    public String getStr() {
        return str;
    }
}
