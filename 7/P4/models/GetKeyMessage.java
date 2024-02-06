package models;

import server.ConnectionHandler;

public class GetKeyMessage implements Message {
    public static final long serialVersionUID = 165119658924L;
    public final String key;

    public GetKeyMessage(String key) {
        this.key = key;
    }

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        connectionHandler.sendMessage(
                new CacheEntry(
                        this.key, ConnectionHandler.cache.get(connectionHandler.username).get(this.key)
                )
        )
        ;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetKeyMessage)) {
            return false;
        }
        GetKeyMessage message = (GetKeyMessage) o;
        return this.key.equals(message.key);
    }

    @Override
    public String toString() {
        return "Get " + this.key;
    }
}
