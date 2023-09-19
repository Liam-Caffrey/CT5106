/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import newpackage.ToDo;

/**
 *
 * @author liam1
 */
@WebServlet(name = "GetTodoList", urlPatterns = {"/GetTodoList"})
public class GetTodoList extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        
         List<ToDo> taskList = (List<ToDo>) session.getAttribute("taskList");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Todo List</title></head>");//Title
        out.println("<body>");
        
        if (taskList == null || taskList.isEmpty()) {
        out.println("<p>Add some Tasks!</p>"); //For empty or null todo list
        }
        else {
            // Output table layout
            out.println("<h1>Todo List</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>Task</th><th>Details</th></tr>");

            //iterrate through the task list and print out each task
            for (ToDo task : taskList) {
                out.println("<tr><td>" + task.getTask() + "</td><td>"+ task.getDetails()+"</td></tr>");
            }

           
        }
out.println("<a href='AddTodo.html'>Add a Task</a>");
//Link to add new task
        
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
