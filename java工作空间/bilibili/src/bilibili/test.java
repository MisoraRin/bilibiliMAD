package bilibili;


import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) {
		String t="{\"aid\":6266745,\"tid\":24,\"tname\":\"MAD·AMV\",\"copyright\":1,\"pic\":\"http://i0.hdslb.com/bfs/archive/4b3077da2eb5b91fedabaab3c3ea7b2339629b16.jpg\",\"title\":\"约会大作战第一季主题曲MV（4分半完整版）\",\"access\":10000,\"attribute\":540675,\"duration\":272,\"tags\":[\"约会大作战第一季\",\"五河士道\",\"五河琴里\",\"时崎狂三\",\"四糸乃\",\"夜刀神十香\",\"鸢一折纸\"],\"rights\":{\"bp\":0,\"elec\":0,\"download\":0,\"movie\":0,\"pay\":0,\"hd5\":0},\"stat\":{\"view\":\"--\",\"danmaku\":17,\"reply\":14,\"favorite\":30,\"coin\":10,\"share\":3,\"now_rank\":0,\"his_rank\":0},\"play\":\"--\",\"favorites\":30,\"video_review\":17,\"create\":\"2016-09-13 22:24\",\"description\":\"BGM：sweet ARMS——デート ア ライブnn约战MV，之前出了个时崎狂三主题曲的MV，站友们都说画质渣。。确实，那时候没有电脑，只能拿手机做，这次资源是1080P的，做出来也保证高清，大家可以放心食用。\",\"mid\":27798014,\"author\":\"叶影先生\",\"face\":\"http://i2.hdslb.com/bfs/face/a401d801ab300241d1c5acc8aff158be93265789.jpg\"}";
		bt(t);
		
		//	        getStrings(); //用正则表达式获取指定字符串内容中的指定内容
		/*System.out.println("********************");
		replace(); //用正则表达式替换字符串内容
		System.out.println("********************");
		strSplit(); //使用正则表达式切割字符串
		System.out.println("********************");
		strMatch(); //字符串匹配*/
	}

	private static void strMatch() {
		String phone = "13539770000";
		//检查phone是否是合格的手机号(标准:1开头，第二位为3,5,8，后9位为任意数字)
		System.out.println(phone + ":" + phone.matches("1[358][0-9]{9,9}")); //true    

		String str = "abcd12345efghijklmn";
		//检查str中间是否包含12345
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
	 * 用于匹配中间的字符
	 * @param pi 要处理的字符串
	 * @param z 正则表达式
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
	 * 用于处理bilibili视频字符串
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
		//将字符串中的.替换成_，因为.是特殊字符，所以要用\.表达，又因为\是特殊字符，所以要用\\.来表达.
		str = str.replaceAll("\\.", "_");
		System.out.println(str);        
	}
	private static String bt(String s){
//		String t="{\"aid\":6266745,\"tid\":24,\"tname\":\"MAD·AMV\",\"copyright\":1,\"pic\":\"http://i0.hdslb.com/bfs/archive/4b3077da2eb5b91fedabaab3c3ea7b2339629b16.jpg\",\"title\":\"约会大作战第一季主题曲MV（4分半完整版）\",\"access\":10000,\"attribute\":540675,\"duration\":272,\"tags\":[\"约会大作战第一季\",\"五河士道\",\"五河琴里\",\"时崎狂三\",\"四糸乃\",\"夜刀神十香\",\"鸢一折纸\"],\"rights\":{\"bp\":0,\"elec\":0,\"download\":0,\"movie\":0,\"pay\":0,\"hd5\":0},\"stat\":{\"view\":\"--\",\"danmaku\":17,\"reply\":14,\"favorite\":30,\"coin\":10,\"share\":3,\"now_rank\":0,\"his_rank\":0},\"play\":\"--\",\"favorites\":30,\"video_review\":17,\"create\":\"2016-09-13 22:24\",\"description\":\"BGM：sweet ARMS——デート ア ライブnn约战MV，之前出了个时崎狂三主题曲的MV，站友们都说画质渣。。确实，那时候没有电脑，只能拿手机做，这次资源是1080P的，做出来也保证高清，大家可以放心食用。\",\"mid\":27798014,\"author\":\"叶影先生\",\"face\":\"http://i2.hdslb.com/bfs/face/a401d801ab300241d1c5acc8aff158be93265789.jpg\"}";
		
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
		while (m.find()) {// 1 av号，					3 封面链接，		5 标题，				7播放，				8弹幕，			9回复，		10收藏，		11硬币，		12分享			,15上传时间,		17描述		,19作者，			20图片链接
			i=m.group(1)+"|"+m.group(3)+"|"+m.group(5).replace("|", "，")+"|"+m.group(7)+"|"+m.group(8)+"|"+m.group(9)+"|"+m.group(10)+"|"+m.group(11)+"|"+m.group(12)+"|"+m.group(15)+"|"+m.group(17).replace("|", "，")+"|"+m.group(19).replace("|", "，")+"|"+m.group(20)+"\r\n";
		
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


