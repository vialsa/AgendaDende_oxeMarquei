package Controle;

import Modelo.DAO.impl.SolicitacaoDAOJDBC;
import Modelo.Entidades.Consulta;
import Modelo.Entidades.Solicitacao;

public class SolicitationController {
    public Solicitacao cadastrarSolicitacao(Solicitacao solicitation) {
        try {
            SolicitacaoDAOJDBC solicitationDAOJDBC = new SolicitacaoDAOJDBC();
            Solicitacao solicitacaoInserida = solicitationDAOJDBC.insert(solicitation);
            return solicitacaoInserida;
 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
