package com.katabakuwu.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

public class PanelSetting extends JPanel{
	public PanelSetting() {
		setBorder(new LineBorder(Color.BLUE, 8));
		setBounds(90, 220, 300, 200);
		setVisible(false);
		setLayout(null);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVolume.setBounds(25, 40, 63, 20);
		add(lblVolume);
		
		JLabel lblBrightness = new JLabel("Brightness");
		lblBrightness.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrightness.setBounds(25, 80, 77, 20);
		add(lblBrightness);
		
		JSlider sliderVolume = new JSlider();
		sliderVolume.setMinorTickSpacing(10);
		sliderVolume.setBounds(125, 40, 150, 22);
		add(sliderVolume);
		
		JSlider sliderBrightness = new JSlider();
		sliderBrightness.setMinorTickSpacing(10);
		sliderBrightness.setBounds(125, 80, 150, 22);
		add(sliderBrightness);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.setForeground(Color.BLACK);
		closeBtn.setBackground(Color.decode("#dd55ff"));
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeBtn.setBounds(50, 140, 200, 20);
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		add(closeBtn);
	}
}
