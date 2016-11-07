package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "InsereEvento", urlPatterns = {"/IE"})
public class InsereEvento extends HttpServlet {

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

            Integer IdEvento = Integer.parseInt(request.getParameter("idevento"));
            String Data = request.getParameter("data");
            
            //Conversão String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(Data);

            System.out.println(date.toString());
            
            String Descricao = request.getParameter("descricao");
            Integer IdAnimal = Integer.parseInt(request.getParameter("idanimal"));
            Integer IdResponsavel = Integer.parseInt(request.getParameter("idresponsavel"));
            Float Valor = Float.parseFloat(request.getParameter("valor"));

            //para inserir os dados do formulário no banco
            evento ev = new evento(IdEvento, date, Descricao, IdAnimal, IdResponsavel, Valor);
            DAO dao = new DAO();
            dao.insereEvento(ev);
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
