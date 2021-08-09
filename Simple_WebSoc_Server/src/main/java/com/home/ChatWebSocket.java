package com.home;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ServerEndpoint("/chat")
public class ChatWebSocket {
    private static List<Session> clientSessionList = Collections.synchronizedList(new ArrayList<>());

    @OnOpen
    public void onOpen(Session session){
        clientSessionList.add(session);
        System.out.println("onOpen(): new client connected, id: " + session.getId());
    }

    @OnClose
    public void onClose(Session session){
        clientSessionList.remove(session);
        System.out.println("onClose(): client disconnected, id: " + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message){
        System.out.println(String.format("Input message (from id: %s): %s", session.getId(), message));
        for(Session s: clientSessionList){
            if(!s.equals(session)){
                try{
                    s.getBasicRemote().sendText(String.format("id: %s says: %s", session.getId(), message));
                }
                catch (IOException ex){
                    System.out.println("Can't send message to " + session.getId());
                }

            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }

}
