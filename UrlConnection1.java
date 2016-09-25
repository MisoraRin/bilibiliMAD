package bilibili;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class UrlConnection1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.bilibili.com/video/douga-mad-1.html");

		URLConnection conn = url.openConnection();//获得UrlConnection 连接对象

		InputStream is = conn.getInputStream();//获得输入流
		// isr = new InputStreamReader(System.in);//system.in标准系统输入
		BufferedReader br = new BufferedReader(new InputStreamReader(is));//buffered表示缓冲类
		String str;
		while(null!=(str = br.readLine())){
			System.out.println(str);
		}
		br.close();
//		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream("D:\\infoq1.txt");
		byte[] buffer = new byte[2048];
		int length = 0;
		while(-1 !=(length=is.read(buffer,0,buffer.length))){
			os.write(buffer,0,length);
			System.out.println(is.read());
		}
		System.out.println();
		is.close();
		os.close();

	}
}
