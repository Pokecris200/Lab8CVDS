package edu.eci.cvds.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class MyBATISItemRentado implements ItemRentadoDAO{

	@Inject
	private ItemMapper it;
	
	@Inject
	private ItemRentadoMapper ir;

	
	@Override
	public ItemRentado load(int ir_id) throws PersistenceException{
		// TODO Auto-generated method stub
		try{
			return ir.consultarItemRentado(ir_id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("ItemRentado no encontrado: "+ir_id,e);
        }
		
	}
	
	@Override
	public List<ItemRentado> loadItemClientes(long idcliente) throws PersistenceException{
		// TODO Auto-generated method stub
		try{
			return ir.loadItemClientes(idcliente);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("El cliente " + idcliente + " no ha rentado ningun item.",e);
        }
	}
	
	@Override
	public int valorMultaRetraso(int itemId) throws PersistenceException{
		// TODO Auto-generated method stub
		
		ItemRentado itemR = load(itemId);
		int diasRetraso = LocalDate.now().getDayOfMonth() - itemR.getFechafinrenta().toLocalDate().getDayOfMonth();
		return (int) it.consultarItem(itemR.getItem().getId()).getTarifaxDia() * diasRetraso;
	}

	@Override
	public long consultarMultaRetraso(int iditem, Date fechaDevolucion) {
		// TODO Auto-generated method stub
		ItemRentado itemR = load(iditem);
		int diasRetrasados = fechaDevolucion.toLocalDate().getDayOfMonth() - itemR.getFechafinrenta().toLocalDate().getDayOfMonth();
		return it.consultarItem(itemR.getItem().getId()).getTarifaxDia() * diasRetrasados;
	}
}
