package vendingmachine.dao;

import java.util.List;

import vendingmachine.dto.Item;

public interface VendingMachineDao {

	Item additem(int id, Item item);
	
	Item removeItem(int id);
	
	Item getItem(int id);
	
	Item updateItemInventory(int id);
	
	List<Item> getAllItems();
	
}
