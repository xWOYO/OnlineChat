import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    static final int port = 2137;
    ServerSocket servs = null;
    Socket client = null;
    PrintWriter ow = null;
    BufferedReader br = null;
    String roomId;
    int portPool = 2200;

    HashMap<String, Integer> rooms = new HashMap<>();

    void startServer(){
        while(true) {
            try {
                servs = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("Problem z utworzeniem ServerSocket");
            }
            try {
                client = servs.accept();
            } catch (IOException e) {
                System.out.println("problem z połączeniem klienckim");
            }
            System.out.println("connected with client");
            try {
                ow = new PrintWriter(client.getOutputStream(), true);
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            }
            catch(IOException e){
                System.out.println("Problem z  utworzeniem strumieni");
            }

            try{
            roomId = br.readLine();
            }
            catch(IOException e){
                System.out.println("Nie da się odczytać id pokoju");
            }
            if(rooms.containsKey(roomId)){
                System.out.println(roomId);
                System.out.println("room already exists");
                ow.print(rooms.get(roomId));
            }
            else if(roomId != null){
                System.out.println(roomId);
                System.out.println("creating a room");
                rooms.put(roomId, portPool);

                try {
                    new groupRoom(portPool, roomId);
                } catch (Exception e) {
                    System.out.println("problem z utworzeniem pokoju");
                }

                ow.println(portPool);
                portPool++;

            }

            try{
            client.close();
            servs.close();
            }
            catch (IOException e){
                System.out.println("Problem z zamknieciem socketu");
            }
        }
    }











    public static void main(String[] args) {
       Server srv = new Server();
       srv.startServer();
    }
}
