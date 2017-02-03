package com.constq.demo.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constq.demo.mapper.WordMapper;
import com.constq.demo.pojo.Factory;
import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Word;
import com.constq.demo.service.WordService;

@Service
public class WordServiceImp implements WordService {
	@Autowired
	private WordMapper WordMapper;

	public List<Word> findAllWord() {
		return WordMapper.findAllWord();
	}

	public List<Word> findAllWordByPage(Page page) {
		// TODO Auto-generated method stub
		return WordMapper.findAllWordByPage(page);
	}

	public Integer getTotal() {
		// TODO Auto-generated method stub
		return WordMapper.getTotal();
	}

	public void addWord(Word Word) {
		// TODO Auto-generated method stub
		WordMapper.addWord(Word);
	}

	public void updateWord(Word Word) {
		// TODO Auto-generated method stub
		WordMapper.updateWord(Word);
	}

	public void deleteWordById(int id) {
		// TODO Auto-generated method stub
		WordMapper.deleteWordById(id);
	}

	public List<Word> findAllWordByTypeAndRank(Map<String, Object> tr) {
		// TODO Auto-generated method stub
		return WordMapper.findAllWordByTypeAndRank(tr);
	}

}
