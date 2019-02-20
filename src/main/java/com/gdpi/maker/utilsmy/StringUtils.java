package com.gdpi.maker.utilsmy;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	/**
	 * 生成project的Id
	 * @return
	 */
	public static String projectString(){
		//根据日期来生成一个字符串
		//Date date=new Date();
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		//String stringTime = sdf.format(date);
		
		String string="Pro_"+string();
		//随机生成字符串
		/*String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";   
        char[] c = s.toCharArray();   
        Random random = new Random();   
        for( int i = 0; i < 18; i ++) {   
        	stringTime=stringTime+c[random.nextInt(c.length)];   
        }*/
        
       return string;
	}
	
	/**
	 * 生成forum的Id
	 * @return
	 */
	public static String forumString(){
		String string="For_"+string();
		return string;
	}
	/**
	 * 生成forum的Id
	 * @return
	 */
	public static String forumImgString(){
		String string="Img_"+string();
		return string;
	}
	
	/**
	 * 生成developer的Id
	 * @return
	 */
	public static String developerString(){
		String stringTime="Dev_"+string();
       return stringTime;
	}
	/**
	 * 生成studio的id
	 * @return
	 */
	public static String studioString(){
		String stringTime="Stu_"+string();
       return stringTime;
	}
	/**
	 * 生成position的id
	 * @return
	 */
	public static String positionString(){
		String stringTime="Pos_"+string();
       return stringTime;
	}
	
	public static String string(){
		String string="";
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";   
        char[] c = s.toCharArray();   
        Random random = new Random();   
        for( int i = 0; i < 8; i ++) {   
        	string=string+c[random.nextInt(c.length)];   
        }
		return string;
	}
	
	/**
	 * 生成类型Id
	 * @return
	 */
	public static String typeString(){
		String string="";
		String s = "0123456789";   
        char[] c = s.toCharArray();   
        Random random = new Random();   
        for( int i = 0; i < 3; i ++) {   
        	string=string+c[random.nextInt(c.length)];   
        }
		return string;
	}
	
	
	/**
	 * 如果只是英文小写字母就返回true,其他情况返回false
	 * @param word 需要判断的字符串
	 * @return
	 */
	public static boolean isAcronym(String word){
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if (!Character.isLowerCase(c)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNum(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	}

	/*public static void main(String[] args) {
		System.out.println(checkEmail("123@qq.com"));//<>=!#%^&$%^&.com

	}*/

	 public static boolean checkEmail(String email) {
		if (email != null) {
			try{
				//正常邮箱 /^\w+((-\w)|(\.\w))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/

				// 含有特殊 字符的 个人邮箱  和 正常邮箱
				//js: 个人邮箱     /^[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+@[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+(\.[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+)+$/

				//java：个人邮箱  [\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+@[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+\\.[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+

				// 范围 更广的 邮箱验证 “/^[^@]+@.+\\..+$/”
				final String pattern1 ="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

				final Pattern pattern = Pattern.compile(pattern1);
				final Matcher mat = pattern.matcher(email);
				return mat.matches();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}



}
