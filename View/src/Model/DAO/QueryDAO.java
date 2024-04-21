package Model.DAO;

import Model.Entities.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface QueryDAO {
    void insert(Query query);
    void update(LocalDateTime dateAndTimeOfConsultation, Integer idQuery);

    Query findById(Integer idQuery);
    List<Query> findAll();
}
