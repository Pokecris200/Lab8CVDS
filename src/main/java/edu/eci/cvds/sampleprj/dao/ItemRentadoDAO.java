package edu.eci.cvds.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	
	public ItemRentado load(int ir_id);
	
	public List<ItemRentado> loadItemClientes(long idcliente);
	
	public int valorMultaRetraso(int itemId);
	
	public long consultarMultaRetraso(int iditem, Date fechaDevolucion);

}
