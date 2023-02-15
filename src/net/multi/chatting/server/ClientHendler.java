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
//        ClientHendler 의 Vector 필드에 저장된 소켓 갯수만큼
//        반복 실행하면서, 각 소켓에 대한 출력스트림을 이용해
//        각 클라이언트에게 메세지 전송함
//		>> for 문 사용함
    }


    @Override
    public void run() {
        System.out.println("새 스레드");
        TCPClient client = new TCPClient(currentUser);
        client.start();

    }


}
