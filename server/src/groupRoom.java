import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class groupRoom implements Runnable{
    private String name;
    private int port;
    private ServerSocket servs;
    private Socket client;
    PrintWriter ow;
    BufferedReader br;
    public groupRoom(int a, String b){
        port = a;
        name = b;
        run();
    }
    public void run() {
        try {
            servs = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Problem z server socket w pokoju");
        }
        try {
            client = servs.accept();
        } catch (IOException e) {
            System.out.println("problem z socket accept w pokoju");
        }

        System.out.println("połączono z klientem");

        try {
            ow = new PrintWriter(client.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch(IOException e){
            System.out.println("Problem z  utworzeniem strumieni w pokoju");
        }

        ow.println("witam w pokoju o id:" + name);

    }
}
