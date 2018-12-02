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
        String commandName = request.getParameter("command");
        try {
            Command atualizarCommand = new AtualizarCampos();
            atualizarCommand.execute(request,response);
            if(commandName.equals("GerarSVG")){
                Command command = (Command) Class.forName(this.getClass().getPackage().getName() + "." + commandName).newInstance();
                command.execute(request, response);
            }
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            response.sendError(404);
        } catch (CommandException e) {
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
