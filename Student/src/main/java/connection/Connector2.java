package connection;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;



public class Connector2 {
	static Socket c;
    public static void main(String[] args) throws IOException {
			try {
				Scanner sc = new Scanner(System.in);
				 c = new Socket("localhost",1103);
					
				/*whenever send request = get respond immediately */
					while(true){
						//send request 
						OutputStream o = c.getOutputStream();
						OutputStreamWriter ou = new OutputStreamWriter(o);
	                    BufferedWriter writer = new BufferedWriter(ou);
	                    String message = sc.nextLine();
	                    writer.write(message);
	                    writer.newLine();
	                    writer.flush();
						System.out.println("you sent request :" + message);
						/*handle request of client */ 
						if(message.equals("close")){
							c.close();
							System.out.println("you disconnected");
						}
						//get respond
						InputStream i = c.getInputStream();
						InputStreamReader in = new InputStreamReader(i);
						BufferedReader reader = new BufferedReader(in);
						String clientMessage = reader.readLine();
						System.out.println("you got: " + clientMessage);
					}
			} catch (Exception e) {
				c.close();
				System.out.println("dong ket noi");
			}
		}
}
