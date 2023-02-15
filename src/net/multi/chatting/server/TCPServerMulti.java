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
        ClientHendler.userVector.add(clientSocket); //������ �߰�
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(hashMap);


        //1.��Ʈ��ȣ ����
        int port = 8080;

        try {
            //2. ������ ���� ��ü ����


            System.out.println("�����ϴ� ���� ��Ʈ : " + port);
            try (ServerSocket server = new ServerSocket(port)) {
                while (true) {
                    System.out.println("���� �����..");

                    Socket client = server.accept();
                    System.out.println("������ Ŭ���̾�Ʈ ���� ��... " + client);
                    TCPServerMulti tcpserver = new TCPServerMulti(client);


                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }






//
//                //6.������ �ְ� ���� : ������ �߿���
//                //Ŭ���̾�Ʈ�� �޼��� ������ >> ������ �޾Ƽ� ���
//                // >> ������ ���� ���� >> Ŭ���̾�Ʈ�� �޾Ƽ� ���
////                String message = br.readLine();
////                System.out.println(client.getInetAddress().getHostAddress() + " : ���� �޼��� - " + message);
//                //������ ���� ����
////                pw.print("���� : �� �޾��� ");
////                pw.flush();
//
//                //�ݺ��ؼ� �ְ� �ޱ�
//                //Ŭ���̾�Ʈ�� "quit"�� ������ �����
//
//                while (true) {
//                    //�о ���
//                    String message = br.readLine();
//
//                    if(message.equals("quit")) break;
//                    System.out.println(message);
//                    //Ű����� ���� �Է¹޾Ƽ� ������
//                    System.out.print("���� �޼��� : ");
//                    pw.println(scanner.nextLine());
//                    pw.flush();
//
//                }
//
//
//
//                //7. ��Ʈ�� �ݳ�, Ŭ���̾�Ʈ ���� ����(���� ����)
//                //���߿� ������ �� ���� �ݴ´�.
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
                System.out.println("�α��� ����. �г��� : " + users[i].getNickName());

                Thread thread = new ClientHendler(users[i]);
                System.out.println(users[i].getNickName() + "�� ������ ����");
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
            System.out.println("Ŭ���̾�Ʈ : " + userCount + );




            while (true) {



            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }




    }
}
