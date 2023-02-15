package client1;

import net.multi.chatting.server.TCPServerMulti;

public class RunTCPClient111111 {
    public static void main(String[] args) {
        //TCPClient start
        new TCPServerMulti().loginCheck("user01", "pass01");

        System.out.println("클라이언트 프로그램 종료");
    }
}
