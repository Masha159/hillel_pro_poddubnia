package org.lessons.lesson33;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
@Getter
@AllArgsConstructor
class ClientSession extends Thread {
    private final String clientName;
    private final String connectedAt;
    private final Socket socket;


    @SneakyThrows
    @Override

    public void run() {
        try {
            System.out.println(clientName + " connected at " + connectedAt);
            // Отримання введення/виведення для зчитування/запису даних через з'єднання
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String clientData = null;
            do {
                // Отримання даних від клієнта
                clientData = input.readLine();
                System.out.println(clientName + " sent: " + clientData);
            } while (!clientData.equals("exit"));
            // Відправка відповіді клієнту
            output.println("Hello, Client!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            socket.close();
        }

    }
}
