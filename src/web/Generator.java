package web;

import midtier.Writer;
import scope.Site;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @author AbuKhleif
 */

public class Generator extends HttpServlet {
    private HttpSession session;
    private static Writer writer;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        // read the "command" parameter
        String command = request.getParameter("command");
        // if the t_command is missing, then execute the default command
        if (command == null) {
            command = "LIST";
        }
        System.out.println(command);
        // route to the appropriate method
        switch (command) {
            case "SITE":
                try {
                    addSite(request, response);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                break;
//            case "UPDATE":
//                updateMarkProcessing(request, response);
//                break;
//            case "MARK":
//                updateMark(request, response);
//                break;
//            case "LIST":
//            default:
//                listSections(request, response);
        }
        session.setAttribute("t_command", null);
    }

    private void addSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JAXBException {
        // read site data from request
        String siteName = request.getParameter("name");
        String siteUrl = request.getParameter("url");
        String xmlTitle = request.getParameter("xml");

        if (siteName != null && siteUrl != null && xmlTitle != null) {
            // add the site and forward to add scenario page...
            writer = Writer.getInstance();
            writer.setSite(new Site(siteName, siteUrl));
            writer.write(xmlTitle);
            RequestDispatcher dispatcher = request.getRequestDispatcher("generator.jsp");
            dispatcher.forward(request, response);
        } else {
            // back to the same page...
            RequestDispatcher dispatcher = request.getRequestDispatcher("generator.jsp");
            dispatcher.forward(request, response);
        }
    }
}