/**
 * 
 */
package designpattern.structural.composite.filesystem;

/**
 * @author 91978
 *
 */
public class File implements FileSystem {
	
	private String fileName;
	
	public File(String fileName) {
		
		this.fileName = fileName;
		
	}
	
	public void ls() {
		
		System.out.println("File Name: "+this.fileName);
		
	}
	
}
