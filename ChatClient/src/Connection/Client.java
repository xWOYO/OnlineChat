package Connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;



public class Client {
    Socket mainServer;
    Socket chatServer;
    PrintWriter mainServerWriter;
    BufferedReader mainServerReader;

    public void initiateConnection() throws Exception{

        mainServer = new Socket("192.168.0.73", 2137);
        mainServerWriter = new PrintWriter(mainServer.getOutputStream(), true);
        mainServerReader = new BufferedReader(new InputStreamReader(mainServer.getInputStream()));

    }

    public void chooseRoomName(String nameOfRoom) throws Exception{

        mainServerWriter.println(nameOfRoom);
        String port = mainServerReader.readLine();
        mainServer.close();
        chatServer = new Socket("192.168.0.73", Integer.parseInt(port));
    }

}
