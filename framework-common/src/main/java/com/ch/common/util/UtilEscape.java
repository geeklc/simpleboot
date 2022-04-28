package com.ch.common.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 避免sql注入转义操作类
 * @Author : lichong
 * @Date : 2022/3/27 14:36
 * @Modified By
 */
public class UtilEscape extends StringEscapeUtils {
	
	public static final String escapeSQL(String input) {
		if(StringUtils.isBlank(input)){
			return "" ;
		}
//		input = input.replaceAll("[%_$]", "/$0") ;
		input = input.replaceAll("[%$]", "/$0") ;
		
		input = input.replaceAll("'", "''") ;
		
		return input ;
    }

	/**
	 * 去除文本中的html标签
	 * @param str
	 * @return
	 */
	public static String delHtmlTag(String str){
		String newstr = "";

		if(UtilString.isNotBlank( str )){
			newstr = str.replaceAll("<[.[^>]]*>","");

			newstr = newstr.replaceAll(" ", "");

			newstr = newstr.replaceAll("&nbsp;", "");
		}

		return newstr;
	}

//	public static void main(String[] args) {
//	     String text = "<p style=\"text-autospace:ideograph-numeric;line-height:39px\">&nbsp; &nbsp; &nbsp; &nbsp;临沂市费县薛庄镇三星村地处费县西北，是一个坐落在蒙山脚下的合并村，这里曾因位置偏僻，基础实施落后，一直缺乏经济发展活力。在脱贫攻坚和乡村振兴行动中，市城投集团派驻三星村第一书记工作组充分发挥集团产业优势，结合当地自然资源，争取资金发展集体经济，引进高端农业，建设乡村民宿，努力把三星村打造成美丽村居齐鲁样板。</p><p><br/></p>" ;
//	     text = "<p>　　刚刚胜利闭幕的党的第十九次全国代表大会对中国共产党章程做了很多很重要的修改，在诸多的修改内容当中，最重要最具有长远意义的是把习近平新时代中国特色社会主义思想写入了党章，同马列主义、毛泽东思想、邓小平理论、“三个代表”重要思想、科学发展观一道确立为党的指导思想，确立为我们党的行动指南。</p>" ;
//
//		System.out.println( text );
//
//		System.out.println( delHtmlTag( text ) );
//	}
	
}
