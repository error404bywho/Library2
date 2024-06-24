package connection;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Security.Encode;
import model.BanDoc;
import model.PhieuMuonTraSach;
import model.Sach;




public class Connector {
	
	static Socket c ;
	
	ArrayList<PhieuMuonTraSach> pmts = new ArrayList<PhieuMuonTraSach>();
	
	OutputStream o;
	OutputStreamWriter ou;
	BufferedWriter writer;
	
	InputStream i;
	InputStreamReader in;
	BufferedReader reader;
	
	public Connector() {
		
	}
	
	public Connector(boolean a) {
		try {
			 c = new Socket("localhost",1103);
			 
			 i = c.getInputStream();
    		 in = new InputStreamReader(i);
    		 reader = new BufferedReader(in);
    		 
    		 o = c.getOutputStream();
     		 ou = new OutputStreamWriter(o);
             writer = new BufferedWriter(ou);
             
             
		} catch (UnknownHostException e) {
			System.out.println(e);
			} catch (IOException e) {
			System.out.println(e);
		}
	}
	public static void close() {
		try {
			OutputStream o = c.getOutputStream();
			OutputStreamWriter ou = new OutputStreamWriter(o);
			BufferedWriter sendClose= new BufferedWriter(ou);
			sendClose.write("close");
			sendClose.newLine();
			sendClose.flush();
			
			c.close();
			
		} catch (IOException e) {
			System.out.println("can't close socket123123");
			System.out.println(e.getMessage());
			
		}
	}

	
    //GET DATA IN LOGIN PANEL
    public String Login(String DataLogin) throws IOException {
    	/*
    	 * 1. send request "login"
    	 * 2. get key
    	 * 3. ToCrypto
    	 * 4. send data to login to Server
    	 * 5. Check Login (return true or false)
    	 */
    	// 1. send request "connect"
    	SendRequest("login");
    	// 2. get key
    	String PublicKey = GetRespond();
		System.out.println("you got Public Key: " + PublicKey);
    	if(PublicKey.equals("false"))	return "false"; //!false ==> Public Key
    	// 3. ToCrypto
    	String Data = Encode.ToCrypto(DataLogin,PublicKey);
    	//4. send data to login to Server
    	SendRequest(Data);
    	
    	String DataSach = GetRespond();
    	
    	// 5. Check Login (return data or false)
    	return DataSach;
    }
    public ArrayList<PhieuMuonTraSach> Refresh(){
    	ArrayList<PhieuMuonTraSach> rs = new ArrayList<PhieuMuonTraSach>();
    	SendRequest("refresh");
    	
while(true) {
			
			//nhan gson
    		String gDataUpdate = GetRespond(); //2
			if(gDataUpdate.equals("done")) break;
			//bien doi gson
			PhieuMuonTraSach PhieuMuonTraSach = ConvertToPhieuMuonTraSach(gDataUpdate);
			//System.out.println(sach.toString());
			rs.add(PhieuMuonTraSach);
			
		}
    	
    	return rs;
    }
    public ArrayList<PhieuMuonTraSach> TraSach(String IDCard) {
    	SendRequest("trasach");
    	SendRequest(IDCard);
    	pmts = new ArrayList<PhieuMuonTraSach>();
    	while(true) {
			
			//nhan gson
    		String gDataUpdate = GetRespond(); //2
			if(gDataUpdate.equals("done")) break;
			//bien doi gson
			PhieuMuonTraSach PhieuMuonTraSach = ConvertToPhieuMuonTraSach(gDataUpdate);
			//System.out.println(sach.toString());
			pmts.add(PhieuMuonTraSach);
			
		}
    	System.out.println("you got number of Phieu muon in Update: " + pmts.size());

    	return pmts;
		
    }
    public ArrayList<PhieuMuonTraSach> MuonSach(String IDBook) {
    	SendRequest("muonsach");
    	SendRequest(IDBook);
    	pmts = new ArrayList<PhieuMuonTraSach>();
    	while(true) {
			//nhan gson
    		String gDataUpdate = GetRespond(); //2
			if(gDataUpdate.equals("done")) break;
			//bien doi gson
			PhieuMuonTraSach PhieuMuonTraSach = ConvertToPhieuMuonTraSach(gDataUpdate);
			//System.out.println(sach.toString());
			pmts.add(PhieuMuonTraSach);
			
		}
    	System.out.println("you got number of Phieu muon in Update: " + pmts.size());

    	return pmts;
		
    }
    public String SignUp(BanDoc bd) {
    	/*
    	 * 1. send request "signup"
    	 * 2. get key
    	 * 3. ToCrypto
    	 * 4. send data for sign up to Server
    	 * 5. Check Signup  (return true or false)
    	 */
    	SendRequest("signup");
    	// 2. get key
    	String PublicKey = GetRespond();
		System.out.println("you got Public Key: " + PublicKey);
    	if(PublicKey.equals("false"))	return "false"; //!false ==> Public Key
    	// 3. ToCrypto
    	String Data = Encode.ToCrypto(bd.toString(),PublicKey);
    	//4. send data for sign up to Server
    	SendRequest(Data);
    	System.out.println("you send :" + Data);
    	
    	String DataSach = GetRespond();
    	
    	String check = ((DataSach.equals("true")) ? "true" : "false");
    	// 5. Check Login (return true or false)
    	return check;
    }
    
    
    /**************************************************************/
    // GetRespond o dang String vi co the la public key or true or false 
    public String GetRespond() {
    	try {
    		//get respond and do st
    		String respond = reader.readLine();
    	//	System.out.println("you got message: " + respond);
    		return respond;
		} catch (Exception e) {
			System.out.println(e.getMessage() );
		}
    	return "false";
    }
    public void SendRequest(String Request) {
    	try {
            writer.write(Request);
            writer.newLine();
            writer.flush();
            System.out.println("You sent : " + Request);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }
    /**************************************************************/
    private PhieuMuonTraSach ConvertToPhieuMuonTraSach(String dataPMTS) {
		Gson gson = new Gson();
		Type objectType = new TypeToken<PhieuMuonTraSach>(){}.getType();
		PhieuMuonTraSach pmts= gson.fromJson(dataPMTS,objectType);
		return pmts;
	}
    
    
    
    
    
    
}
