package net.multi.chatting.server;

public class RunTCPServer {

    public static void main(String[] args) {

//        User[] users = new User[5];
//        {
//            users[0] = new User("user01","pass01","smileman");
//            users[1] = new User("user02","pass02","prittywoman");
//            users[2] = new User("user03","pass03","javajjang");
//            users[3] = new User("test123","test123","testboy");
//            users[4] = new User("p1234","p1234","pick");
//        }


        //TCPServer start
        new TCPServerMulti().start();

        System.out.println("서버가 종료되었습니다.");
    }

}
