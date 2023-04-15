/**
 * 
 */
package designpattern.structural.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 91978
 *
 */
public class Directory implements FileSystem {
	
	private String dirName;
	
	private List<FileSystem> list; 
	
	public Directory(String dirName) {
		
		this.dirName = dirName;
		this.list = new ArrayList<>();
		
	}
	
	public void add(FileSystem fs) {
		
		this.list.add(fs);
		
	}
	
	public void ls() {
		
		System.out.println("Directory Name: "+this.dirName);
		
		for(FileSystem fs : list) {
			
			fs.ls();
		}
		
	}
	
}
