package com.ssafy.guestbook.model.dao;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public interface GuestBookDao {

//	글작성
	void registerArticle(GuestBookDto guestBookDto);
	
//	글목록
	List<GuestBookDto> listArticle(String key, String word);
	
//	글수정을 위한 글얻기
	GuestBookDto getArticle(int articleNo);
	
//	글수정
	void modifyArticle(GuestBookDto guestBookDto);
	
//	글삭제
	void deleteArticle(int articleNo);
	
}
