package models;

import server.ConnectionHandler;

public class CacheEntry implements Message {
    public static final long serialVersionUID = 16519891324L;
    public final String key;
    public final String value;

    public CacheEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void handle(ConnectionHandler connectionHandler) {
        //
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CacheEntry)) {
            return false;
        }
        CacheEntry message = (CacheEntry) o;
        return this.key.equals(message.key)
                && this.value.equals(message.value);
    }

    @Override
    public String toString() {
        return this.key + ": " + this.value;
    }
}
