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
		   java.net.URL url = new java.net.URL(urlString);  //���� String ��ʾ��ʽ���� URL ����
		   java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();// ����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶�������ӡ�
		   java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream(),"UTF-8");//���شӴ˴򿪵����Ӷ�ȡ����������
		   java.io.BufferedReader br = new java.io.BufferedReader(isr);//����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ���������
		   
		   String temp;
		   while ((temp = br.readLine()) != null) {  //���ж�ȡ�����
		    if(!temp.trim().equals("")){
		     html.append(temp).append("\n");  //����ÿ�к���
		    }
		   }
		    br.close();   //�ر�
		    isr.close();  //�ر�
		   return html.toString();   //���ش����������ݵ��ַ�����ʾ��ʽ��
		  } catch (Exception e) {
		   e.printStackTrace();
		   return null;
		  }
		 }
}