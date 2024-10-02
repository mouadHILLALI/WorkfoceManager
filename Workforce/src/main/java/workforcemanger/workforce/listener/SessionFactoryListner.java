package workforcemanger.workforce.listener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SessionFactoryListner implements ServletContextListener {
    private static SessionFactory sessionFactory;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        event.getServletContext().setAttribute("SessionFactory", sessionFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        sessionFactory.close();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
