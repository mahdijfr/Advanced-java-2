package server;

import models.Message;

import java.io.*;
import java.util.concurrent.*;

public class ConnectionHandler {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> cache = new ConcurrentHashMap<>();
    public String username;


    public ConnectionHandler(ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        this.input = inputStream;
        this.output = outputStream;
    }

    public void close() {
        try{
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObjectInputStream getInputStream() {
        return input;
    }

    public ObjectOutputStream getOutputStream() {
        return output;
    }
}
