package com.constq.demo.service;

import java.util.List;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Word;

public interface WordService {
	public Integer getTotal();

	public List<Word> findAllWord();

	public List<Word> findAllWordByPage(Page page);

	public void addWord(Word Word);

	public void updateWord(Word Word);

	public void deleteWordById(int id);
}
