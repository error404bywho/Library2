package server;

import java.net.*;

public class Server {
	public static void main(String[] args) {
		new Server();
	}
	public Server() {
		ServerInit();
	}
	
		public void ServerInit() {
			try {
				ServerSocket s = new ServerSocket(1103); 
				System.out.println("server running on :" + s.getLocalPort());
				int ClientID = 1;
				while(true) {
					Socket c = s.accept();
					//phan luong client
					ServerHandler t = new ServerHandler(c,ClientID);
					System.out.println("client " + ClientID + " connected");
					t.start();
					ClientID++;
					//System.out.println("closed server");

				}
				
			} catch (Exception e) {
				System.out.println("Không thể mở cổng");			}
		}
}
