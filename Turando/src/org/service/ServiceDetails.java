package org.service;

public class ServiceDetails {
	
	public static String dealTextMessage(String Text){
		String temp = "";
		byte[] tempbyte = Text.getBytes();
		//只有非?和非1-7的回复文本信息
		switch(tempbyte[0]){
		case '?':
			temp = "请回复数字选择回复：\n\n1、New Arrivals\n2、流行爆款\n3、反季促销\n4、彩妆面膜\5、积分兑换\6、心愿单\7、海外代购\n\n回复？显示此帮助菜单";
			break;
		case '1':
			temp = "New Arrivals";
			break;
		case '2':
			temp = "流行爆款";
			break;
		case '3':
			temp = "反季促销";
			break;
		case '4':
			temp = "彩妆面膜";
			break;
		case '5':
			temp = "积分兑换";
			break;
		case '6':
			temp = "心愿单";
			break;
		case '7':
			temp = "海外代购";
			break;
		default :
			temp = "回复？显示帮助菜单";
		}
		return temp;
	}
}
