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
import java.util.ArrayList;
import java.util.List;
import newpackage.ToDo;

/**
 *
 * @author liam1
 */
@WebServlet(name = "AddTodo", urlPatterns = {"/AddTodo"})
public class AddTodo extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Takes in our inputs
        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");
        
        HttpSession session = request.getSession();

        // Get the list of tasks from the session or create it if it doesn't exist
        List<ToDo> taskList = (List<ToDo>) session.getAttribute("taskList"); 
        if (taskList == null) {
            taskList = new ArrayList<>();
            session.setAttribute("taskList", taskList);
        }
                       
            ToDo newTask = new ToDo();
            newTask.setTask(taskName);
            newTask.setDetails(taskDescription);

        // Add the new task to the list
        taskList.add(newTask);

        // Go back to the GetTodoList servlet to display the updated list
        response.sendRedirect("GetTodoList");
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
