package com.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//sax 방식으로 파싱작업 해주는 클래스
//DefaultHandler
public class BookSAXParser extends DefaultHandler {

	//<title>hello</title>
	boolean flag = false;
	//시작 엘리먼트를 만나 경우 호출됨<title>
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("title")) {
			flag = true;
			System.out.print("제목:");
		}		
	}

	//종료엘리먼트를 만나 경우 호출됨</title>
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("title")) {
			System.out.println();
			flag = false;
		}
	}

	//텍스트를 만나는 경우 호출됨 hello
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String title = new String(ch, start, length);
		if(flag)
			System.out.print(title);
	}
}
