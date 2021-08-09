package com.company;

import java.io.Serializable;

public class Test implements Serializable, Cloneable  {
    public String pub = "PublicFieldValue";
    protected String prot = "ProtectedFieldValue";
    private String priv = "PrivateFieldValue";

    public Test(){

    }
    private Test(int x){
        System.out.println("Calling (int) constructor (" + x + ")");
    }
    public Test(int x, String s){
        this.pub = s;
        System.out.println("Calling (int, String) constructor (" + x + ", " + s + ")");
    }

    public void hiPublic(){
        System.out.printf("Hello from %s method", pub);
    }
    protected void hiProtect(){
        System.out.printf("Hello from %s method", prot);
    }
    private void hiPrivate(){
        System.out.printf("Hello from %s method", priv);
    }

    @Override
    public String toString() {
        return "Test =>" +
                "\n\tpub:" + pub + '\n';
    }
}
