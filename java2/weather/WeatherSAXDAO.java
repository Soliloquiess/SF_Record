package com.ssafy.weather;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAXDAO {
	List<Weather> list = new ArrayList<>();

	public List<Weather> getNewsList(String url) {
		list.clear();
		connectWeather(url);
		return list;

	}

	private List<Weather> connectWeather(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);			
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb;
		Weather w;

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String s = new String(ch, start, length);
			sb.append(s);
		}

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if (w != null) {
				if (name.equalsIgnoreCase("tmEf")) {
					w.setDate(sb.toString().trim());

				} else if (name.equalsIgnoreCase("tmn")) {
					w.setTmn(sb.toString().trim());

				} else if (name.equalsIgnoreCase("tmx")) {
					w.setTmx(sb.toString().trim());

				} else if (name.equalsIgnoreCase("wf")) {
					w.setWf(sb.toString().trim());

				} else if (name.equalsIgnoreCase("data")) {
					list.add(w);
				}
			}
			sb.setLength(0);
		}

		@Override
		public void startDocument() throws SAXException {
			list = new ArrayList<Weather>();
			sb = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String qname, Attributes attributes)
				throws SAXException {

			if (qname.equalsIgnoreCase("data")) {				
				w = new Weather();
			}
		}
	}

}