package com.constq.demo.mapper;

import java.util.List;
import java.util.Map;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Word;

public interface WordMapper {

	public List<Word> findAllWord();

	public List<Word> findAllWordByPage(Page page);
	
	public List<Word> findAllWordByTypeAndRank(Map<String, Object> tr);

	public Integer getTotal();

	public void addWord(Word Word);

	public void updateWord(Word Word);

	public void deleteWordById(int id);
}
