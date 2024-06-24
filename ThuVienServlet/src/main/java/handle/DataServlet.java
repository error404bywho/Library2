/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package handle;

import dao.bandocDAO;
import dao.loginDAO;
import dao.phieumuontrasachDAO;
import dao.sachDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BanDoc;
import model.PhieuMuonTraSach;
import model.Sach;

/**
 *
 * @author conng
 */
@WebServlet(name = "DataServlet", urlPatterns = {"/DataServlet"})
public class DataServlet extends HttpServlet {
    
        sachDAO s = new sachDAO();
        bandocDAO bd = new bandocDAO();
        phieumuontrasachDAO pmts = new phieumuontrasachDAO();
                
        ArrayList<Sach> ss = s.SelectAll();
        ArrayList<BanDoc> bds = bd.SelectAll();
        ArrayList<PhieuMuonTraSach> pmtss = pmts.SelectAll();
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 
	     //   response.getWriter().append("POST request received.");
        }
      
    
     

}
