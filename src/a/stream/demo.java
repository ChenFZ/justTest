package a.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class demo {
	public static void main(String[] args) {
		copyByteStream();
		copyCharStream();
	}

	private static void copyCharStream() {
		try {
			FileReader reader = new FileReader(new File("C:/Users/陈方正/Desktop/测试/bulu.txt"));
			FileWriter writer = new FileWriter(new File("C:/Users/陈方正/Desktop/测试/copyCharStream.txt"));
			BufferedReader bufferedReader = new BufferedReader(reader);
			String len;
			while((len=bufferedReader.readLine())!=null){
				writer.write(len);
				System.out.println(len);
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void copyByteStream() {
		try {
			FileInputStream in = new FileInputStream(new File("C:/Users/陈方正/Desktop/测试/bulu.txt"));
			FileOutputStream out = new FileOutputStream(new File("C:/Users/陈方正/Desktop/测试/copyByteStream.txt"));
			byte[] b = new byte[1024];
			int i;
			while ((i = in.read(b)) > 0) {
				out.write(b, 0, i);
				out.flush();
			}
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
