package net.multi.chatting.server;

import client1.TCPClient;

import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

public class ClientHendler extends Thread{
    User user;

    public ClientHendler() {
    }

    public static Vector<Socket> userVector = new Vector<>();
    private User currentUser;




    public ClientHendler(User user) {
        currentUser = user;



    }

    public void sendAll(String sendMessage){
//        ClientHendler �� Vector �ʵ忡 ����� ���� ������ŭ
//        �ݺ� �����ϸ鼭, �� ���Ͽ� ���� ��½�Ʈ���� �̿���
//        �� Ŭ���̾�Ʈ���� �޼��� ������
//		>> for �� �����
    }


    @Override
    public void run() {
        System.out.println("�� ������");
        TCPClient client = new TCPClient(currentUser);
        client.start();

    }


}
