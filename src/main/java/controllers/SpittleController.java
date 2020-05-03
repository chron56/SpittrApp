package controllers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrServiceException;
import spittrpackage.persistence.SpittrDao;
import spittrpackage.persistence.SpittrDaoHibernateImpl;
import spittrpackage.service.SpittrServiceImpl;

public class SpittleController extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SpittrDao mydao = new SpittrDaoHibernateImpl();
        SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
        Spittle aSpittle;
        String action = request.getParameter("action");
        String rdview = "";

        try{
            if(action.equalsIgnoreCase("addSpittle")){
                request.setAttribute("spitters", aService.getAllSpitters());
                rdview = "addSpittle.jsp";
            }
            else if(action.equalsIgnoreCase("addSpitter")){
                rdview = "addSpitter.jsp";
            }
            else if(action.equalsIgnoreCase("updateSpittle")){
                int spittleId = Integer.parseInt(request.getParameter("spittleId"));
                aSpittle = aService.getSpittle(spittleId);
                request.setAttribute("spittle",aSpittle);
                rdview = "updateSpittle.jsp";
            }
            else if(action.equalsIgnoreCase("deleteSpittle")){
                int spittleId = Integer.parseInt(request.getParameter("spittleId"));
                aSpittle = aService.getSpittle(spittleId);
                aService.deleteSpittle(aSpittle);
                request.setAttribute("spittles", aService.getAllSpittles());
                request.setAttribute("spitters", aService.getAllSpitters());
                rdview = "listSpittles.jsp";
            }
            else if (action.equalsIgnoreCase("listSpittles")){
                request.setAttribute("spittles", aService.getAllSpittles());
                request.setAttribute("spitters", aService.getAllSpitters());
                rdview = "listSpittles.jsp";
            }
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher(rdview);
        view.forward(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SpittrDao mydao = new SpittrDaoHibernateImpl();
        SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
        List<Spitter> spittersList;
        List<Spittle> spittlesList;
        Spittle aSpittle = new Spittle();
        Spitter aSpitter = new Spitter();
        String action = request.getParameter("action");

        try{
            if(action.equalsIgnoreCase("addSpittle")){
                int spitterId = Integer.parseInt(request.getParameter("spitterId"));
                aSpitter = aService.getSpitter(spitterId);
                aSpittle.setSpitter(aSpitter);
                aSpittle.setText(request.getParameter("spittleText"));
                aService.addSpittle(aSpittle);
                request.setAttribute("spittles", aService.getAllSpittles());
            }
            else if (action.equalsIgnoreCase("addSpitter")){
                String  spitterUsername = request.getParameter("spitterUsername");
                aSpitter.setUsername(spitterUsername);
                aService.addSpitter(aSpitter);
                request.setAttribute("spittles", aService.getAllSpittles());
            }
            else if (action.equalsIgnoreCase("updateSpittle")){
                int spittleId = Integer.parseInt(request.getParameter("spittleId"));
                String spittleText = request.getParameter("spittleText");
                aSpittle = aService.getSpittle(spittleId);
                aSpittle.setText(spittleText);
                aService.updateSpittle(aSpittle);
                request.setAttribute("spittles", aService.getAllSpittles());
            }
            else if (action.equalsIgnoreCase("selectSpitter")) {
                int spitterId = Integer.parseInt(request.getParameter("spitterId"));
                if (spitterId == 0){
                    request.setAttribute("spittles", aService.getAllSpittles());
                }
                else{
                    aSpitter = aService.getSpitter(spitterId);
                    request.setAttribute("spittles", aService.getSpittersSpittles(aSpitter));
                }
            }
            request.setAttribute("spitters", aService.getAllSpitters());
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher("listSpittles.jsp");
        view.forward(request, response);
    }
}