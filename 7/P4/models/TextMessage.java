package models;

import server.ConnectionHandler;

public class TextMessage implements Message {
    public static final long serialVersionUID = 65493216598L;
    private String text;

    public TextMessage(String text) {
        this.text = text;
    }

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        //
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TextMessage)) {
            return false;
        }
        TextMessage message = (TextMessage) o;
        return this.text.equals(message.text);
    }

    @Override
    public String toString() {
        return this.text;
    }
}
