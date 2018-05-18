package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjtDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.model.DAOEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public abstract class FullDAO {
    
    protected BuscarIdDAO buscar;
    protected CarregarObjtDAO carregar;
    protected ExcluirDAO excluir;
    protected ListarPorAtaDAO listar;
    protected SalvarDAO salvar;

    public Set<? extends DAOEntity> buscar(int id) throws SQLException{
        return buscar.buscarPorId(id);
    }
    
    public DAOEntity carregarObjeto(ResultSet rs) throws SQLException {
        return carregar.carregarObjeto(rs);
    }
    
    public List<Anexo> listar(int idAta) throws SQLException{
        return listar.listarPorAta(idAta);
    
    /**
     *
     * @param newEntity
     * @return
     * @throws SQLException
     */
    public int salvar(DAOEntity newEntity) throws SQLException{
        return salvar.salvar(newEntity);
    }
    
    public void excluir(int value) throws SQLException {
        excluir.excluir(value);
    }

}
