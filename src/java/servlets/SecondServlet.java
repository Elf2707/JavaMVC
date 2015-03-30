/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import CalcUtils.Calc;
import CalcUtils.Operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elf
 */
@WebServlet(name = "SecondServlet", urlPatterns = {"/SecondServlet"})
public class SecondServlet extends HttpServlet {

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
       
       ArrayList<HttpSession> sessions;
       //получаем доступ к списку сессий
       sessions = (ArrayList<HttpSession>)getServletContext().getAttribute("sessions");
       if(sessions == null){
           //первый вызов создаем список сессий
           sessions = new ArrayList<>();
       }
       
       //определяем сессию
       HttpSession session = request.getSession();
       ArrayList<String> operations = null;
       //если сессия новая создаем новый список
       if(session.isNew()){
           operations = new ArrayList<>();
            //добавляем сессию  в список сессий
           sessions.add(session);
       }else{
           //Вытаскиваем из сессии аррей лист
           if( session.getAttribute("operations") instanceof ArrayList ){
               operations = (ArrayList<String>)session.getAttribute("operations");
           }
       }
       
       //Добавляем операцию в ArrayList
       operationsCount++;
       int oper1 = Integer.parseInt(request.getParameter("oper1"));
       int oper2 = Integer.parseInt(request.getParameter("oper2"));
       Operations calcOperation;
       try{
          calcOperation = Operations.valueOf(request.getParameter("oper"));
       }catch( Exception ex){
          response.sendError(HttpServletResponse.SC_BAD_REQUEST);
          calcOperation = Operations.MUL;
       }
           
       int result = Calc.calculation(oper1, oper2, calcOperation);
       operations.add( oper1 + calcOperation.getStringValue() + oper2 + "=" + result);
       //пишем операции в сессию
       session.setAttribute("operations", operations);
       //пишем в контекст список сессий
       getServletContext().setAttribute("sessions", sessions);
      
       //выводим ответ клиенту
       PrintWriter out = response.getWriter();
       try{
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SecondServlet</title>");
            out.println("<link rel='stylesheet' href='styles.css' type='txt/css'/> ");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello world keep goin in Session ID= " + session.getId() + "</h1>");
            out.println("<h1>Всего по всем сессииям " + operationsCount + " операций </h1>");
            out.println("<h1>Вот они </h1>");
            out.println("<div class='ListOperations'>");
            //проходим по всем сессиям и для каждой печатаем операции
            for(HttpSession contextSession:sessions){
               ArrayList<String> sessionOperations = (ArrayList<String>)contextSession.getAttribute("operations");
               if(sessionOperations == null){
                   //в сессии нет операций
                   out.println("<h2>В сессии " + contextSession.getId() + "нет операций</h2>");
               }else{
                   out.println("<h2>Операции сесии: " + contextSession.getId() + "</h2>");
                   sessionOperations.stream().forEach((s) -> {
                       out.println("<h2>" + s + "</h2>");
                   }); 
               }
            }
            out.println("</div>");
            
        }catch( Exception ex ){
            ex.printStackTrace(System.out);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }finally{
            out.println("</body>");
            out.println("</html>");
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
    private int operationsCount;
}
