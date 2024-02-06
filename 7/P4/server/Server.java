package server;

import models.*;

import java.io.*;
import java.net.*;

public class Server implements Runnable {
    public static ServerSocket lastServerSocket;
    Object output;
    Object input;


    public void start(int port) {
        try {
            if (lastServerSocket != null) {
                lastServerSocket.close();
                ConnectionHandler.cache.clear();
            }
            lastServerSocket = new ServerSocket(port);
            
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(!lastServerSocket.isClosed()) {
            try {
                Socket socket = lastServerSocket.accept();

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                ConnectionHandler ch = new ConnectionHandler(input, output);

                new Thread(
                    () -> {
                        try {
                            while(!socket.isClosed()) {
                                Message message = (Message) input.readObject();
                                message.handle(ch);
                            }
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                ).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
