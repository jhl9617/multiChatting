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
            //1. 연결할 서버의 ip 주소와 포트번호 필요
            int port = 8080;
            //String serverIP = "192.168.0.137";
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println(InetAddress.getLocalHost().getHostAddress());


            //2. 소켓 객체 생성 : 생성과 동시에 서버에 연결 요청됨
            //연결이 실패하면 null이 리턴됨
            Socket socket = new Socket(serverIP, port);
            ClientHendler.userVector.add(socket);

            if(socket != null) {


                for(int i = 0; i < ClientHendler.userVector.size();i++){
                    System.out.println(i + " 번째 백터 값 : " + ClientHendler.userVector);
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                while (true) {
                    //읽어서 출력
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

                //5. 스트림과 소켓 닫기
                br.close();

                socket.close(); //서버와 연결 끊음
                //서버측의 클라이언트 소켓도 자동 close 됨
            }//if end
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
