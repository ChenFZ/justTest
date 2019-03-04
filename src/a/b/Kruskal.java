package a.b;

import java.io.IOException;

import org.junit.Test;

/**
 * 很多情况下，在Windows进行操作时，直接使用cmd命令提示符会远比通过Java实现简便的多，
 * 所以我们可以通过使用Java调用cmd命令的方式来完成这一操作。
 * 
 * Java的Runtime.getRuntime().exec(commandStr)方法提供了调用执行cmd指令的实现。
 * 
 * @author chenfz
 *
 */
public class Kruskal {

	public static void main(String[] args) {
		deleteAllFiles("c:\\test");
	}

	@Test
	public static void deleteAllFiles(String path) {
		try {
			String cmd = "cmd /c del /s/q " + path + "\\*.*";
			Runtime.getRuntime().exec(cmd).waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
