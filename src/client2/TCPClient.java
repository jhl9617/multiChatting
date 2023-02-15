package client2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public TCPClient() {}

    public void start() {
        Scanner scanner = new Scanner(System.in);


        try {
            //1. ������ ������ ip �ּҿ� ��Ʈ��ȣ �ʿ�
            int port = 8080;
            //String serverIP = "192.168.0.137";
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println(InetAddress.getLocalHost().getHostAddress());


            //2. ���� ��ü ���� : ������ ���ÿ� ������ ���� ��û��
            //������ �����ϸ� null�� ���ϵ�
            Socket socket = new Socket(serverIP, port);


            if(socket != null) {    //������ ������ �Ǿ��ٸ�...
                //3. ������ Ŭ���̾�Ʈ ���� ����� ��Ʈ�� ����
                //�߰��� ������Ʈ�� ����� ���� ����
                //�Ǵ� ���� ��Ʈ������ ������ ���� ����
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                //4.������ �ְ� �ޱ� : ������ �߿���
                //������ �޼��� ���� >> ������ ���� ���� ����
                // >> ���� �� ��� Ȯ��
//                System.out.print("������ ���� �޼��� : ");
//                String message = scanner.nextLine();
//
//                pw.println(message);
//                pw.flush();
//
//                String response = br.readLine();
//                System.out.println("������ ���� �� : " + response);

                //�ݺ��ؼ� �ְ� �ޱ�
                while (true) {
                    //�о ���
                    System.out.print("\t\t\t\tMe : ");
                    String message = scanner.nextLine();
                    pw.println(message);
                    pw.flush();
                    if(message.equals("quit")) break;
                    String response = br.readLine();
                    System.out.println("You : " + response);

                }

                //5. ��Ʈ���� ���� �ݱ�
                br.close();
                pw.close();
                socket.close(); //������ ���� ����
                //�������� Ŭ���̾�Ʈ ���ϵ� �ڵ� close ��
            }//if end
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
