import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8098);
        System.out.println("К чату подключились");


        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Отключились от сервера");
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        while (true) {
            String message = scanner.nextLine();
            if (message.equals("/exit")) break;
            writer.println(message);
        }

        clientSocket.close();
        scanner.close();
    }
}