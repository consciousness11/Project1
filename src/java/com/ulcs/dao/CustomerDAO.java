/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulcs.dao;

import com.ulcs.model.Customer;
import com.ulcs.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Plus
 */
public class CustomerDAO {
    
     public void insertMember(Customer customer){
        try{
//            Connection con=Teledbc.connector();
      //      String qry="insert into customer(customerName,customerAddress,customerNumber) values(=:customerName,=:customerAddress,=:customerNumber)";
            AnnotationConfiguration config=new AnnotationConfiguration();
            config.addAnnotatedClass(Customer.class);
            config.configure("hibernate.cfg.xml");
          //  new SchemaExport(config).create(true, true);
             SessionFactory factory= config.buildSessionFactory();
             Session session=factory.getCurrentSession();
        
            session.beginTransaction();
            Customer cus=new Customer();
            cus.setCustomerName(customer.getCustomerName());
            cus.setCustomerAddress(customer.getCustomerAddress());
            cus.setCustomerNumber(customer.getCustomerNumber());
            session.save(cus);
            session.getTransaction().commit();
//            PreparedStatement pst=con.prepareStatement(qry);
//            pst.setString(1,customer.getCustomerName());
//            pst.setString(2,customer.getCustomerAddress());
//            pst.setString(3,customer.getCustomerNumber());
//            pst.execute();
//            con.close();
        }catch(Exception e){e.printStackTrace();}
    }
     
    public List<Customer> getMemberInfo(){
        try{
            List<Customer> customer=new ArrayList<Customer>();
//            Connection con=Teledbc.connector();
            String qry="Select * from customer";
            AnnotationConfiguration config=new AnnotationConfiguration();
            config.addAnnotatedClass(Customer.class);
            config.configure("hibernate.cfg.xml");
             SessionFactory factory= config.buildSessionFactory();
             Session session=factory.getCurrentSession();
             session.beginTransaction();
             
             SQLQuery query =session.createSQLQuery(qry);
            query.addEntity(Customer.class);
            List rs = query.list();
            session.getTransaction().commit();
            return (List<Customer>)rs;
//            PreparedStatement pst= con.prepareStatement(qry);
//            ResultSet rs=pst.executeQuery();
//            
//            while(rs.next()){
//                Customer m=new Customer();
//                m.setCustomerName(rs.getString("customerName"));
//                m.setCustomerNumber(rs.getString("customerNumber"));
//                m.setCustomerAddress(rs.getString("customerAddress"));
//                m.setCustomerID(rs.getInt("CsID"));
//                customer.add(m);
//            }
//            con.close();
//            return customer;
            
        }
        
        
    catch(Exception e){    e.printStackTrace();}
        return null;
} 
        public Customer getCustomer(int customerID){
        try{
//            Connection con=Teledbc.connector();
           String qry="Select * from customer where customerID=:CsID";
            AnnotationConfiguration config=new AnnotationConfiguration();
            config.addAnnotatedClass(Customer.class);
            config.configure("hibernate.cfg.xml");
             SessionFactory factory= config.buildSessionFactory();
             Session session=factory.getCurrentSession();
             session.beginTransaction();
            SQLQuery query =session.createSQLQuery(qry);
            query.addEntity(Customer.class);
            query.setParameter("CsID", customerID);
             List queryList = query.list();
             session.getTransaction().commit();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Customer) queryList.get(0);
            }
                        
//            PreparedStatement pst= con.prepareStatement(qry);
//            pst.setInt(1, customerID);
//            ResultSet rs=pst.executeQuery();
//            
//            while(rs.next()){
//                Customer m=new Customer();
//                m.setCustomerName(rs.getString("customerName"));
//                m.setCustomerNumber(rs.getString("customerNumber"));
//                m.setCustomerAddress(rs.getString("customerAddress"));
//                m.setCustomerID(rs.getInt("CsID"));
//                return m;
//            }
//            con.close();
                       
        }
      catch(Exception e){    e.printStackTrace();}
        return null;
}
        public void deleteCustomer(int customerID){
        try{
             String qry="delete from customer where customerID=:CsID";
             AnnotationConfiguration config=new AnnotationConfiguration();
            config.addAnnotatedClass(Customer.class);
            config.configure("hibernate.cfg.xml");
             SessionFactory factory= config.buildSessionFactory();
             Session session=factory.getCurrentSession();
             session.beginTransaction();
            SQLQuery query =session.createSQLQuery(qry);
            query.addEntity(Customer.class);
            query.setParameter("CsID", customerID);
            query.executeUpdate();
            session.getTransaction().commit();
//            Connection con=Teledbc.connector();
//            String qry="delete from customer where CsID=?";
//            PreparedStatement pst=con.prepareStatement(qry);
//            pst.setInt(1,customerID);
//            pst.executeUpdate();
//            con.close();
        }catch(Exception e){e.printStackTrace();}
        
    }
        public void updateCustomer(Customer customer){
         try{
             String qry="update customer set customerName=:customerName ,customerAddress=:customerAddress,customerNumber=:customerNumber where customerID=:CsID";
             AnnotationConfiguration config=new AnnotationConfiguration();
            config.addAnnotatedClass(Customer.class);
            config.configure("hibernate.cfg.xml");
             SessionFactory factory= config.buildSessionFactory();
             Session session=factory.getCurrentSession();
             session.beginTransaction();
            SQLQuery query =session.createSQLQuery(qry);
            query.addEntity(Customer.class);
            query.setParameter("CsID", customer.getCustomerID());
            query.setParameter("customerName", customer.getCustomerName());
            query.setParameter("customerAddress", customer.getCustomerAddress());
            query.setParameter("customerNumber", customer.getCustomerNumber());
            query.executeUpdate();
            session.getTransaction().commit();
//            Connection con=Teledbc.connector();
//            String qry="update customer set customerName=? ,customerAddress=?,customerNumber=? where CsID=?";
//            PreparedStatement pst=con.prepareStatement(qry);
//            pst.setString(1,customer.getCustomerName());
//            pst.setString(2,customer.getCustomerAddress());
//            pst.setString(3,customer.getCustomerNumber());
//            pst.setInt(4,customer.getCustomerID());
//            pst.executeUpdate();
//            con.close();
        }catch(Exception e){e.printStackTrace();}
        
    }
    
}
