package org.service;

import org.message.resp.*;

public class GetXMLBySelf {
	public static String resText(Object obj){
		String temp = "";
		if(obj instanceof TextMessage){
			temp = "<xml>" + 
					"<ToUserName><![CDATA[" + ((TextMessage)obj).getToUserName() + "]]></ToUserName>"+
				    "<FromUserName><![CDATA[" + ((TextMessage)obj).getFromUserName() + "]]></FromUserName>"+
					"<CreateTime>" + ((TextMessage)obj).getCreateTime() + "</CreateTime>"+
				    "<MsgType><![CDATA[" + ((TextMessage)obj).getMsgType() + "]]></MsgType>"+
					"<Content><![CDATA[" + ((TextMessage)obj).getContent() + "]]></Content>" +
					"</xml>";
		}
		if(obj instanceof VideoMessage){
			temp = "<xml>" + 
					"<ToUserName><![CDATA[" + ((VideoMessage)obj).getToUserName() + "]]></ToUserName>"+
				    "<FromUserName><![CDATA[" + ((VideoMessage)obj).getFromUserName() + "]]></FromUserName>"+
					"<CreateTime>" + ((VideoMessage)obj).getCreateTime() + "</CreateTime>"+
				    "<MsgType><![CDATA[" + ((VideoMessage)obj).getMsgType() + "]]></MsgType>"+
					"<Video><MediaId><![CDATA[" + ((VideoMessage)obj).getVideo().getMediaId() + "]]></MediaId>" +
					"<Title><![CDATA[" + ((VideoMessage)obj).getVideo().getTitle() + "]]></Title>" +
					"<Description><![CDATA[" + ((VideoMessage)obj).getVideo().getDescription() + "]]></Description>" +
					"</Video></xml>";
		}
		if(obj instanceof VoiceMessage){
			temp = "<xml>" + 
					"<ToUserName><![CDATA[" + ((VoiceMessage)obj).getToUserName() + "]]></ToUserName>"+
				    "<FromUserName><![CDATA[" + ((VoiceMessage)obj).getFromUserName() + "]]></FromUserName>"+
					"<CreateTime>" + ((VoiceMessage)obj).getCreateTime() + "</CreateTime>"+
				    "<MsgType><![CDATA[" + ((VoiceMessage)obj).getMsgType() + "]]></MsgType>"+
					"<Voice><MediaId><![CDATA[" + ((VoiceMessage)obj).getVoice().getMediaId() + "]]></MediaId>" +
					"</Voice></xml>";
		}
		if(obj instanceof ImageMessage){
			temp = "<xml>" + 
					"<ToUserName><![CDATA[" + ((ImageMessage)obj).getToUserName() + "]]></ToUserName>"+
				    "<FromUserName><![CDATA[" + ((ImageMessage)obj).getFromUserName() + "]]></FromUserName>"+
					"<CreateTime>" + ((ImageMessage)obj).getCreateTime() + "</CreateTime>"+
				    "<MsgType><![CDATA[" + ((ImageMessage)obj).getMsgType() + "]]></MsgType>"+
					"<MediaId><![CDATA[" + ((ImageMessage)obj).getImage().getMediaId() + "]]></MediaId>" +
					"</xml>";
		}
		if(obj instanceof MusicMessage){
			temp = "<xml>" + 
					"<ToUserName><![CDATA[" + ((MusicMessage)obj).getToUserName() + "]]></ToUserName>"+
				    "<FromUserName><![CDATA[" + ((MusicMessage)obj).getFromUserName() + "]]></FromUserName>"+
					"<CreateTime>" + ((MusicMessage)obj).getCreateTime() + "</CreateTime>"+
				    "<MsgType><![CDATA[" + ((MusicMessage)obj).getMsgType() + "]]></MsgType>"+
					"<Music><Title><![CDATA[" + ((MusicMessage)obj).getMusic().getTitle() + "]]></Title>" +
				    "<Description><![CDATA[" + ((MusicMessage)obj).getMusic().getDescription() + "]]></Description>" +
				    "<MusicUrl><![CDATA[" + ((MusicMessage)obj).getMusic().getMusicUrl() + "]]></MusicUrl>" +
				    "<HQMusicUrl><![CDATA[" + ((MusicMessage)obj).getMusic().getHQMusicUrl() + "]]></HQMusicUrl>" +
				    //"<ThumbMediaId><![CDATA[" + ((MusicMessage)obj).getMusic().getThumbMediaId() + "]]></ThumbMediaId>" +
					"</Music></xml>";
		}
		if(obj instanceof NewsMessage){
			temp = "<xml>" + 
					"<ToUserName><![CDATA[" + ((NewsMessage)obj).getToUserName() + "]]></ToUserName>"+
				    "<FromUserName><![CDATA[" + ((NewsMessage)obj).getFromUserName() + "]]></FromUserName>"+
					"<CreateTime>" + ((NewsMessage)obj).getCreateTime() + "</CreateTime>"+
				    "<MsgType><![CDATA[" + ((NewsMessage)obj).getMsgType() + "]]></MsgType>"+
					"<ArticleCount><![CDATA[" + ((NewsMessage)obj).getArticleCount() + "]]></ArticleCount>"+
				    "<Articles>";
						for(Article a:((NewsMessage)obj).getArticles()){							
							temp = temp + "<item><Title><![CDATA[" + a.getTitle() + "]]></Title>";
							temp = temp + "<Description><![CDATA[" + a.getDescription() + "]]></Description>";
							temp = temp + "<PicUrl><![CDATA[" + a.getPicUrl() + "]]></PicUrl>";
							temp = temp + "<Url><![CDATA[" + a.getUrl() + "]]></Url></item>";
						}
					temp += "</Articles></xml>";
		}
		return temp;
	}
}
