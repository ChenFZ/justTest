package a.stream;

import java.io.*;
import java.util.Arrays;

public class demo {
	public static void main(String[] args) {
		String s = "hello_安卓";
		byte[] bytes = null;
		try {
			bytes = s.getBytes("gbk");
			new String(bytes,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		copyByteStream();
		copyCharStream();
	}

	private static void copyCharStream() {
		try {
			FileReader reader = new FileReader(new File("C:/Users/chenfz/Desktop/测试/bulu.txt"));
			File file = new File("C:/Users/chenfz/Desktop/测试/copyCharStream.txt");
			if (!file.exists()) file.createNewFile();
			FileWriter writer = new FileWriter(file);
			char[] chars = new char[1024];
			int len = 0;
			while ((len = reader.read(chars))>-1){
				writer.write(chars,0,len);
				System.out.println(chars);
			}
//			BufferedReader bufferedReader = new BufferedReader(reader);
//			String len;
//			while((len=bufferedReader.readLine())!=null){
//				writer.write(len);
//				System.out.println(len);
//			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void copyByteStream() {
		try {
			FileInputStream in = new FileInputStream(new File("C:/Users/chenfz/Desktop/测试/bulu.txt"));
			FileOutputStream out = new FileOutputStream(new File("C:/Users/chenfz/Desktop/测试/copyByteStream.txt"));
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
