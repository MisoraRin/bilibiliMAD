package bilibili;


import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) {
		String t="{\"aid\":6266745,\"tid\":24,\"tname\":\"MAD��AMV\",\"copyright\":1,\"pic\":\"http://i0.hdslb.com/bfs/archive/4b3077da2eb5b91fedabaab3c3ea7b2339629b16.jpg\",\"title\":\"Լ�����ս��һ��������MV��4�ְ������棩\",\"access\":10000,\"attribute\":540675,\"duration\":272,\"tags\":[\"Լ�����ս��һ��\",\"���ʿ��\",\"�������\",\"ʱ�����\",\"������\",\"ҹ����ʮ��\",\"�һ��ֽ\"],\"rights\":{\"bp\":0,\"elec\":0,\"download\":0,\"movie\":0,\"pay\":0,\"hd5\":0},\"stat\":{\"view\":\"--\",\"danmaku\":17,\"reply\":14,\"favorite\":30,\"coin\":10,\"share\":3,\"now_rank\":0,\"his_rank\":0},\"play\":\"--\",\"favorites\":30,\"video_review\":17,\"create\":\"2016-09-13 22:24\",\"description\":\"BGM��sweet ARMS�����ǩ`�� �� �饤��nnԼսMV��֮ǰ���˸�ʱ�������������MV��վ���Ƕ�˵����������ȷʵ����ʱ��û�е��ԣ�ֻ�����ֻ����������Դ��1080P�ģ�������Ҳ��֤���壬��ҿ��Է���ʳ�á�\",\"mid\":27798014,\"author\":\"ҶӰ����\",\"face\":\"http://i2.hdslb.com/bfs/face/a401d801ab300241d1c5acc8aff158be93265789.jpg\"}";
		bt(t);
		
		//	        getStrings(); //��������ʽ��ȡָ���ַ��������е�ָ������
		/*System.out.println("********************");
		replace(); //��������ʽ�滻�ַ�������
		System.out.println("********************");
		strSplit(); //ʹ��������ʽ�и��ַ���
		System.out.println("********************");
		strMatch(); //�ַ���ƥ��*/
	}

	private static void strMatch() {
		String phone = "13539770000";
		//���phone�Ƿ��Ǻϸ���ֻ���(��׼:1��ͷ���ڶ�λΪ3,5,8����9λΪ��������)
		System.out.println(phone + ":" + phone.matches("1[358][0-9]{9,9}")); //true    

		String str = "abcd12345efghijklmn";
		//���str�м��Ƿ����12345
		System.out.println(str + ":" + str.matches("\\w+12345\\w+")); //true
		System.out.println(str + ":" + str.matches("\\w+123456\\w+")); //false
	}

	private static void strSplit() {
		String str = "asfasf.sdfsaf.sdfsdfas.asdfasfdasfd.wrqwrwqer.asfsafasf.safgfdgdsg";
		String[] strs = str.split("\\.");
		for (String s : strs){
			System.out.println(s);
		}        
	}

	/**
	 * ����ƥ���м���ַ�
	 * @param pi Ҫ������ַ���
	 * @param z ������ʽ
	 * @return
	 */
	public static ArrayList<String> getStrings(String pi,String z) {
		String str=pi;
		Pattern p = Pattern.compile(z);
		Matcher m = p.matcher(str);
		ArrayList<String> strs = new ArrayList<String>();
		while (m.find()) {
			strs.add(m.group(0));            
		} 

		return strs;
	}
	/**
	 * ���ڴ���bilibili��Ƶ�ַ���
	 * @param pi
	 * @param z
	 * @return
	 */
	public static ArrayList<String> getBS(String pi,String z) {
		String str=pi;
		Pattern p = Pattern.compile(z);
		Matcher m = p.matcher(str);
		ArrayList<String> strs = new ArrayList<String>();
		while (m.find()) {
			
			strs.add(bt(m.group(0)));            
		} 

		return strs;
	}

	private static void replace() {
		String str = "asfas5fsaf5s4fs6af.sdaf.asf.wqre.qwr.fdsf.asf.asf.asf";
		//���ַ����е�.�滻��_����Ϊ.�������ַ�������Ҫ��\.������Ϊ\�������ַ�������Ҫ��\\.�����.
		str = str.replaceAll("\\.", "_");
		System.out.println(str);        
	}
	private static String bt(String s){
//		String t="{\"aid\":6266745,\"tid\":24,\"tname\":\"MAD��AMV\",\"copyright\":1,\"pic\":\"http://i0.hdslb.com/bfs/archive/4b3077da2eb5b91fedabaab3c3ea7b2339629b16.jpg\",\"title\":\"Լ�����ս��һ��������MV��4�ְ������棩\",\"access\":10000,\"attribute\":540675,\"duration\":272,\"tags\":[\"Լ�����ս��һ��\",\"���ʿ��\",\"�������\",\"ʱ�����\",\"������\",\"ҹ����ʮ��\",\"�һ��ֽ\"],\"rights\":{\"bp\":0,\"elec\":0,\"download\":0,\"movie\":0,\"pay\":0,\"hd5\":0},\"stat\":{\"view\":\"--\",\"danmaku\":17,\"reply\":14,\"favorite\":30,\"coin\":10,\"share\":3,\"now_rank\":0,\"his_rank\":0},\"play\":\"--\",\"favorites\":30,\"video_review\":17,\"create\":\"2016-09-13 22:24\",\"description\":\"BGM��sweet ARMS�����ǩ`�� �� �饤��nnԼսMV��֮ǰ���˸�ʱ�������������MV��վ���Ƕ�˵����������ȷʵ����ʱ��û�е��ԣ�ֻ�����ֻ����������Դ��1080P�ģ�������Ҳ��֤���壬��ҿ��Է���ʳ�á�\",\"mid\":27798014,\"author\":\"ҶӰ����\",\"face\":\"http://i2.hdslb.com/bfs/face/a401d801ab300241d1c5acc8aff158be93265789.jpg\"}";
		
		Pattern p = Pattern.compile("\"aid\":"
				+ "(.*?)"
				+ ","
				+ "(.*?)"
				+ "\"pic\":\""
				+ "(.*?)"
				+ "\","
				+ "(.*?)"
				+ "\"title\":\"(.*?)\""
				+ "(.*?)"
				+ "\"view\":(.*?),"
				+ "\"danmaku\":(.*?),"
				+ "\"reply\":(.*?),"
				+ "\"favorite\":(.*?),"
				+ "\"coin\":(.*?),"
				+ "\"share\":(.*?),"
				+ "\"now_rank\":(.*?),"
				+ "(.*?)"
				+ "\"create\":\"(.*?)\","
				+ "(.*?)"
				+ "\"description\":\"(.*?)\","
				+ "(.*?)"
				+ "\"author\":\"(.*?)\",\"face\":\"(.*?)\"");
		Matcher m = p.matcher(s);
		String i="error";
		ArrayList<String> strs = new ArrayList<String>();
		while (m.find()) {// 1 av�ţ�					3 �������ӣ�		5 ���⣬				7���ţ�				8��Ļ��			9�ظ���		10�ղأ�		11Ӳ�ң�		12����			,15�ϴ�ʱ��,		17����		,19���ߣ�			20ͼƬ����
			i=m.group(1)+"|"+m.group(3)+"|"+m.group(5).replace("|", "��")+"|"+m.group(7)+"|"+m.group(8)+"|"+m.group(9)+"|"+m.group(10)+"|"+m.group(11)+"|"+m.group(12)+"|"+m.group(15)+"|"+m.group(17).replace("|", "��")+"|"+m.group(19).replace("|", "��")+"|"+m.group(20)+"\r\n";
		
			strs.add(i);            
		} 
		for (String z : strs){
//            System.out.println(z);
            return z;
        }
//		System.out.print(i);
		return i;

	}
}


