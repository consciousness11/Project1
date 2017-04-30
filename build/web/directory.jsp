<%-- 
    Document   : directory
    Created on : Sep 11, 2014, 8:25:33 AM
    Author     : Latitude
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ulcs.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User info</title>
    </head>
    <body>
        <h1>User Details</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>Telephone Number</th>
                <th>Change</th>
            </tr>
            <%
                List<Customer> cuslist= (ArrayList) request.getAttribute("cList");
                if(cuslist==null){
                    response.sendRedirect("Register.jsp");
                }
                else
                {
                    for(Customer customer:cuslist){
                      %>
                      <tr>
                          <td><%=customer.getCustomerName()%> </td>
                          <td><%=customer.getCustomerAddress()  %> </td>
                          <td><%=customer.getCustomerNumber() %> </td>
                          <td><a href="CustomerController?IDforEdit=<%=customer.getCustomerID()%>">Edit</a></td>
                         <td><a href="CustomerController?IDforDelete=<%=customer.getCustomerID()%>">Delete</a></td>
                      </tr>
                      <% 
                    }
                }
                %>
                   
               </table>
    </body>
</html>
