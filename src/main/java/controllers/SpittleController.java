package controllers;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.persistence.SpittrDao;
import spittrpackage.persistence.SpittrDaoHibernateImpl;
import spittrpackage.service.SpittrServiceImpl;
import java.util.List;

public class SpittleController extends HttpServlet {

    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");

        if(action.equalsIgnoreCase("addSpittle")){
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            request.setAttribute("spitters", aService.getAllSpitters());
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("addSpittle.jsp");
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("addSpitter")){
            RequestDispatcher view = request.getRequestDispatcher("addSpitter.jsp");
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("updateSpittle")){
            int spittleId = Integer.parseInt(request.getParameter("spittleId"));
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            request.setAttribute("spittle",aService.getSpittle(spittleId));
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("updateSpittle.jsp");
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("deleteSpittle")){
            int spittleId = Integer.parseInt(request.getParameter("spittleId"));
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            Spittle tempSpittle = aService.getSpittle(spittleId);
            aService.deleteSpittle(tempSpittle);
            request.setAttribute("spittles", aService.getAllSpittles());
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("listSpittles.jsp");
            view.forward(request, response);
        }
        else if (action.equalsIgnoreCase("listSpittles")){
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            request.setAttribute("spittles", aService.getAllSpittles());
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("listSpittles.jsp");
            view.forward(request, response);
        }

    }

    public void doPost (HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException
    {
        String todo = request.getParameter("todo");
        if (todo.equalsIgnoreCase("updateSpittle")) {
            int spittleId = Integer.parseInt(request.getParameter("spittleId"));
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            Spittle tempSpittle = aService.getSpittle(spittleId);
            tempSpittle.setText(request.getParameter("spittleText"));
            aService.updateSpittle(tempSpittle);
            request.setAttribute("spittles", aService.getAllSpittles());
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("listSpittles.jsp");
            view.forward(request, response);
        }
        else if(todo.equalsIgnoreCase("addSpittle")) {
            int spitterId = Integer.parseInt(request.getParameter("spitterId"));
            Spittle tempSpittle =  new Spittle();
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            Spitter tempSpitter = aService.getSpitter(spitterId);
            tempSpittle.setSpitter(tempSpitter);
            tempSpittle.setText(request.getParameter("spittleText"));
            aService.addSpittle(tempSpittle);
            request.setAttribute("spittles", aService.getAllSpittles());
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("listSpittles.jsp");
            view.forward(request, response);
        }
        else if (todo.equalsIgnoreCase("addSpitter")) {
            SpittrDao mydao = new SpittrDaoHibernateImpl();
            SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
            aService.init();
            Spitter tempSpitter = new Spitter();
            tempSpitter.setUsername(request.getParameter("spitterUsername"));
            aService.addSpitter(tempSpitter);
            request.setAttribute("spittles", aService.getAllSpittles());
            aService.close();
            RequestDispatcher view = request.getRequestDispatcher("listSpittles.jsp");
            view.forward(request, response);
        }

    }
}