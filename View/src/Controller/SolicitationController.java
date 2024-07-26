package Controller;

import Model.DAO.impl.SolicitationDAOJDBC;
import Model.Entities.Solicitation;

public class SolicitationController {
    public boolean cadastrarSolicitacao(Solicitation solicitation) {
        try {
            SolicitationDAOJDBC solicitationDAOJDBC = new SolicitationDAOJDBC();
            solicitationDAOJDBC.insert(solicitation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
