package thread.issue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import utils.CreateFileUtil;
import jdk.internal.dynalink.beans.StaticClass;

/**
 * 有四个线程1、2、3、4。线程1的功能就是输出A，线程2的功能就是输出B，以此类推......... 
 * 现在有四个文件file1,file2,file3, file4。初始都为空。 
	现要让四个文件呈如下格式： 
	file1：A B C D A B.... 
	file2：B C D A B C.... 
	file3：C D A B C D.... 
	file4：D A B C D A.... 
 * @author cheny
 *
 */
public class PrintLetter {
	
	public static String filePath = "c:/java/PrintLetter";
	public static int currentNum = 2;
	public static void main(String[] args) {
		try {
//			File dir = new File(filePath);
//			if (!dir.exists()) {
//				dir.mkdirs();
//			}
//			File file = new File(dir,"file"+currentNum+".txt");
//			if (!file.exists()) {
//				file.createNewFile();
//			}
			
			boolean b = CreateFileUtil.createFile(filePath+"file"+currentNum+".txt");
			File dir = new File(filePath);
			File file = new File(dir,"file"+currentNum+".txt");
			FileWriter writer = new FileWriter(file);
			writer.write("A B C D");
			writer.flush();
			
			
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
