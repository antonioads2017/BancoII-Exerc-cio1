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
        System.out.println("Entrou");
        try {
            CidadeDao dao = new CidadeDaoImpl();
            List<String> estados = dao.buscarNomesDosEstados();
            request.setAttribute("estados",estados);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
