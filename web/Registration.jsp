<%-- 
    Document   : index
    Created on : Apr 16, 2017, 1:06:33 PM
    Author     : Plus
--%>

<%@page import="com.ulcs.model.Customer"%>
<%@page import="com.ulcs.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Fill the following to register</h1>
         <%
            User user=(User)session.getAttribute("vuser");
            if (user== null){
                response.sendRedirect("login.jsp");  
            }else{
            %>
         <form action="CustomerController" method="get">
             <%
                Customer customer= (Customer)request.getAttribute("customer");
                if (customer==null){
                     customer=new Customer();
                     customer.setCustomerAddress("");
                     customer.setCustomerName("");
                     customer.setCustomerNumber("");
                     customer.setCustomerID(0);
                }
                %>
              <input type="hidden"  name="CsID" value="<%=customer.getCustomerID() %>">
            <table> 
                <tr> <td>Customer Name</td><td><input type="text" name="CsName" value="<%=customer.getCustomerName()%>"></td></tr>
                <tr> <td>Customer Number</td><td><input type="text" name="CsNumber" value="<%=customer.getCustomerNumber()%>"></td></tr>
                <tr><td>Customer Address</td><td><input type="text" name="CsAddress" value="<%=customer.getCustomerAddress()%>"></td></tr>
                <tr><td><input type="submit" value="<%=customer.getCustomerID()== 0?"Add":"Edit"%>" name="addCustomer"></td></tr>
         </form>
                <%
            }
                %>
    </body>
</html>
