package models;

import server.ConnectionHandler;

import java.io.Serializable;

public interface Message extends Serializable {
    void handle(ConnectionHandler connectionHandler);
}
