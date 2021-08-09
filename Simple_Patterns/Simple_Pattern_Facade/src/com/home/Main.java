package com.home;

public class Main {
    //Фасад — это простой интерфейс для работы со сложной подсистемой, содержащей множество классов.
    public static void main(String[] args) {
        MsgPrepFacade msgPrep = new MsgPrepFacadeImp();
        String testMsg = "Hello";
        byte[] preparedTestMsg = msgPrep.prepareMsgToSend(testMsg);
        String res = msgPrep.prepareMsgToReceive(preparedTestMsg);
        System.out.println(String.format("Output msg: %s", testMsg));
        System.out.println(String.format("Input msg: %s", res));
    }
}
