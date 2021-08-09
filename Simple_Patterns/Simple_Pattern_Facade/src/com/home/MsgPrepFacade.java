package com.home;

//Упрощенный интерфейс - для скрытия подробностей работы системы
public interface MsgPrepFacade {
    String prepareMsgToReceive(byte[] input);
    byte[] prepareMsgToSend(String message);
}
