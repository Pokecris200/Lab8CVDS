package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	
	public ItemRentado load (int ir_id);
	
	public long valorMultaRetraso(int itemId);

}
