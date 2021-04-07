package com.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class BookSAXParsingTest {

	public static void main(String[] args) throws Exception{
		//SAX PARSER가 필요
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		//BookSAXParser:book.xml를 읽어서 이벤트 처리방식으로 파싱작업 해주는 클래스
		parser.parse("src/xml/book.xml", new BookSAXParser());
	}
}
