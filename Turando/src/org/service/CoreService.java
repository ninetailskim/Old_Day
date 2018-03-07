package org.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.message.resp.Article;
import org.message.resp.Image;
import org.message.resp.ImageMessage;
import org.message.resp.Music;
import org.message.resp.MusicMessage;
import org.message.resp.NewsMessage;
import org.message.resp.TextMessage;
import org.util.MessageUtil;

import MySqlBase.LinkDB;

public class CoreService {
	public static String processRequest(HttpServletRequest request){
		/*
		 * 0文本消息
		 * 1图片回复
		 * 2语音回复
		 * 3视频回复
		 * 4音乐回复
		 * 5图文回复
		 * */
		int respID = -1;
		String respMessage = null;
		try{
			String respContent = "";
			Map<String,String> requestMap = MessageUtil.parseXml(request);
			//获取用户ID
			String fromUserName = requestMap.get("FromUserName");
			//获取本地ID
			String toUserName = requestMap.get("ToUserName");
			//获取消息类型
			String msgType = requestMap.get("MsgType");
			
			
					
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {	
				int res;
				//若是文本消息，获取消息内容
				String Req = requestMap.get("Content");
				//分析消息内容				
				byte[] tempbyte = Req.getBytes();
				//只有非?和非1-7的回复文本信息
				switch(tempbyte[0]){
				case '?':
					respID = 0;
					respContent = "请回复数字选择回复：\n\n1、New Arrivals\n2、流行爆款\n3、珠宝首饰\n4、彩妆面膜\n5、海外代购\n6、心愿单\n7、注册用户\n8、积分查询\n9、听首歌吧\n\n回复？显示此帮助菜单";
					break;
				case '1':
					respID = 0;
					respContent = "New Arrivals";
					break;
				case '2':
					respID = 0;
					respContent = "<a href=\"http://turando-test.flzhan.com/index.html\">流行爆款</a>";
					break;
				case '3':
					respID = 0;
					respContent = "<a href=\"http://turando-test1.flzhan.com/index.html\">珠宝首饰</a>";
					break;
				case '4':
					respID = 5;
					respContent = "彩妆面膜";
					break;
				case '5':
					respID = 0;
					respContent = "海外代购";
					break;
				case '6':
					respID = 0;
					res = LinkDB.AddScore(fromUserName);
					if(res >= 0){
						respContent = "积分为："+ res;
					} else{
						respContent = "你还没注册。";
					}
					//respContent = "心愿单";
					break;
				case '7':
					respID = 0;				
					respContent = LinkDB.register(fromUserName);
					/*用作测试的 */
					FileOutputStream fop = null;
					File file = new File("c:\\test.txt");
					fop = new FileOutputStream(file);			
					if(!file.exists()){
						file.createNewFile();
					}
					String content = "asd" + respContent;
					byte[] contentInBytes = content.getBytes();
					fop.write(contentInBytes);
					fop.flush();
					fop.close();
					/*测试结束*/					
					break;
				case '8':
					respID = 0;
					res = LinkDB.QueryScore(fromUserName);
					if(res >= 0){
						respContent = "积分为："+ res;
					} else{
						respContent = "你还没注册。";
					}
					break;
				case '9':
					respID = 4;
					respContent = "听首歌吧";
					break;
				default :
					respID = 0;
					respContent = "<a href=\"http://www.baidu.com\">回复？显示帮助菜单</a>";
					break;
				}
			}			
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respID = 0;
				respContent = "你发送的图片消息";
			}
			
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respID = 0;
				respContent = "你发送的位置消息";
			}
			
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respID = 0;
				respContent = "你发送的连接消息";
			}
			
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respID = 0;
				respContent = "你发送的语音消息";
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {				
				String eventType = requestMap.get("Event");				
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "很高兴见到你！";
				}				
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {					
				}				
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {					
				}
			 }
			switch(respID){
			case -1:
				break;
			case 0:
				TextMessage textMessage = new TextMessage();
				textMessage.setFromUserName(toUserName);
				textMessage.setToUserName(fromUserName);			
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				//textMessage.setFuncFlag(0); 
				textMessage.setContent(respContent);
				respMessage = GetXMLBySelf.resText(textMessage);
				break;
			case 1:
				ImageMessage imageMessage = new ImageMessage();
				//Image image = new Image();
				imageMessage.setFromUserName(toUserName);
				imageMessage.setToUserName(fromUserName);
				imageMessage.setCreateTime(new Date().getTime());
				imageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
				//image.setMediaId(mediaId)
				respMessage = GetXMLBySelf.resText(imageMessage);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				MusicMessage musicMessage = new MusicMessage();
				musicMessage.setToUserName(fromUserName);
				musicMessage.setFromUserName(toUserName);
				musicMessage.setCreateTime(new Date().getTime());
				musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
				Music music = LinkDB.GetMusic();
				musicMessage.setMusic(music);
				respMessage = GetXMLBySelf.resText(musicMessage);
				break;
			case 5:
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				
				List<Article> articleList = new ArrayList<Article>();
				Article article1 = new Article();
				article1.setTitle("伊蒂之屋炫彩缤纷眼影笔 爱的主旋律");
				article1.setDescription("伊蒂之屋炫彩缤纷眼影笔，令双眸如同星光闪耀，呈现善良眼妆的眼影笔");
				article1.setPicUrl("http://www.etude.cn/common/upload/product/100009634_main.jpg");
				article1.setUrl("http://www.etude.cn/product/view.do?prdCode=100009634#");
				Article article2 = new Article();
				article2.setTitle("【玩美4月】玩美遮瑕BB+保湿免洗卸妆水组合");
				article2.setDescription("伊蒂之屋炫彩缤纷眼影笔，令双眸如同星光闪耀，呈现善良眼妆的眼影笔");
				article2.setPicUrl("http://www.etude.cn/common/upload/product/100009838_main.jpg");
				article2.setUrl("http://www.etude.cn/product/view.do?prdCode=100009838");
				Article article3 = new Article();
				article3.setTitle("伊蒂之屋明眸卷翘定型睫毛膏专用卸妆液");
				article3.setDescription("伊蒂之屋炫彩缤纷眼影笔，令双眸如同星光闪耀，呈现善良眼妆的眼影笔");
				article3.setPicUrl("http://www.etude.cn/common/upload/product/100009723_main.jpg");
				article3.setUrl("http://www.etude.cn/product/view.do?prdCode=100009723");
				Article article4 = new Article();
				article4.setTitle("伊蒂之屋致幻花语眼影盘");
				article4.setDescription("伊蒂之屋炫彩缤纷眼影笔，令双眸如同星光闪耀，呈现善良眼妆的眼影笔");
				article4.setPicUrl("http://www.etude.cn/common/upload/product/100008041_main.jpg");
				article4.setUrl("http://www.etude.cn/product/view.do?prdCode=100008041");
				
				articleList.add(article1);
				articleList.add(article2);
				articleList.add(article3);
				articleList.add(article4);
				
				newsMessage.setArticleCount(articleList.size());
				newsMessage.setArticles(articleList);
				respMessage = GetXMLBySelf.resText(newsMessage);
				break;
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		return respMessage;
	}
}
