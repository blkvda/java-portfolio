package com.home;

//Реализация фасада (упрощенноого интерфейса) - создаются необходимые экземпляры класса и манипуляции с данными
public class MsgPrepFacadeImp implements MsgPrepFacade {
    @Override
    public String prepareMsgToReceive(byte[] input) {
        StringConverter stringConverter = new StringConverter();
        CryptoUtil cryptoUtil = new CryptoUtil();
        byte[] msgByteArr = cryptoUtil.decode(input);
        return stringConverter.toString(msgByteArr);
    }

    @Override
    public byte[] prepareMsgToSend(String message) {
        StringConverter stringConverter = new StringConverter();
        CryptoUtil cryptoUtil = new CryptoUtil();
        byte[] msgByteArr = stringConverter.toByteArr(message);
        msgByteArr = cryptoUtil.encode(msgByteArr);
        return msgByteArr;
    }
}
