public class ProgramStarter {
    public static void main(String[] args){
        Client client = new Client();
        try{
            client.start();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
