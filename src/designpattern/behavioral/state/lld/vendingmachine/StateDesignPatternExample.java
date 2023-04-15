/**
 * 
 */
package designpattern.behavioral.state.lld.vendingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 91978
 *
 *
 *Requirements:
 *
 *It should accept coins of 1/5/10/25
 *User should be able to select item
 *User should be able to cancel and get the refund
 *It should dispense item and change if any
 *It stores the item inventory - Coke/Pepsi/Soda/Water
 *
 */
public class StateDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Inventory{
	
	private ItemShelf itemShelf[];
	
	public Inventory(int size) {
		
		itemShelf = new ItemShelf[size];
	}
	
}

class VendingMachine{
	
	private State state;
	private Inventory inventory;
	private List<Coin> coins;
	
	public VendingMachine() {
		
		this.state = new IdleState();
		this.inventory = new Inventory(10);
		coins = new ArrayList<>();
		
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}
	
	
	
	
}

enum Coin{
	
	PENNY(1),
	NICKLE(5),
	BRONZE(10),
	COPPER(25);
	
	public int value;
	
	Coin(int value) {
		this.value = value;
	}
	
}

enum ItemType{
	
	COKE, PEPSI,WATER,SODA; 
	
}

class Item{
	
	private ItemType itemType;
	private int price;
	
	public Item(ItemType itemType, int price) {
		
		this.itemType = itemType;
		this.price = price;
		
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

class ItemShelf{
	
	private Item item;
	private int code;
	private boolean soldOut;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isSoldOut() {
		return soldOut;
	}
	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}
	
	
	
	
}

interface State{
	
	
	void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception;
	void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
	void pressSelectItemButton(VendingMachine vendingMachine) throws Exception;
	void chooseItem(VendingMachine vendingMachine, int code) throws Exception;
	int change(VendingMachine vendingMachine, int change) throws Exception;
	List<Coin> refund(VendingMachine vendingMachine) throws Exception;
	void cancel(VendingMachine vendingMachine) throws Exception;
	void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception;
	
}

class IdleState implements State{

	@Override
	public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
		
		vendingMachine.setState(new HasMoneyState());
		
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressSelectItemButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseItem(VendingMachine vendingMachine, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int change(VendingMachine vendingMachine, int change) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Coin> refund(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

class HasMoneyState implements State{

	@Override
	public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressSelectItemButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseItem(VendingMachine vendingMachine, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int change(VendingMachine vendingMachine, int change) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Coin> refund(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}

class SelectionState implements State{

	@Override
	public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressSelectItemButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseItem(VendingMachine vendingMachine, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int change(VendingMachine vendingMachine, int change) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Coin> refund(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}


class DispenseState implements State{

	@Override
	public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressSelectItemButton(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseItem(VendingMachine vendingMachine, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int change(VendingMachine vendingMachine, int change) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Coin> refund(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(VendingMachine vendingMachine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}


