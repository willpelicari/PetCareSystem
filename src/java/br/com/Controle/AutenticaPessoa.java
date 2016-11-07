package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.animal;
import br.com.Modelo.evento;
import br.com.Modelo.pessoa;
import br.com.Modelo.tipoanimal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WiltonPelicari
 */
public class AutenticaPessoa extends HttpServlet {

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
        try{
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
            String Login = request.getParameter("login");
            String Senha = request.getParameter("senha");
            
            DAO dao = new DAO();
            pessoa Pessoa = dao.autenticaPessoa(Login, Senha);
            
            if(Pessoa.getIdPessoa() != 0){
                sessao.setAttribute("Pessoa", Pessoa);
                sessao.setAttribute("Nome", Pessoa.getNome());
                sessao.setAttribute("Tipo", Pessoa.getIdTipo());
                
                //Get Eventos
                List<evento> eventos = dao.getEventos(Pessoa);
                sessao.setAttribute("Eventos", eventos);
                
                //Get Animais
                List<animal> Animais = dao.getAnimais(Pessoa);
                sessao.setAttribute("Animais", Animais);
                
                String url = "/sistema.jsp";
                ServletContext se = getServletContext();
                RequestDispatcher rd = se.getRequestDispatcher(url);
                rd.forward(request, response);
            }else{
                String url = "/index.jsp";
                request.setAttribute("erro", 1);
                ServletContext se = getServletContext();
                RequestDispatcher rd = se.getRequestDispatcher(url);
                rd.forward(request, response);
            }   
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
