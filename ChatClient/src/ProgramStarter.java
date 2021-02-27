import Connection.Client;
import GUI.WelcomeWindow.*;


public class ProgramStarter {
    public static void main(String[] args){
        Client client = new Client();


        try{
            client.initiateConnection();
            WelcomeWindow.displayApplication(args, client);
            System.out.println("aaa");



        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
