/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.tipopessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eduardo Oliveira
 */
public class InsereTipoPessoa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession sessao = request.getSession(true);
            System.out.println(" \n SESSÃO: " + sessao);
            //SE FOR UMA NOVA SESSÃO, REESCREVER A URL
            if (sessao.isNew()) {
                //obtem uma nova URL para a sessão
                String incomingURL = request.getRequestURL().toString();
                //codifica e adiciona um ID para a sessão
                String URLwithID = response.encodeRedirectURL(incomingURL);
                //devolve a URL para o cliente
                response.setHeader("Custom-newURL", URLwithID);
            }

            Integer codigo = Integer.parseInt(request.getParameter("Cod"));
            String Descricao = request.getParameter("Descricao");
            //para inserir os dados do formulário no banco
            tipopessoa tipo = new tipopessoa(codigo, Descricao);
            DAO dao = new DAO();
            dao.insereTipoPessoa(tipo);
            String url = "/OK.jsp";
            ServletContext se = getServletContext();
            RequestDispatcher rd = se.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println(e.getMessage());
            String url = "/Erro.jsp";
            ServletContext se = getServletContext();
            RequestDispatcher rd = se.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
