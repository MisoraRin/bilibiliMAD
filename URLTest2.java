package bilibili;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;


public class URLTest2 {	
	public static void main(String args[]) throws Exception {		
		try {			
			URL url = new URL("http://www.bilibili.com/video/douga-mad-1.html#!page="+"6600");			
			InputStream in =(InputStream) url.openStream();			
			InputStreamReader isr = new InputStreamReader(in);		
			BufferedReader bufr = new BufferedReader(isr);		
			String str;			
			while ((str = bufr.readLine()) != null) {		
				System.out.println(str);			
				}		
			bufr.close();		
			isr.close();		
			in.close();	
		} 
		catch (Exception e) {		
			e.printStackTrace();		}

	}
	 public static String getHtml(String urlString) {  
		  try {
		   StringBuffer html = new StringBuffer();  
		   java.net.URL url = new java.net.URL(urlString);  //根据 String 表示形式创建 URL 对象。
		   java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();// 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
		   java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream(),"UTF-8");//返回从此打开的连接读取的输入流。
		   java.io.BufferedReader br = new java.io.BufferedReader(isr);//创建一个使用默认大小输入缓冲区的缓冲字符输入流。
		   
		   String temp;
		   while ((temp = br.readLine()) != null) {  //按行读取输出流
		    if(!temp.trim().equals("")){
		     html.append(temp).append("\n");  //读完每行后换行
		    }
		   }
		    br.close();   //关闭
		    isr.close();  //关闭
		   return html.toString();   //返回此序列中数据的字符串表示形式。
		  } catch (Exception e) {
		   e.printStackTrace();
		   return null;
		  }
		 }
}