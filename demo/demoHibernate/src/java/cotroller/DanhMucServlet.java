package cotroller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.*;
import model.*;
import java.util.*;

@WebServlet(name = "DanhMucServlet", urlPatterns = {"/DanhMucServlet"})
public class DanhMucServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           System.out.println(request);
           String action = request.getParameter("action");
           String page = "";
           DanhMucModel dmm = new DanhMucModel();
           if(action.equals("xoa")){
               page = "index.jsp";
               Integer madanhmuc = Integer.valueOf(request.getParameter("madanhmuc"));
               Danhmuc dm = dmm.thongtin(madanhmuc);
               dmm.xoa(dm);
           }
           else
           {
               if(action.equals("xulythem")){
                   page = "index.jsp";
                   Danhmuc dm = new Danhmuc();
                   dm.setTendanhmuc(request.getParameter("tendanhmuc"));
                   dmm.them(dm);
               }
           }
           request.getRequestDispatcher(page).forward(request, response);
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
