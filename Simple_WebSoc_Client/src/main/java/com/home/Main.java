package com.home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        try{
            URI uri = new URI("ws://localhost:8080/chat");
            WebsocketClientEndpoint websocketClientEndpoint = new WebsocketClientEndpoint(uri);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String outputMessage = br.readLine();
            while(!br.equals("exit")){
                websocketClientEndpoint.sendMessage(outputMessage);
                outputMessage = br.readLine();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
