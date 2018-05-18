package br.edu.utfpr.dv.sireata.dao.algorithms;

import br.edu.utfpr.dv.sireata.model.DAOEntity;
import java.util.Set;
import java.sql.SQLException;

public interface BuscarIdDAO {
    
    public Set<? extends DAOEntity> buscarPorId(int id) throws SQLException;
    
    
}
