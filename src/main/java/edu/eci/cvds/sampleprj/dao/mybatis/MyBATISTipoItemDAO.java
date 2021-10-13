package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

public class MyBATISTipoItemDAO implements TipoItemDAO{
	
	@Inject
    private TipoItemMapper tipoItem;

	@Override
	public void save(TipoItem ti) throws PersistenceException {
		
		try{
            tipoItem.addTipoItem(ti.getDescripcion());
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el item "+ti.toString(),e);
        } 
		
	}

	@Override
	public TipoItem load(int id) throws PersistenceException {

		try{
            return tipoItem.getTipoItem(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item "+id,e);
        }
    }

	@Override
	public List<TipoItem> load() throws PersistenceException {
		// TODO Auto-generated method stub
		return tipoItem.getTiposItems();
	}

}
