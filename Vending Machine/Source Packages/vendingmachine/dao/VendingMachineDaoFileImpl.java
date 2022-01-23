package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import vendingmachine.dto.Item;

public class VendingMachineDaoFileImpl implements VendingMachineDao {
	
	private static String INVENTORY;
	private static final String DELIMETER = "::";
	private Map<Integer, Item> items = new HashMap<>();
	

	@Override
	public Item additem(int id, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item removeItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item updateItemInventory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void loadInventory() throws VendingMachineDaoPersistenceException {
		Scanner scan;
		
		try {
			scan = new Scanner(new BufferedReader(new FileReader(INVENTORY)));
		}catch(FileNotFoundException e) {
			throw new VendingMachineDaoPersistenceException ("Could not load inventory", e);
		}
		Item itemAsObj;
		while(scan.hasNextLine()) {
			itemAsObj = itemFromTextFile(scan.nextLine());
			items.put(itemAsObj.getId(), itemAsObj);
		}
		
		scan.close();
	}
	
	private Item itemFromTextFile(String itemAsText) {
		String [] itemAsTokens = itemAsText.split(DELIMETER);
		Item itemAsObj;
		String name;
		BigDecimal price;
		int quantity;
		int id;
		try {
			id = Integer.parseInt(itemAsTokens[0]);
			name = itemAsTokens[1];
			price = new BigDecimal(itemAsTokens[2]);
			quantity = Integer.parseInt(itemAsTokens[3]);
			itemAsObj = new Item(id, name, price, quantity);
			return itemAsObj;
		}catch(NumberFormatException e) {
			System.out.println("Invalid Item attributes found in the inventory");
		}
		return null;

	}
	
	private String itemToTextFile(Item item) {
		String itemAsText = item.getId() + DELIMETER;
		itemAsText += item.getName() + DELIMETER;
		itemAsText += item.getPrice().toString() + DELIMETER;
		itemAsText += item.getQuantity();
		
		return itemAsText;
	}

}
