/**
 * 
 */
package designpattern.structural.composite.filesystem;

/**
 * @author 91978
 *
 */
public class FileSystemUsage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Directory dir1 = new Directory("Movie");
		Directory dir2 = new Directory("Comedy");
		Directory dir3 = new Directory("Action");
		
		dir1.add(dir2);
		dir1.add(dir3);
		
		FileSystem file1 = new File("Hulchul");
		FileSystem file2 = new File("Malamaal Weekly");
		
		dir2.add(file1);
		dir2.add(file2);
		
		FileSystem file3 = new File("KGF-C1");
		FileSystem file4 = new File("KGF-C2");
		
		dir3.add(file3);
		dir3.add(file4);
		
		file1.ls();
		
	}

}
