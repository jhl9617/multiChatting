package client2;

import net.multi.chatting.server.TCPServerMulti;

public class RunTCPClient2222222 {
    public static void main(String[] args) {
        //TCPClient start
        new TCPServerMulti().loginCheck("user02", "pass02");
        System.out.println("클라이언트 프로그램 종료");
    }
}
