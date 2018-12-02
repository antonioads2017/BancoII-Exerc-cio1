package com.ifpb.controll;

import com.ifpb.model.dao.CidadeDao;
import com.ifpb.model.dao.CidadeDaoImpl;
import com.ifpb.model.dao.DataException;
import com.ifpb.model.databese.ConnectionException;
import com.ifpb.model.domain.Cidade;

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
//        String commandName = request.getParameter("command");
//        try {
//            Command atualizarCommand = new AtualizarCampos();
//            atualizarCommand.execute(request,response);
//            if(commandName.equals("GerarSVG")){
//                Command command = (Command) Class.forName(this.getClass().getPackage().getName() + "." + commandName).newInstance();
//                command.execute(request, response);
//            }
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            response.sendError(404);
//        } catch (CommandException e) {
//            e.printStackTrace();
//        }
        try {

            /*
                Ao inicializar o servlet ele vai pegar por parametro quais foram os estados e cidades que o
                usuário havia escolhido, para que se possa manter os mesmos como selecionados assim que a
                página atualizar.
             */
            CidadeDao dao = new CidadeDaoImpl();
            String estado1 = request.getParameter("estado1");
            String estado2 = request.getParameter("estado2");
            String cidade1 = request.getParameter("cidade1");
            String cidade2 = request.getParameter("cidade2");
            //Estas variáveis também servirão como parametro para buscar os dados das cidades no banco.
            request.setAttribute("estadoSelecionado1",estado1);
            request.setAttribute("cidadeSelecionada1",cidade1);
            request.setAttribute("estadoSelecionado2",estado2);
            request.setAttribute("cidadeSelecionada2",cidade2);

            //Esta parte deve ser executada sempre, pois o servlet deve sempre mandar os os estados de volta a página
            //para que assim o usuário possa escolher outro.
            List<String> estados = dao.buscarNomesDosEstados();
            request.setAttribute("estados",estados);
            Cidade city1 = null;
            Cidade city2 = null;

            /*
             -----------------PREENCHENDO OS SELECTS-----------------------
             */

            //Estes dois if's servem para testar se algum estado foi selecionado, pois caso não seja selecioando nenhum
            //o usuário não deve ter nenhuma cidade disponível para escolha.
            if(!estado1.equals("Selecione um Estado")){
                List<String> cidades1 = dao.buscarNomeDasCidades(estado1);
                request.setAttribute("cidades1",cidades1);
                //Já este if interno vai testar se alguma cidade já foi selecionada. Se já, ele vai trazer
                //Os dados da cidade direto do banco para exibir na página jsp.
                if(!cidade1.equals("Selecione uma Cidade")){
                    city1 = dao.buscarCidade(cidade1,estado1);
                    if(cidade1 != null){
                        request.setAttribute("cidade1",city1);
                    }
                }
            }
            if(!estado2.equals("Selecione um Estado")){
                List<String> cidades2 = dao.buscarNomeDasCidades(estado2);
                request.setAttribute("cidades2",cidades2);
                if(!cidade2.equals("Selecione uma Cidade")){
                    city2 = dao.buscarCidade(cidade2,estado2);
                    if(cidade2 != null){
                        request.setAttribute("cidade2",city2);
                    }
                }
            }

            /*
            ----------------PREENCHENDO SVG-------------------------------
             */

            if(!cidade1.equals("Selecione uma cidade") && !cidade2.equals("Selecione uma cidade")){
                if(city1!=null && city2!=null){
                    String viewBox = dao.getViewBox(city1,city2);
                    request.setAttribute("viewBox",viewBox);
                    //List<Cidade> cidades = dao.preencherViewBox(city1,city2);
                    //if(cidades!=null){
                    //    request.setAttribute("cidades",cidades);
                    //}
                }
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
           Os comandos definidos no get serão exicutados sempre na primeria vez em que página for aberta.
           Eles farão com que os campos de estado e cidade já estejam preenchidos para o usuário escolher
           como bem desejar.
         */

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
