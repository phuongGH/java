/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.*;
import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AA
 */
@WebServlet(name = "checkOffer", urlPatterns = {"/checkOffer"})
public class checkOffer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection con = db.getConnection();
            long mobileNo = Long.valueOf(request.getParameter("mobileNo"));
            out.println("mobileNo" + mobileNo);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select offerid from customers where mobile="+mobileNo);
                if(rs.next()){
                 int id = Integer.parseInt((String)rs.getString(1));
                 if(id==0){
                     int n = (int)(Math.random()*7)+1;
                     PreparedStatement pstm = con.prepareStatement("update customers set offerid=? where mobile=?");
                     pstm.setInt(1, n);
                     pstm.setLong(2, mobileNo);
                     pstm.executeQuery();
                     rs = stmt.executeQuery("select descr from offer where id ="+n);
                     if(rs.next())
                     {
                         request.setAttribute("offerMsg", "offer to " + mobileNo + " : " + (String)rs.getString(1));
                         request.getRequestDispatcher("index.jsp").forward(request, response);
                     }
                 }else{
                     rs = stmt.executeQuery("select descr from offer where id="+id);
                     if(rs.next())
                     {
                         request.setAttribute("offerMsg", "offer to " + mobileNo + " : " + (String)rs.getString(1));
                         request.getRequestDispatcher("index.jsp").forward(request, response);
                     }
                 }
                }
            } catch (Exception e) {
                request.setAttribute("offerMsg", "not register");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                out.println("error " + e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
