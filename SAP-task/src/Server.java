import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.sql.*;

public class Server implements Runnable {

    public static final int PORT = 1234;

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sap_database";
    public static final String DB_USER = "root";
    public static final String DB_PASS = DB_USER;

    public static final ExecutorService exec = Executors.newCachedThreadPool();

    @Override
    public void run(){
        try(ServerSocket server = new ServerSocket(PORT)){
            while(true){
                Socket client = server.accept();
                exec.execute(new ClientHandler(client));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable{
        public Socket client;

        public ClientHandler(Socket socket){
            this.client = socket;
        }

        @Override
        public void run(){
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                login(in,out);

            }catch(IOException e){
                e.printStackTrace();
            }
        }

        public void login (BufferedReader in,BufferedWriter out) throws IOException{
            String response = in.readLine();
            if(response != null){
                String[] credentials = response.split(",");
                String username = credentials[0].trim();
                String password = credentials[1].trim();

                if(authenticateUser(username,password)){
                    sentResponse(out, "Logged in successfully!");
                }
                else{
                    sentResponse(out, "Incorrect username/password!");
                }
            }
        }

        public boolean authenticateUser(String username,String password){
            try(Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS)){
                String query = "SELECT password FROM users WHERE username = ?";
                PreparedStatement prep = con.prepareStatement(query);
                prep.setString(1,username);
                ResultSet result = prep.executeQuery();
                if(result.next()){
                    return password.equals(result.getString("password"));
                }

            }catch(Exception e){
                e.printStackTrace();
            }
            return false;
        }

        public void sentResponse(BufferedWriter out, String response) throws IOException{
            out.write(response + "\n");
            out.flush();
        }
    }
}
