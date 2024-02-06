package connection;

import models.*;

import java.io.*;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;




    public Connection(String username, String ip, int port) {
        try {
            socket = new Socket(ip, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output.writeObject(new ConnectMessage(username));
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

    public void sendMessage(Message message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            output.writeObject(new DisconnectMessage());
            output.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Message getResponse() throws IOException, ClassNotFoundException {
        return (Message) input.readObject();
    }
}

