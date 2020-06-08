/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.web;

import com.sun.imageio.plugins.common.I18N;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import survey.ejb.BackBean;

/**
 *
 * @author RozyZzx
 */
@WebServlet(name = "SurveyServlet", urlPatterns = {"/SurveyServlet"})
public class SurveyServlet extends HttpServlet {

    @EJB
    private BackBean backBean;

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
        try {
            
            if (!request.getParameter("n0").isEmpty()) {
                String name = request.getParameter("n0");
                String id = request.getParameter("i0") + "," + request.getParameter("i1");
                String addr = request.getParameter("a0") + "," + request.getParameter("a1") + "," + request.getParameter("a2");
                String contact = request.getParameter("k0") + "," + request.getParameter("k1");
                String suspect = request.getParameter("s0") + "," + request.getParameter("s1") + "," + request.getParameter("s2");
                String additional = request.getParameter("g0");
                
                String result = backBean.decide(name, id, addr, contact, suspect, additional);
                System.out.println(result);
                request.setAttribute("stat", result);
            }
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/covid.jsp");
            rd.include(request, response);
        } catch (IOException | ServletException ex) {
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/covid.jsp");
            rd.include(request, response);
        } finally {
            PrintWriter out = response.getWriter();
            out.close();
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
