package models;

import server.ConnectionHandler;

public class ErrorMessage implements Message {
    public static final long serialVersionUID = 1665498324L;
    private String error;

    public ErrorMessage(String text) {
        this.error = text;
    }

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        //
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ErrorMessage)) {
            return false;
        }
        ErrorMessage message = (ErrorMessage) o;
        return this.error.equals(message.error);
    }

    @Override
    public String toString() {
        return this.error;
    }
}
