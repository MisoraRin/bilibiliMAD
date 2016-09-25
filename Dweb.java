package bilibili;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Dweb {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO 自动生成的方法存根
		URL u=new URL("http://www.bilibili.com/video/douga-mad-1.html#!page=6600");
		dump(u.openStream(),new FileOutputStream("C:\\Users\\ZYD\\Desktop\\web.html"));
	}
	static void dump(InputStream src,OutputStream dest){
		try(InputStream input=src;OutputStream output=dest){
			byte[] data=new byte[1024];
			int length;
			while((length=input.read(data))!=-1){
				output.write(data, 0, length);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
