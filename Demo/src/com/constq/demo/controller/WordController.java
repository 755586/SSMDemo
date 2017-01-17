package com.constq.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Word;
import com.constq.demo.service.WordService;

@Controller
@RequestMapping("/system/center/word")
public class WordController {

	@Autowired
	private WordService wordService;
	
	@RequestMapping(value="")
	public String word(HttpServletRequest request) {
		return "system/center/word";
	}
	
	@RequestMapping(value="",params={"action=list"})
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,int page,int rows){
		Integer total = wordService.getTotal();
		int start = (page-1)*rows+1;
		int end = (page)*rows;
		List<Word> words = wordService.findAllWordByPage(new Page(start,end));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", words);
		return map ;
	}
	
	@RequestMapping(value="",params={"action=update"})
	@ResponseBody
	public Word update(HttpServletRequest request,String id,String name,String password){
		Word word = new Word();
		wordService.updateWord(word);
		return word;
	}
	
	@RequestMapping(value="",params={"action=delete"})
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request,String id){
		Map<String, Object> map = new HashMap<String, Object>();
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
