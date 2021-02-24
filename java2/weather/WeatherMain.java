package com.ssafy.weather;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class WeatherMain {
	JFrame f;
	JButton b;
	JList li;
	WeatherSAXDAO dao;

	public WeatherMain() {
		dao = new WeatherSAXDAO();
		createGUI();		
	}

	private void createGUI() {
		f = new JFrame("Weather Info");
		b = new JButton("call Weather");
		li = new JList<Weather>();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		
		f.add(b, "North");
		f.add(li, "Center");
		f.setSize(500, 800);
		f.setVisible(true);
	}
	
	protected void showList() {
		List<Weather> data = dao.getNewsList("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
		li.removeAll();
		li.setListData(data.toArray());
	}
	
	public static void main(String[] args) {
		new WeatherMain();
	}
}
