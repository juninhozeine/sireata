
package br.edu.utfpr.dv.sireata.algorithms.anexo;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarIdDAO;
import br.edu.utfpr.dv.sireata.model.DAOEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


public class AnexoBuscarIdDAO implements BuscarIdDAO{

    @Override
    public Set<? extends DAOEntity> buscarPorId(int id) throws SQLException {
    Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
                AnexoCarregarObjtDAO anexoCarregarObjeto;
                anexoCarregarObjeto = new AnexoCarregarObjtDAO();
		
		try{
			conn = ConnectionDAO.getInstance().getConnection();
			stmt = conn.prepareStatement("SELECT anexos.* FROM anexos " +
				"WHERE idAnexo = ?");
		
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				return (Set<? extends DAOEntity>) anexoCarregarObjeto.carregarObjeto(rs);
			}else{
				return null;
			}
		}finally{
			if((rs != null) && !rs.isClosed())
				rs.close();
			if((stmt != null) && !stmt.isClosed())
				stmt.close();
			if((conn != null) && !conn.isClosed())
				conn.close();
		}
    
    }
}
