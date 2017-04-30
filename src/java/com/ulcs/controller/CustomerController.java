/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulcs.controller;

import com.ulcs.dao.CustomerDAO;
import com.ulcs.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Plus
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

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
           if(request.getParameter("addCustomer")!=null && request.getParameter("addCustomer").equals("Add"))
           {
            String CustomerName=request.getParameter("CsName");
            String CustomerNumber=request.getParameter("CsNumber");
            String CustomerAddress=request.getParameter("CsAddress");
            
            Customer customer= new Customer();  
            customer.setCustomerAddress(CustomerAddress);
            customer.setCustomerName(CustomerName);
            customer.setCustomerNumber(CustomerNumber);
            
            CustomerDAO cdao= new CustomerDAO();
            cdao.insertMember(customer);
            
           List<Customer> cus= cdao.getMemberInfo();
           request.setAttribute("cList",cus);
           RequestDispatcher rd= request.getRequestDispatcher("directory.jsp");
           rd.forward(request, response);
           
           }
           else if(request.getParameter("IDforDelete")!=null)
           {
              String customerID= request.getParameter("IDforDelete");
              CustomerDAO cdao= new CustomerDAO();
              cdao.deleteCustomer(Integer.parseInt(customerID));
              
           List<Customer> cus= cdao.getMemberInfo();
           request.setAttribute("cList",cus);
           RequestDispatcher rd= request.getRequestDispatcher("directory.jsp");
           rd.forward(request, response);
                
            }
            else if(request.getParameter("IDforEdit")!=null)
            {
              String customerID= request.getParameter("IDforEdit");
              CustomerDAO cdao= new CustomerDAO();
              Customer customer=cdao.getCustomer(Integer.parseInt(customerID));
               
              request.setAttribute("customer", customer);

                RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
                rd.forward(request, response);
            }
            else if (request.getParameter("addCustomer")!=null && request.getParameter("addCustomer").equals("Edit"))
            {
                String customerID=request.getParameter("CsID");
                 String CustomerName=request.getParameter("CsName");
            String CustomerNumber=request.getParameter("CsNumber");
            String CustomerAddress=request.getParameter("CsAddress");
              
            Customer customer= new Customer(); 
            customer.setCustomerID(Integer.parseInt(customerID));
            customer.setCustomerAddress(CustomerAddress);
            customer.setCustomerName(CustomerName);
            customer.setCustomerNumber(CustomerNumber);
            
            CustomerDAO cdao= new CustomerDAO();
            cdao.updateCustomer(customer);
            
           List<Customer> cus= cdao.getMemberInfo();
           request.setAttribute("cList",cus);
           RequestDispatcher rd= request.getRequestDispatcher("directory.jsp");
           rd.forward(request, response);
                
            }
              
        }catch(Exception e)
        {
            e.printStackTrace();
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
