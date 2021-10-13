package edu.eci.cvds.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

public class MyBATISItemRentado implements ItemRentadoDAO{

	@Inject
	private ItemMapper it;
	
	@Inject
	private ItemRentadoMapper ir;

	
	@Override
	public ItemRentado load(int ir_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public long valorMultaRetraso(int itemId) throws PersistenceException{
		// TODO Auto-generated method stub
		try{
			
            Item item = it.consultarItem(itemId);
            
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Item no encontrado: "+itemId,e);
        }
		return 0;
	}

	

}
