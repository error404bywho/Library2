package server;

import java.io.*;
import java.io.ByteArrayOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Util.HibernateUtil;
import database.JDBCUtil;
import model.BanDoc;
import model.Sach;


public class Server123 {
	
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(9999);
			
			System.out.println("waiting connection");
			//lay ra list 14 dong
			ArrayList<Sach>ss = SelectAll();
			for(Sach sach : ss) System.out.println(sach.getTenSach());
			Socket c = s.accept();
			System.out.println("connected");
			InputStream i = c.getInputStream();
			InputStreamReader in = new InputStreamReader(i);
			BufferedReader reader = new BufferedReader(in);
			String[] Base64Data = new String[14];
			String a = "0";
			for(int j=3;j<Base64Data.length;j++) {
				Base64Data[j] = reader.readLine();
				System.out.println("connected");
				byte[] byteImage = Base64.getDecoder().decode(Base64Data[j]);
				ss.get(j).setAnh(byteImage);
				Luu(ss.get(j),ss.get(j).getMaSach());
				System.out.println("luu thanh cong");
				byteImage = new byte[10000];
			}
			
			c.close();
		
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public static void Luu(Sach t, String id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		//sachcu
		Sach sach = session.get(Sach.class,id);
		
		if(sach!=null) {	//sachcu ton tai thi update
			
			sach.setMaSachChung(t.getMaSachChung());
			sach.setMaSach(t.getMaSach());
			sach.setTenSach(t.getTenSach());
			sach.setTheLoai(t.getTheLoai());
			sach.setTacGia(t.getTacGia());
			sach.setTrangThai(t.getTrangThai());
			sach.setAnh(t.getAnh());
			session.update(sach);
		}
		
		tr.commit();
            // Hiển thị thông điệp lỗi bằng JOptionPane
		//JOptionPane.showMessageDialog(null, " Thêm Sách Thành Công",null,  JOptionPane.PLAIN_MESSAGE);
        /***********/
		
		
	}
	public static ArrayList<Sach>SelectAll(){
		
		ArrayList<Sach>ss = new ArrayList<Sach>();
	

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		String HQL = "From Sach";
		
		Query<Sach>query = session.createQuery(HQL);
		
		ss = (ArrayList<Sach>) query.getResultList();
		
		tr.commit();
		
		return ss;
	
	
}
}
