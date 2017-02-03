package com.constq.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;
import com.constq.demo.pojo.Word;
import com.constq.demo.service.WordService;
import com.sun.corba.se.impl.oa.toa.TOA;

@Controller
@RequestMapping("/system/center/word")
public class WordController {

	@Autowired
	private WordService wordService;
	
	@RequestMapping(value="/chart")
	public String word(HttpServletRequest request) {
		return "system/center/word_chart";
	}
	
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request) {
		return "system/center/word_edit";
	}
	
	@RequestMapping(value="/chart",params={"action=list"})
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request){
		List<Word> words = wordService.findAllWord();
		Set<Integer>type = new HashSet<Integer>();
		String[] type_name = new String[100];
		int[] num = new int[100];
		for(Word w:words){
			int key = w.getType();
			if(!type.contains(key)){
				type.add(key);
				type_name[key] = w.getType_name();
				num[key] = 1;
			}else{
				num[key] = num[key]+1;
			}
		}
		List< Map<String, Object> >list = new ArrayList<Map<String,Object>>();
		for(Integer key:type){
			Map<String, Object> obj = new HashMap<String, Object>();
			obj.put("name", type_name[key]);
			obj.put("y", num[key]);
			list.add(obj);
			System.out.println(type_name[key]+" "+num[key]);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("colorByPoint", true);
		map.put("name", "词汇比例");
		return map ;
	}
	
	@RequestMapping(value="/wordEdit",params={"action=list"})
	@ResponseBody
	public Map<String, Object> wordEdit(HttpServletRequest request,int page,int rows){
//		Map<String, Object> tr = new HashMap<String, Object>();
//		tr.put("type_name", "动物");
//		tr.put("rank", "2");
//		List<Word> test = wordService.findAllWordByTypeAndRank(tr);
//		System.out.println(test.get(0));
		int start = (page-1)*rows+1;
		int end = (page)*rows;
		List<Word> words = wordService.findAllWordByPage(new Page(start, end));
		Integer total = wordService.getTotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", words);
		return map ;
	}
	
	@RequestMapping(value="",params={"action=update"})
	@ResponseBody
	public Word update(HttpServletRequest request,String id,String english,String chinese,String rank){
		Word word = new Word();
		word.setId(Integer.parseInt(id));
		word.setEnglish(english);
		word.setChinese(chinese);
		word.setRank(Integer.parseInt(rank));
		wordService.updateWord(word);
		return word;
	}
	
	@RequestMapping(value="",params={"action=delete"})
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request,String id){
		Map<String, Object> map = new HashMap<String, Object>();
		wordService.deleteWordById(Integer.parseInt(id));
		map.put("success", true);
		return map;
	}
	
	@RequestMapping(value="",params={"action=add"})
	@ResponseBody
	public Word add(HttpServletRequest request,String name,String password){
		Word word = new Word();
		
		return word;
	}
}
