package br.edu.utfpr.dv.sireata.bo;

import br.edu.utfpr.dv.sireata.algorithms.anexo.AnexoBuscarIdDAO;
import br.edu.utfpr.dv.sireata.algorithms.anexo.AnexoCarregarObjtDAO;
import br.edu.utfpr.dv.sireata.algorithms.anexo.AnexoExcluirDAO;
import br.edu.utfpr.dv.sireata.algorithms.anexo.AnexoListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.algorithms.anexo.AnexoSalvarDAO;
import java.util.List;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoBO {
    private AnexoDAO dao;
    
    public AnexoBO(){
        dao = new AnexoDAO(
                new AnexoBuscarIdDAO(),
                new AnexoCarregarObjtDAO(),
                new AnexoExcluirDAO(),
                new AnexoListarPorAtaDAO(),
                new AnexoSalvarDAO()
        );

    }

	public Anexo buscarPorId(int id) throws Exception{
		return (Anexo) dao.buscar(id);
	}
	
	public List<Anexo> listarPorAta(int idAta) throws Exception{
		return dao.listar(idAta);
	}
	
	public int salvar(Anexo anexo) throws Exception{
		return dao.salvar(anexo);
	}
	
	public void excluir(int id) throws Exception{
		dao.excluir(id);
	}
	
}
