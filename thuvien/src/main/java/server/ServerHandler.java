package server;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.google.gson.Gson;

import Security.Encode;
import dao.checkDAO;
import dao.phieumuontrasachDAO;
import dao.sachDAO;
import model.BanDoc;
import model.PhieuMuonTraSach;
import model.Sach;

import java.io.*;

public class ServerHandler extends Thread{

	
		private Socket c;
		
		OutputStream o;
		OutputStreamWriter ou;
		BufferedWriter writer;
		
		InputStream i;
		InputStreamReader in;
		BufferedReader reader;
		
		Encode encode = new Encode();
		
		private int id;
		private sachDAO sachdao = new sachDAO();
		
		
		BanDoc globalBanDoc = new BanDoc();
		ArrayList<PhieuMuonTraSach> globalpmts = new ArrayList<PhieuMuonTraSach>();
		
		Scanner sc = new Scanner(System.in);
		
	public ServerHandler(Socket socket,int id ) {
		c = socket;
		this.id = id;
		 try {
			i = c.getInputStream();
			 o = c.getOutputStream();
		} catch (IOException e) {
			System.out.println("can't open iostream in server");
		}
		
		 
		 in = new InputStreamReader(i);
		 reader = new BufferedReader(in);
		 
		
 		 ou = new OutputStreamWriter(o);
         writer = new BufferedWriter(ou);
	}
	/*
	 * lop ClientHandler chi su li viec nghe va gui tin nhan tu client nay sang client khac 
	 */
	@Override
	public void run() {
		
		try {
			while(!c.isClosed()) {
				/*whenever get request = send respond immediately */
					String clientRequest = GetRequest();
	                switch(clientRequest) {
	                case "close" :
	                	c.close();
	    				break;
	                case "login" :
	                	Login();
	                	break;
	                case "signup":
	                	SignUp();
	                	break;
	                case "edit":
	                	Edit();
	                	break;
	                case "muonsach":
	                	BorrowBook();
	                	break;
	                case "trasach":
	                	ReturnBook();
	                	break;
	                case "refresh":
	                	Refresh();
	                default :
	                	
	                }
	            
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	private void close() {
		try {
			c.close();
			System.out.println("client " + id + " disconnected");
		} catch (Exception e) {
			
		}
	}
	 private void Refresh() {
			globalpmts  = phieumuontrasachDAO.PhieuBanDoc(globalBanDoc.getMaBanDoc());
			Gson gson = new Gson();
			for(int i=0;i<globalpmts.size();i++) {
				System.out.println(globalpmts.get(i).toString());
				//ma hoa thanh gson	
				String dataPhieuBanDoc = gson.toJson(globalpmts.get(i));
				//gui sach	
				SendRespond(dataPhieuBanDoc);	 //5
				 
			}
			SendRespond("done");	
		
	}
	private void ReturnBook() {
		String IDCard = GetRequest();
		phieumuontrasachDAO.TraSach(IDCard);
		globalpmts  = phieumuontrasachDAO.PhieuBanDoc(globalBanDoc.getMaBanDoc());
		Gson gson = new Gson();
		for(int i=0;i<globalpmts.size();i++) {
			System.out.println(globalpmts.toString());
			//ma hoa thanh gson	
			String dataPhieuBanDoc = gson.toJson(globalpmts.get(i));
			//gui sach	
			SendRespond(dataPhieuBanDoc);	 //5
			 
		}
		SendRespond("done");	
		
	}
	private void BorrowBook() {
		System.out.println("updating");
		String IDBook = GetRequest();
		System.out.println("updating");
		phieumuontrasachDAO.MuonSach(IDBook,globalBanDoc.getMaBanDoc());
		System.out.println("updating");
		globalpmts  = phieumuontrasachDAO.PhieuBanDoc(globalBanDoc.getMaBanDoc());
		Gson gson = new Gson();
		System.out.println("updating");
		for(int i=0;i<globalpmts.size();i++) {
			System.out.println(globalpmts.toString());
			//ma hoa thanh gson	
			String dataPhieuBanDoc = gson.toJson(globalpmts.get(i));
			//gui sach	
			SendRespond(dataPhieuBanDoc);	 //5
			 System.out.println("updating");
		}
		System.out.println("borrow successfully");
		SendRespond("done");	
		
		
	}
	private void Edit() {
		// TODO Auto-generated method stub
		
	}
	//do signup
	private void SignUp() {
		String publicKey = Encode.PublicKeyToString();
     	System.out.println("you sent public key: " + publicKey);
     	SendRespond(publicKey);
//     	sleep(2000);
     	String Data = GetRequest();
     	Data = Encode.FromCrypto(Data);
     	System.out.println("you got : " + Data);
     	if(checkDAO.CheckSignUp(Data)) {
     		SendRespond("true");
     	}
	}
	 
	 public void Login() {
		String publicKey = Encode.PublicKeyToString();
     	System.out.println("you sent public key: " + publicKey);
     	SendRespond(publicKey);
//     	sleep(2000);
     	String StringData = GetRequest();
     	System.out.println("you got : " + StringData);
     	//data = 23CE.B030 123
     	StringData = Encode.FromCrypto(StringData);
     	BanDoc bd  = checkDAO.CheckLogin(StringData);
     	globalBanDoc = bd;
     	System.out.println(globalBanDoc.toString());
     	if(globalBanDoc != null) {
     		SendRespond("OK");	//1
     		ArrayList<PhieuMuonTraSach> pmts = phieumuontrasachDAO.PhieuBanDoc(globalBanDoc.getMaBanDoc());
     		globalpmts = pmts;
     		
     		//gui tung cuon sach
     		String dataSach = "";
     		String dataPhieuBanDoc = "";
				Gson gson = new Gson();
				//lay 1 mang
				ArrayList<Sach> ss = sachdao.SelectAll();
				/* gui tung cuon sach */
				int count = 1;
				for(int i=0;i<ss.size();i++) {
					//ma hoa thanh gson	
					dataSach = gson.toJson(ss.get(i));
					//gui sach	
					SendRespond(dataSach);	//2
					count++;
					
				}
				//////////////
				System.out.println("you sent " + count + "book");
				SendRespond("done"); //3
				
				//gui ban doc
				String BanDoc= gson.toJson(globalBanDoc);
				SendRespond(BanDoc); //4
				
				for(int i=0;i<globalpmts.size();i++) {
					System.out.println(globalpmts.toString());
					//ma hoa thanh gson	
					dataPhieuBanDoc = gson.toJson(globalpmts.get(i));
					//gui sach	
					SendRespond(dataPhieuBanDoc);	 //5
					count++;
					
				}
				System.out.println("you sent " + count + " book's card");
				SendRespond("done"); //3
				////////////
				//send again to make sure done sending data
     	} else {
     		SendRespond("false");
     		System.out.println("Client " + id + " login failed");
     	}
	 }
	/**************************************************************/
    public String GetRequest() {   	
    		try {
        		//get respond and do st
        		String respond = reader.readLine();
        		System.out.println("you got : " + respond);
        		System.out.println("client " + id + " send request: " + respond);
        		return respond;
    		} catch (Exception e) {
    			System.out.println(e.getMessage() );
    		}
        	return "false";
		} 
    	
   
    public void SendRespond(String respondToClient) {
    	try {
    		//send request 
            writer.write(respondToClient);
            writer.newLine();
            writer.flush();
            System.out.println("send successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
    	
    }
    /**************************************************************/
    
}
