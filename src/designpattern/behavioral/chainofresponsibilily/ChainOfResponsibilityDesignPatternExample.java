/**
 * 
 */
package designpattern.behavioral.chainofresponsibilily;

/**
 * 
 * Chain of responsibility is a behavioral design pattern that lets you pass a request through a chain of handlers. 
 * Upon receiving a request, a handler either can process a request or pass it to next handler in chain. 
 * 
 * @author 91978
 *
 */
public class ChainOfResponsibilityDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		
		logProcessor.log(logProcessor.ERROR_LEVEL, "Exception Occurs");
		logProcessor.log(logProcessor.DEBUG_LEVEL, "Needs to Debug");
		logProcessor.log(logProcessor.INFO_LEVEL, "Info provided");
		
		logProcessor.log(null, "Nothing Occurs");
		
	}

}

abstract class LogProcessor{
	
	private LogProcessor nextLogProcessor;
	
	public String INFO_LEVEL="INFO";
	
	public String DEBUG_LEVEL="DEBUG";
	
	public String ERROR_LEVEL="ERROR";
	
	public LogProcessor(LogProcessor logProcessor) {
		
		this.nextLogProcessor = logProcessor;
		
	}
	
	public void log(String level, String msg) {
		if(this.nextLogProcessor!=null) {
			nextLogProcessor.log(level,msg);
		}
	}
	
}

class InfoLogProcessor extends LogProcessor{

	
	public InfoLogProcessor(LogProcessor logProcessor) {
		super(logProcessor);
	}

	@Override
	public void log(String level,String msg) {
		if(this.INFO_LEVEL.equals(level)) {
			System.out.println("Info Handler: "+msg);
		}else {
			super.log(level, msg);
		}
	}
	
}

class DebugLogProcessor extends LogProcessor{

	
	public DebugLogProcessor(LogProcessor logProcessor) {
		super(logProcessor);
	}

	@Override
	public void log(String level,String msg) {
		if(this.DEBUG_LEVEL.equals(level)) {
			System.out.println("Debug Handler: "+msg);
		}else {
			super.log(level, msg);
		}
	}
	
}

class ErrorLogProcessor extends LogProcessor{

	
	public ErrorLogProcessor(LogProcessor logProcessor) {
		super(logProcessor);
	}

	@Override
	public void log(String level,String msg) {
		if(this.ERROR_LEVEL.equals(level)) {
			System.out.println("Error Handler: "+msg);
		}else {
			super.log(level, msg);
		}
	}
	
}
