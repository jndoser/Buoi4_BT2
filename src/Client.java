import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        System.out.print("So phan tu cua mang la: ");
        int number = sc.nextInt();

        int[] arr = new int[number];
        for(int i = 0; i < number; i++)
        {
            System.out.print("Nhap vao phan tu thu " + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }

        String str = " ";
        for(int i = 0; i < arr.length; i++)
        {
            str += arr[i] + " ";
        }
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9999;
        DatagramPacket pkt = new DatagramPacket(bytes, bytes.length, address, port);
        client.send(pkt);

        byte[] rcvBytes = new byte[1000];
        DatagramPacket rcvPkt = new DatagramPacket(rcvBytes, rcvBytes.length);
        client.receive(rcvPkt);

        String rcvStr = new String(rcvPkt.getData(), 0, rcvPkt.getLength()).trim();
        System.out.print("Phan tu xuat hien mot lan la: " + rcvStr);

        client.close();
    }
}
