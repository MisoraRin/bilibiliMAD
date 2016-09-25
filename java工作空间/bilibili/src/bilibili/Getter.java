package bilibili;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.CharBuffer;
import java.util.ArrayList;

public class Getter {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
//		String url="http://www.bilibili.com/video/douga-mad-1.html#!page=6600";
		Stopwatch watch=new Stopwatch();
		for(int page=4373;page>=1;page--){
			String url="http://api.bilibili.com/archive_rank/getarchiverankbypartion?callback=jQuery172025708023750767595_1473570656754&type=jsonp&tid=24&pn="
					+ page
					+ "&original=1&_=1473570665706";
//			String url="http://www.bilibili.com/video/";
//			System.out.print(URLTest2.getHtml("http://www.baidu.com/"));
			String sour=URLTest2.getHtml(url);
			sour=decode(sour);
			System.out.print("第"+page);
//			ArrayList<String> strs= test.getStrings(sour, "\\{\"aid\"(.*?).jpg\"\\}");
			ArrayList<String> strs= test.getBS(sour, "\\{\"aid\"(.*?).jpg\"\\}");
			for (String s : strs){
//	            System.out.println(s);
	            StringBuffer i=new StringBuffer();
	            i.append(s);
	            dump(new StringReader(i.toString()),new FileWriter("C:\\Users\\ZYD\\Desktop\\bilibili.txt",true));
	        }
		}//这里跳出循环
		System.out.print(watch.elapsedTime());
		

	}
	public static void dump(Reader src,Writer dest){
		try(Reader input=new BufferedReader(src);Writer output=new BufferedWriter(dest)){
			char[] data=new char[1024];
			int length;
			while((length=input.read(data))!=-1){
				output.write(data, 0, length);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static String decode(String unicodeStr) {  
	    if (unicodeStr == null) {  
	        return null;  
	    }  
	    StringBuffer retBuf = new StringBuffer();  
	    int maxLoop = unicodeStr.length();  
	    for (int i = 0; i < maxLoop; i++) {  
	        if (unicodeStr.charAt(i) == '\\') {  
	            if ((i < maxLoop - 5)  
	                    && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr  
	                            .charAt(i + 1) == 'U')))  
	                try {  
	                    retBuf.append((char) Integer.parseInt(  
	                            unicodeStr.substring(i + 2, i + 6), 16));  
	                    i += 5;  
	                } catch (NumberFormatException localNumberFormatException) {  
	                    retBuf.append(unicodeStr.charAt(i));  
	                }  
	            else  
	                retBuf.append(unicodeStr.charAt(i));  
	        } else {  
	            retBuf.append(unicodeStr.charAt(i));  
	        }  
	    }  
	    return retBuf.toString().replace("\\", "");  
	}
}
