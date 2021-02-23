package com.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class BookSAXParsingTest {
	public static void main(String[] args) throws Exception{
		//SAX PARSER 가 필요함.(SAX 방식으로 파싱하니까)
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//팩토리가 먼저 있어야 하고 팩토리로 부터 삭스파서 하나 만들어 달라고 함.
		SAXParser parser = factory.newSAXParser();
		//뉴 해서 메서드로 파서 를 하나 얻어냄.
		
		//BookSAXParser:book.xml를 읽어서 sax방식으로 파싱작업 해주는 클래스
		parser.parse("src/xml/book.xml", new BookSAXParser());
	}
}
