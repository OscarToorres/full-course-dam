/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author dam220
 */
public class HibernateSession {

    private static final SessionFactory sessionFactory;

    static {
        File configFile = new File(HibernateSession.class.getResource("").getPath() + "hibernate.cfg.xml");
        Configuration conf = new Configuration().configure(configFile);
        sessionFactory = conf.buildSessionFactory();
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}