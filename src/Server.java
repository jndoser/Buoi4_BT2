import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(9999);
        System.out.println("Server is ready...");

        byte[] bytes = new byte[1000];
        DatagramPacket rcvPkt = new DatagramPacket(bytes, bytes.length);
        server.receive(rcvPkt);

        String rcvStr = new String(rcvPkt.getData(), 0, rcvPkt.getLength()).trim();
        System.out.println("Got this array: " + rcvStr);

        String result = ResultProcess(rcvStr);
        byte[] sendbytes = result.getBytes();

        DatagramPacket sendPkt = new DatagramPacket(sendbytes, sendbytes.length, rcvPkt.getAddress(),
                rcvPkt.getPort());
        server.send(sendPkt);

        server.close();
    }

    public static String ResultProcess(String str)
    {
        String[] strArr = str.split(" ");
        String result = " ";

        for(int i = 0; i < strArr.length; i++)
        {
            if(Count(strArr[i], str) == 1)
            {
                result += strArr[i] + " ";
            }
        }
        return result;
    }

    public static int Count(String item, String str)
    {
        int result = 0;
        String[] strArr = str.split(" ");

        for (int i = 0; i < strArr.length; i++)
        {
            if(item.equalsIgnoreCase(strArr[i]))
            {
                result = result + 1;
            }
        }
        return  result;
    }
}
