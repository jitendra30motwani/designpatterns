/**
 * 
 */
package designpattern.behavioral.command;

import java.util.Stack;

/**
 * @author 91978
 *
 */
public class CommandDesignPatternExample {

	/**Command Design pattern is a behavioral design pattern that turns request into a stand-alone object that contains all information about a request. 
	 * This transformation lets you pass a requests as a method arguments, delay, queue a request's execution and support undo-able operations.
	 * 
	 *  1. Provides Abstraction
	 *  2. Provides undo/re-do
	 *  3. Code Maintenance 
	 *  
	 *  UML -> Client -> Invoker -> Command -> Receiver
	 *  
	 */
	public CommandDesignPatternExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AirConditionerReceiver airConditionerReceiver = new AirConditionerReceiver(); 
		
		RemoteControlInvoker i1 = new RemoteControlInvoker();
		
		i1.setCommand(new TurnOnCommandAirConditioner(airConditionerReceiver));
		
		i1.pressButton();
		
		i1.setCommand(new TurnOffCommandAirConditioner(airConditionerReceiver));
		
		i1.pressButton();
		
		i1.undo();
		
		i1.undo();
		
		i1.redo();
		
		i1.redo();
		
		System.out.println(i1.commands.size());

	}

}

class AirConditionerReceiver{
	
	boolean isOn;
	int temp;
	
	public void turnOn() {
		this.isOn = true;
		System.out.println("Turn On AC");
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
		System.out.println("Set the temp to "+temp);
	}
	
	public void turnOff() {
		this.isOn = false;
		System.out.println("Turn Off AC");
	}
	
}

interface ICommand{
	
	void execute();
	void undo();
	
	
} 

class TurnOnCommandAirConditioner implements ICommand{

	AirConditionerReceiver air;
	
	public TurnOnCommandAirConditioner(AirConditionerReceiver air) {
		super();
		this.air = air;
	}

	@Override
	public void execute() {
		air.turnOn();
	}
	
	public void undo() {
		air.turnOff();
	}

	
}

class TurnOffCommandAirConditioner implements ICommand{

	AirConditionerReceiver air;
	
	public TurnOffCommandAirConditioner(AirConditionerReceiver air) {
		super();
		this.air = air;
	}

	@Override
	public void execute() {
		this.air.turnOff();
	}
	
	public void undo() {
		this.air.turnOn();
	}
	
}

class RemoteControlInvoker{
	
	ICommand command;
	
	Stack<ICommand> commands = new Stack<>();

	public RemoteControlInvoker() {

	}
	
	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}


	public void pressButton() {
		this.commands.push(command);
		this.command.execute();
	}
	
	public void undo() {
		if(!this.commands.isEmpty()) {
			command = commands.pop();
			command.undo();
		}
	}
	
	public void redo() {
		pressButton();
	}
	
}