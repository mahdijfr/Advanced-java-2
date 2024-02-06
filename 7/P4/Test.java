import connection.Connection;
import models.*;
import server.Server;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int port = 6379;
        (new Server()).start(port);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.next();
        Connection conn = new Connection(username, "127.0.0.1", port);
        new Thread(() -> {
            ObjectInputStream inputStream = conn.getInputStream();
            while (true) {
                try {
                    Message message = (Message) inputStream.readObject();
                    System.out.println(message.toString());
                } catch (IOException | ClassNotFoundException e) {
                    // Ignore
                }
            }
        }).start();
        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "set":
                    String key = sc.next();
                    String value = sc.next();
                    conn.sendMessage(new SetKeyMessage(key, value));
                    break;
                case "get":
                    key = sc.next();
                    conn.sendMessage(new GetKeyMessage(key));
                    break;
                case "exit":
                    conn.sendMessage(new DisconnectMessage());
            }
        }
    }
}
