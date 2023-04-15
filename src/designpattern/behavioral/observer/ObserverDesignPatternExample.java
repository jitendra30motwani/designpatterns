/**
 * 
 */
package designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 91978
 *
 *Observer is a behavioral design pattern that lets you define subscription mechanism to notify 
 *multiple objects about the events that happen to the object they are observing.
 *
 *LLD for notify when stock available
 *
 */
public class ObserverDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StockObservable stockObservable = new IphoneStockObservable();
		
		/*NofificationObserver observer1 = new NotifiationObserverStrategy(new EmailNotificationObserver("abc@gmail.com", stockObservable));
		NofificationObserver observer2 = new NotifiationObserverStrategy(new SMSNotificationObserver("123", stockObservable));*/
		
		NofificationObserver observer1 = new EmailNotificationObserver("abc@gmail.com", stockObservable);
		NofificationObserver observer2 = new SMSNotificationObserver("123", stockObservable);
		
		stockObservable.addObserver(observer1);
		stockObservable.addObserver(observer2);
		
		stockObservable.setStockData(10);
		stockObservable.setStockData(0);
		stockObservable.setStockData(10);
		
	}

}

interface StockObservable{
	
	void addObserver(NofificationObserver nofificationObserver);
	void removeObserver(NofificationObserver nofificationObserver);
	void notifySubscribers();
	void setStockData(int newStock);
	int getStockData();
	
}

interface NofificationObserver{
	
	void update();
	
}


class IphoneStockObservable implements StockObservable{
	
	List<NofificationObserver> subsribers;
	
	int stock;
	
	public IphoneStockObservable() {
		this.subsribers = new ArrayList<>();
		this.stock = 0;
	}
	
	@Override
	public void addObserver(NofificationObserver nofificationObserver) {
		
		subsribers.add(nofificationObserver);
	}

	@Override
	public void removeObserver(NofificationObserver nofificationObserver) {
		
		subsribers.remove(nofificationObserver);
		
	}

	@Override
	public void notifySubscribers() {
		
		for(NofificationObserver nofificationObserver: subsribers) {
			nofificationObserver.update();
		}
		
	}

	@Override
	public void setStockData(int newStock) {
		
		if(stock==0) {
			this.stock=newStock;
			notifySubscribers();
		}else {
			this.stock=newStock;
		}
		
		
	}

	@Override
	public int getStockData() {
		
		return this.stock;

	}
	
	
	
}

/*class NotifiationObserverStrategy implements NofificationObserver{
	
	private NofificationObserver notification;
	
	public NotifiationObserverStrategy(NofificationObserver notification) {
		this.notification = notification;
	}
	
	@Override
	public void update() {
		
		this.notification.update();
		
	}
	
}

class EmailNotificationObserver implements NofificationObserver{
	
	private String email;
	private StockObservable stockObservable;
	
	public EmailNotificationObserver(String email, StockObservable stockObservable) {
		this.email = email;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		System.out.println("Curent Stock: "+this.stockObservable.getStockData());
		sendEmail();
	}
	
	public void sendEmail() {
		
		System.out.println("Email Sent to: "+email);
		
	}
	
}

class SMSNotificationObserver implements NofificationObserver{

	private String mobNo;
	private StockObservable stockObservable;
	
	public SMSNotificationObserver(String mobNo, StockObservable stockObservable) {
		this.mobNo = mobNo;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		System.out.println("Curent Stock: "+this.stockObservable.getStockData());
		sendSMS();
	}
	
	public void sendSMS() {
		
		System.out.println("SMS Sent to: "+mobNo);
		
	}
	
}*/


class EmailNotificationObserver implements NofificationObserver{
	
	private String email;
	private StockObservable stockObservable;
	
	public EmailNotificationObserver(String email, StockObservable stockObservable) {
		this.email = email;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		System.out.println("Curent Stock: "+this.stockObservable.getStockData());
		sendEmail();
	}
	
	public void sendEmail() {
		
		System.out.println("Email Sent to: "+email);
		
	}
	
}

class SMSNotificationObserver implements NofificationObserver{

	private String mobNo;
	private StockObservable stockObservable;
	
	public SMSNotificationObserver(String mobNo, StockObservable stockObservable) {
		this.mobNo = mobNo;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		System.out.println("Curent Stock: "+this.stockObservable.getStockData());
		sendSMS();
	}
	
	public void sendSMS() {
		
		System.out.println("SMS Sent to: "+mobNo);
		
	}
	
}