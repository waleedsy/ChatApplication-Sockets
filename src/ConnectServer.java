import java.io.*;
import java.net.*;

class ConnectServer implements Runnable {

    protected Socket incoming;
    private static int PORT;

    public ConnectServer (Socket incoming)
    {
        this.incoming = incoming;
    }


    public void run()
    {
        try {

            ServerSocket socket = new ServerSocket(PORT);

            while (true)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);

                String user = in.readLine();

                out.println("Welcome to Java Chat Application " + user + "...You are running on port: " + PORT + "!!!");
                out.println("In order to start the session, type 'Connect'");
                out.println("Enter 'BYE' to exit!");
                out.flush();

                while (true)
                {
                    String str = in.readLine();

                    if (str == null)
                        break;

                    else if (str.trim().equals("Connect"))
                    {
                        out.println("You are now connected " + user + "!!!");
                        new Thread(new Packet(incoming, user));
                        break;
                    }

                    else if (str.trim().equals("BYE"))
                    {
                        incoming.close();
                        break;
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

class Packet implements Runnable
{

    byte buf [];
    protected Socket socket;
    private String user;
    private static int PORT;

    public Packet (Socket socket, String user)
    {
        this.socket = socket;
        this.user = user;
    }

    public void run ()
    {
        try
        {
            DatagramSocket ds = new DatagramSocket(PORT);
            InetAddress ipAddr = socket.getInetAddress();
            int userPort = socket.getPort();

            while (true)
            {
                buf = new byte[1024];
            }

        }

        catch (IOException g) {}

    }
}
