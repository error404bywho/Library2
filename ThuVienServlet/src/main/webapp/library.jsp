<%@page import="com.mysql.cj.Session"%>
<%@page import="dao.*"%>
<%@page import="java.io.*"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="widtd=device-widtd, initial-scale=1.0">
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" href="library.css" />
    <title>Library</title>
    
  
    
   
</head><body>
    <div class="bg-image"></div>
    <div class="container content">
        <div class="table-container">
            
            <h2><i><b>BOOK</b></i></h2>
            <% 
                sachDAO s = new sachDAO();
                ArrayList<Sach> ss = s.SelectAll();
            %>
            <table class="table table-bordered">
                <tdead>
                    <tr>
                        <th>Book's ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Author</th>
                    </tr>
                </tdead>
                <tbody>
                        <%
                        for(Sach sach : ss){
                        %>
                        <tr>
                        <td><%=sach.getMaSach()%></td>
                        <td><%=sach.getTenSach()%></td>
                        <td><%=sach.getTheLoai()%></td>
                        <td><%=sach.getTacGia()%></td>
                         </tr>
                        <%
                            }
                        %>
                        
                </tbody>
            </table>
        </div>
        
        <div class="table-container">
            <h2><i><b>USER</b></i></h2>
            <% 
               bandocDAO bd = new bandocDAO();
               ArrayList<BanDoc> bds = bd.SelectAll();
            %>
            <table class="table table-bordered">
                <tdead>
                    <tr>
                        <th>User's ID</th>
                        <th>Name </th>
                        <th>Position</th>
                    </tr>
                </tdead>
                <tbody>
                
                    <%
                    for(BanDoc bandoc : bds){
                    %>
                    <tr>
                        <td><%=bandoc.getMaBanDoc() %></td>
                        <td><%=bandoc.getTen() %></td>
                        <td><%=bandoc.getChucVu() %></td>
                    </tr>
                    <%
                        }
                    %>
               </tbody>
            </table>
        </div>
        <div class="table-container">
            <h2>Book's CARD</h2>
            <table class="table table-bordered">
                <tdead>
                    <%
                        phieumuontrasachDAO pmts = new phieumuontrasachDAO();
                        ArrayList<PhieuMuonTraSach> pmtss = pmts.SelectAll();
                    %>
                    
                    <tr>
                        <th>Book's Card ID</th>
                        <th>User's ID</th>
                        <th>Book's ID</th>
                        <th>Borrowing Date</th>
                        <th>Expiration Date</th>
                        <th>Statement</th>
                    
                    </tr>
                </tdead>
                <tbody>
                     <% for(PhieuMuonTraSach phieumuontrasach : pmtss)
                     {
                     %>
                     <tr>
                         <td><%= phieumuontrasach.getMaPhieuMuon() %></td>
                         <td><%= phieumuontrasach.getMaBanDoc() %></td>
                         <td><%= phieumuontrasach.getMaSach() %></td>
                         <td><%= phieumuontrasach.getNgayMuon() %></td>
                         <td><%= phieumuontrasach.getHanTra() %></td>
                         <td><%= phieumuontrasach.getTinhTrang() %></td>
                     </tr>
                     <%
                     }
                     %>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpatd.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
