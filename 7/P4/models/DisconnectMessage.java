package models;

import server.ConnectionHandler;

public class DisconnectMessage implements Message {
    public static final long serialVersionUID = 65498749324L;

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        connectionHandler.close();
    }
}
