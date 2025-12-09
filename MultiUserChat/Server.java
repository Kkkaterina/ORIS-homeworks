import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8098);
        System.out.println("Сервер запущен");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Новый клиент: " + clientSocket.getPort());

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            clients.add(writer);

            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    static void handleClient(Socket clientSocket) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Клиент " + clientSocket.getPort() + ": " + message);
                sendToAll("Клиент " + clientSocket.getPort() + ": " + message);
            }
        } catch (IOException e) {
            System.out.println("Клиент отключился" + clientSocket.getPort());
        }
    }

    static void sendToAll(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
        }
    }
}