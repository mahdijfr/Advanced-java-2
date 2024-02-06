package models;

import server.ConnectionHandler;

public class SetKeyMessage implements Message {
    public static final long serialVersionUID = 16519877424L;
    public final String key;
    public final String value;

    public SetKeyMessage(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        ConnectionHandler.cache.get(connectionHandler.username).put(this.key, this.value);
        connectionHandler.sendMessage(new TextMessage("key has been set successfully!"));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SetKeyMessage)) {
            return false;
        }
        SetKeyMessage message = (SetKeyMessage) o;
        return this.key.equals(message.key)
                && this.value.equals(message.value);
    }

    @Override
    public String toString() {
        return "Set " + this.key + " to " + this.value;
    }
}
