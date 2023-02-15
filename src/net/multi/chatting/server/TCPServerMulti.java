package net.multi.chatting.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class TCPServerMulti {
    User[] users = new User[5];
    {
        users[0] = new User("user01","pass01","smileman");
        users[1] = new User("user02","pass02","prittywoman");
        users[2] = new User("user03","pass03","javajjang");
        users[3] = new User("test123","test123","testboy");
        users[4] = new User("p1234","p1234","pick");
    }


    HashMap<String, User> hashMap = new HashMap<>();

    public TCPServerMulti() {
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(hashMap);


        //1.��Ʈ��ȣ ����
        int port = 8080;

        try {
            //2. ������ ���� ��ü ����
            ServerSocket server = new ServerSocket(port);
            System.out.println("�����ϴ� ���� ��Ʈ : " + port);

            //3. Ŭ���̾�Ʈ�� ���� ��û�� ���� �� ���� ��ٸ�
            while (true) {
                System.out.println("���� �����..");

                //4.Ŭ���̾�Ʈ�� ���� ���� ��û�� ���� ������
                //������ �� ���� ��û�� Ŭ���̾�Ʈ ������ ������
                Socket client = server.accept();
                System.out.println("������ Ŭ���̾�Ʈ ���� ��... " + client);

                //5.Ŭ���̾�Ʈ�� �������� ����� ��Ʈ�� ������
                //��Ʈ��ũ ������� ����Ʈ ��Ʈ���� ������
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                //����� ���Ǹ� ���� �߰��� ������Ʈ���� ������ ���� ����
                //����Ʈ��Ʈ���� ���ڽ�Ʈ������ �����ؼ� ����� ���� ����
                //�Ǵ� ���� �̿� ��Ʈ���� �߰��� ���� ����
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                PrintWriter pw = new PrintWriter(output);




                //6.������ �ְ� ���� : ������ �߿���
                //Ŭ���̾�Ʈ�� �޼��� ������ >> ������ �޾Ƽ� ���
                // >> ������ ���� ���� >> Ŭ���̾�Ʈ�� �޾Ƽ� ���
//                String message = br.readLine();
//                System.out.println(client.getInetAddress().getHostAddress() + " : ���� �޼��� - " + message);
                //������ ���� ����
//                pw.print("���� : �� �޾��� ");
//                pw.flush();

                //�ݺ��ؼ� �ְ� �ޱ�
                //Ŭ���̾�Ʈ�� "quit"�� ������ �����

                while (true) {
                    //�о ���
                    String message = br.readLine();

                    if(message.equals("quit")) break;
                    System.out.println(message);
                    //Ű����� ���� �Է¹޾Ƽ� ������
                    System.out.print("���� �޼��� : ");
                    pw.println(scanner.nextLine());
                    pw.flush();

                }



                //7. ��Ʈ�� �ݳ�, Ŭ���̾�Ʈ ���� ����(���� ����)
                //���߿� ������ �� ���� �ݴ´�.
                pw.close();
                br.close();

                input.close();
                output.close();

                client.close();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
    public class User {

        private String userid;
        private String userpwd;
        private String nickName;

        public User() {
        }

        public User(String userid, String userpwd, String nickName) {
            this.userid = userid;
            this.userpwd = userpwd;
            this.nickName = nickName;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUserpwd() {
            return userpwd;
        }

        public void setUserpwd(String userpwd) {
            this.userpwd = userpwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userid='" + userid + '\'' +
                    ", userpwd='" + userpwd + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }


}
