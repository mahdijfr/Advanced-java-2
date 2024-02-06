package models;

import server.ConnectionHandler;

import java.util.concurrent.ConcurrentHashMap;

public class ConnectMessage implements Message {
    public static final long serialVersionUID = 12345678L;
    public final String username;

    public ConnectMessage(String username) {
        this.username = username;
    }

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        if (ConnectionHandler.cache.containsKey(this.username)) {
            connectionHandler.sendMessage(
                    new ErrorMessage("Another session is already active for " + this.username)
            );
            connectionHandler.close();
            return;
        }
        ConnectionHandler.cache.put(this.username, new ConcurrentHashMap<>());
        connectionHandler.username = this.username;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConnectMessage)) {
            return false;
        }
        ConnectMessage message = (ConnectMessage) o;
        return this.username.equals(message.username);
    }

    @Override
    public String toString() {
        return this.username + " connected";
    }
}
