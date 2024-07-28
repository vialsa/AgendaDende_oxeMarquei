package Controle;

import Modelo.DAO.impl.SolicitacaoDAOJDBC;
import Modelo.Entidades.Solicitacao;

public class SolicitationController {
    public boolean cadastrarSolicitacao(Solicitacao solicitation) {
        try {
            SolicitacaoDAOJDBC solicitationDAOJDBC = new SolicitacaoDAOJDBC();
            solicitationDAOJDBC.insert(solicitation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
