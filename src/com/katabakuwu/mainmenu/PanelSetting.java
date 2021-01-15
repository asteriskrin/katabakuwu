package com.katabakuwu.mainmenu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.katabakuwu.FrameMainMenu;

public class PanelSetting extends JPanel{
	public PanelSetting(FrameMainMenu frameMainMenu) {
		setBorder(new LineBorder(Color.BLUE, 8));
		setBounds(90, 220, 300, 200);
		setVisible(false);
		setLayout(null);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVolume.setBounds(25, 40, 63, 20);
		add(lblVolume);
		
		JSlider sliderVolume = new JSlider();
		sliderVolume.setMajorTickSpacing(50);
		sliderVolume.setMinorTickSpacing(10);
		sliderVolume.setBounds(125, 40, 150, 22);
		sliderVolume.setFont(new Font("Tahoma", Font.PLAIN, 8));
		sliderVolume.setPaintLabels(true);
		add(sliderVolume);
		
		sliderVolume.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mousePressed(MouseEvent e) {
	            Point p = e.getPoint();
	            double percent = p.x / ((double) sliderVolume.getWidth());
	            int range = sliderVolume.getMaximum() - sliderVolume.getMinimum();
	            double newVal = range * percent;
	            int result = (int)(sliderVolume.getMinimum() + newVal);
	            sliderVolume.setValue(result);
	         }
	      });
		
//		JLabel lblBrightness = new JLabel("Brightness");
//		lblBrightness.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblBrightness.setBounds(25, 80, 77, 20);
//		add(lblBrightness);
		
//		JSlider sliderBrightness = new JSlider();
//		sliderBrightness.setMajorTickSpacing(50);
//		sliderBrightness.setMinorTickSpacing(10);
//		sliderBrightness.setBounds(125, 80, 150, 22);
//		sliderBrightness.setFont(new Font("Tahoma", Font.PLAIN, 8));
//		sliderBrightness.setPaintLabels(true);
//		add(sliderBrightness);
//		
//		sliderBrightness.addMouseListener(new MouseAdapter() {
//	         @Override
//	         public void mousePressed(MouseEvent e) {
//	            Point p = e.getPoint();
//	            double percent = p.x / ((double) sliderBrightness.getWidth());
//	            int range = sliderBrightness.getMaximum() - sliderBrightness.getMinimum();
//	            double newVal = range * percent;
//	            int result = (int)(sliderBrightness.getMinimum() + newVal);
//	            sliderBrightness.setValue(result);
//	         }
//	      });
		
		JButton resetBtn = new JButton("Reset Data");
		resetBtn.setForeground(Color.decode("#333333"));
		resetBtn.setBackground(Color.decode("#d5d5ff"));
		resetBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 2));
		resetBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resetBtn.setBounds(100, 90, 100, 30);
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = new String[2];
				options[0] = new String("Ya");
				options[1] = new String("Tidak");
				
				int n = JOptionPane.showOptionDialog(null,"Apakah Anda yakin untuk reset data?",
						"Reset Data", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
				if (n == 1) { //Tidak
					System.out.println("n = 1");
				} else {
					System.out.println("n = 0");
				}
			}
		});
		add(resetBtn);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.setForeground(Color.decode("#333333"));
		closeBtn.setBackground(Color.decode("#d5d5ff"));
		closeBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#aaaaff"), 2));
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeBtn.setBounds(100, 130, 100, 30);
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frameMainMenu.enabled = true;
				frameMainMenu.setButtonStatus();
			}
		});
		add(closeBtn);
	}
}
