import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;


public class Client {
    Socket mainServer;
    PrintWriter mainServerWriter;
    BufferedReader mainServerReader;

    void start() throws Exception{

        mainServer = new Socket("192.168.0.73", 2137);
        mainServerWriter = new PrintWriter(mainServer.getOutputStream(), true);
        mainServerReader = new BufferedReader(new InputStreamReader(mainServer.getInputStream()));

        mainServerWriter.println("Message1");
        String port = mainServerReader.readLine();
        mainServer.close();


    }

}
