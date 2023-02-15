package net.multi.chatting.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class TCPServerMulti implements Runnable{
    private static Socket clientSocket;
    static int userCount = 0;
    User[] users = new User[5];
    {
        users[0] = new User("user01","pass01","smileman");
        users[1] = new User("user02","pass02","prittywoman");
        users[2] = new User("user03","pass03","javajjang");
        users[3] = new User("test123","test123","testboy");
        users[4] = new User("p1234","p1234","pick");
    }


    HashMap<String, User> hashMap = new HashMap<>();

    public TCPServerMulti(Socket socket) {
        TCPServerMulti.clientSocket = socket;
        ClientHendler.userVector.add(clientSocket); //스레드 추가
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(hashMap);


        //1.포트번호 지정
        int port = 8080;

        try {
            //2. 서버용 소켓 객체 생성


            System.out.println("동작하는 서버 포트 : " + port);
            try (ServerSocket server = new ServerSocket(port)) {
                while (true) {
                    System.out.println("서버 대기중..");

                    Socket client = server.accept();
                    System.out.println("서버와 클라이언트 연결 됨... " + client);
                    TCPServerMulti tcpserver = new TCPServerMulti(client);


                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }






//
//                //6.데이터 주고 받음 : 순서가 중요함
//                //클라이언트가 메세지 보내면 >> 서버가 받아서 출력
//                // >> 서버가 답을 보냄 >> 클라이언트가 받아서 출력
////                String message = br.readLine();
////                System.out.println(client.getInetAddress().getHostAddress() + " : 보낸 메세지 - " + message);
//                //서버가 답을 보냄
////                pw.print("서버 : 잘 받았음 ");
////                pw.flush();
//
//                //반복해서 주고 받기
//                //클라이언트가 "quit"를 보내면 종료됨
//
//                while (true) {
//                    //읽어서 출력
//                    String message = br.readLine();
//
//                    if(message.equals("quit")) break;
//                    System.out.println(message);
//                    //키보드로 답을 입력받아서 전송함
//                    System.out.print("응답 메세지 : ");
//                    pw.println(scanner.nextLine());
//                    pw.flush();
//
//                }
//
//
//
//                //7. 스트림 반납, 클라이언트 소켓 닫음(연결 끊기)
//                //나중에 생성된 것 부터 닫는다.
//                pw.close();
//                br.close();
//
//                input.close();
//                output.close();
//
//                client.close();
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
    }

    public void loginCheck(String id, String pwd) {
        for(int i = 0; i < users.length; i++) {
            if(users[i].getUserid().equals(id) && users[i].getUserpwd().equals(pwd)){
                System.out.println("로그인 성공. 닉네임 : " + users[i].getNickName());

                Thread thread = new ClientHendler(users[i]);
                System.out.println(users[i].getNickName() + "의 스레드 실행");
                thread.start();

                //                new ClientHendler(users[i]);
            }
        }
    }


    @Override
    public void run() {

        try (InputStream input = clientSocket.getInputStream();
             OutputStream output = clientSocket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(input));
             PrintWriter pw = new PrintWriter(output);){

            userCount++;
            System.out.println("클라이언트 : " + userCount + );




            while (true) {



            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }




    }
}
