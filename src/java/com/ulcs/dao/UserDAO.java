/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulcs.dao;

import com.ulcs.model.User;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Plus
 */
public class UserDAO {
    public User ValidUser(User user){
        try{
            
            String qry="Select * from user where userName =:userName and userPassword =:userPassword";
            AnnotationConfiguration config=new AnnotationConfiguration();
            config.addAnnotatedClass(User.class);
            config.configure("hibernate.cfg.xml");
             SessionFactory factory= config.buildSessionFactory();
             Session session=factory.getCurrentSession();
        
            session.beginTransaction();
            SQLQuery query =session.createSQLQuery(qry);
            query.addEntity(User.class);
            query.setParameter("userName", user.getUserName());
            query.setParameter("userPassword", user.getUserPassword());
            List rs = query.list();
            session.getTransaction().commit();
            if (rs!=null){
                 return user;
            //    return (User) rs;
                
            }
            else return null;
            
           
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
      return null;  
    }
   
    
}
