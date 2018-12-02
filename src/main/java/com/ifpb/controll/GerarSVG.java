package com.ifpb.controll;

import com.ifpb.model.dao.CidadeDao;
import com.ifpb.model.dao.CidadeDaoImpl;
import com.ifpb.model.dao.DataException;
import com.ifpb.model.databese.ConnectionException;
import com.ifpb.model.domain.Cidade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerarSVG implements Command {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try {
            CidadeDao dao = new CidadeDaoImpl();

            Cidade cidade1 = dao.buscarCidade(request.getAttribute("cidadeSelecionada1").toString(),
                    request.getAttribute("estadoSelecionado1").toString());
            Cidade cidade2 = dao.buscarCidade(request.getAttribute("cidadeSelecionada2").toString(),
                    request.getAttribute("estadoSelecionado2").toString());
            if(cidade1 != null){
                request.setAttribute("cidade1",cidade1);
            }
            if(cidade2 != null){
                request.setAttribute("cidade2",cidade2);
            }
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
    }

}
