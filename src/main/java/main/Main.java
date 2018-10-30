package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestServlet;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        AllRequestServlet allRequestServlet = new AllRequestServlet();

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(allRequestServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(contextHandler);

        server.start();
        server.join();
    }
}
