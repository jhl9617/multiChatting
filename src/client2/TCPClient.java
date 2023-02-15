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
            //1. 연결할 서버의 ip 주소와 포트번호 필요
            int port = 8080;
            //String serverIP = "192.168.0.137";
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println(InetAddress.getLocalHost().getHostAddress());


            //2. 소켓 객체 생성 : 생성과 동시에 서버에 연결 요청됨
            //연결이 실패하면 null이 리턴됨
            Socket socket = new Socket(serverIP, port);


            if(socket != null) {    //서버와 연결이 되었다면...
                //3. 서버와 클라이언트 간의 입출력 스트림 생성
                //추가로 보조스트림 사용할 수도 있음
                //또는 문자 스트림으로 변경할 수도 있음
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                //4.데이터 주고 받기 : 순서가 중요함
                //서버로 메세지 보냄 >> 서버로 부터 답을 받음
                // >> 받은 답 출력 확인
//                System.out.print("서버로 보낼 메세지 : ");
//                String message = scanner.nextLine();
//
//                pw.println(message);
//                pw.flush();
//
//                String response = br.readLine();
//                System.out.println("서버가 보낸 답 : " + response);

                //반복해서 주고 받기
                while (true) {
                    //읽어서 출력
                    System.out.print("\t\t\t\tMe : ");
                    String message = scanner.nextLine();
                    pw.println(message);
                    pw.flush();
                    if(message.equals("quit")) break;
                    String response = br.readLine();
                    System.out.println("You : " + response);

                }

                //5. 스트림과 소켓 닫기
                br.close();
                pw.close();
                socket.close(); //서버와 연결 끊음
                //서버측의 클라이언트 소켓도 자동 close 됨
            }//if end
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
