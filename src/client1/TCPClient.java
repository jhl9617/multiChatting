package client1;

import net.multi.chatting.server.ClientHendler;
import net.multi.chatting.server.TCPServerMulti;
import net.multi.chatting.server.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    User current;
    public TCPClient(User user) {
        this.current = user;
    }

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
            ClientHendler.userVector.add(socket);

            if(socket != null) {


                for(int i = 0; i < ClientHendler.userVector.size();i++){
                    System.out.println(i + " ��° ���� �� : " + ClientHendler.userVector);
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                while (true) {
                    //�о ���
                    System.out.print("\t\t\t\tMe : ");
                    String me = current.getNickName();
                    String message = scanner.nextLine();
                    for(int i = 0; i < ClientHendler.userVector.size();i++){
                        PrintWriter pw = new PrintWriter(ClientHendler.userVector.get(i).getOutputStream());
                        pw.println(me + " : " + message);
                        pw.flush();
                    }

                    if(message.equals("quit")) break;
                    String response = br.readLine();
                    System.out.println("You : " + response);

                }

                //5. ��Ʈ���� ���� �ݱ�
                br.close();

                socket.close(); //������ ���� ����
                //�������� Ŭ���̾�Ʈ ���ϵ� �ڵ� close ��
            }//if end
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
