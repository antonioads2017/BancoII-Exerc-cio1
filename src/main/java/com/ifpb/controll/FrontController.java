package com.ifpb.controll;

import com.ifpb.model.dao.CidadeDao;
import com.ifpb.model.dao.CidadeDaoImpl;
import com.ifpb.model.dao.DataException;
import com.ifpb.model.databese.ConnectionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/inicio")
public class FrontController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CidadeDao dao = new CidadeDaoImpl();
            String estado1 = request.getParameter("estado1");
            String estado2 = request.getParameter("estado2");
            String cidade1 = request.getParameter("cidade1");
            String cidade2 = request.getParameter("cidade2");
            request.setAttribute("estadoSelecionado1",estado1);
            request.setAttribute("cidadeSelecionada1",cidade1);
            request.setAttribute("estadoSelecionado2",estado2);
            request.setAttribute("cidadeSelecionada2",cidade2);

            List<String> estados = dao.buscarNomesDosEstados();
            request.setAttribute("estados",estados);
            List<String> cidades1 = dao.buscarNomeDasCidades(estado1);
            request.setAttribute("cidades1",cidades1);
            List<String> cidades2 = dao.buscarNomeDasCidades(estado2);
            request.setAttribute("cidades2",cidades2);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CidadeDao dao = new CidadeDaoImpl();
            List<String> estados = dao.buscarNomesDosEstados();
            request.setAttribute("estados",estados);
            List<String> cidades1 = dao.buscarNomeDasCidades(estados.get(0));
            List<String> cidades2 = dao.buscarNomeDasCidades(estados.get(0));
            request.setAttribute("cidades1",cidades1);
            request.setAttribute("cidades2",cidades2);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }

    }
}
