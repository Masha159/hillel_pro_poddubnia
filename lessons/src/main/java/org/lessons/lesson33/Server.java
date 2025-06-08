package org.lessons.lesson33;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static int clientsNumber = 0;
    private static final Map<Integer, ClientSession> clients = new HashMap<Integer, ClientSession>();

    private static final int PORT = 8081;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT); // Прослуховування порту
        ) {
            do {
                Socket clientSocket = serverSocket.accept();
                ClientSession clientSession = new ClientSession("Client" + clientsNumber++, LocalDateTime.now().toString(), clientSocket);
                clients.put(clientsNumber, clientSession);
                clientSession.start();
                System.out.println("Server is waiting for client...");
                clients.entrySet().stream().filter(a ->
                        a.getValue().getSocket().isClosed()).forEach(a -> clients.remove(a.getKey()));
            } while (!clients.isEmpty());
        } catch (IOException e) {
            // exception handling
            e.printStackTrace();
        }


    }
}
