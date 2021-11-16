package GUI;

import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameLogic.*;
import Images.ResourceManager;
import PickeableElements.Pickeable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainWindowV2 extends JFrame {
	
	
	//DECLARACIÓN DE VARIABLES
	
	private JPanel contentPane;
	
	private JLabel backgroundLabel;
	
	public MainWindowV2() {
		
		contentPane = new JPanel();
		
		contentPane.setBounds(0, 0, 0, 0);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.setContentPane(contentPane);
		
	}
	
	private void setBackground(JPanel j, ImageIcon backgroundImage){
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Scales the obtained image and upscales it to the current window size
		
		Image imagen = backgroundImage.getImage();
			
		if(imagen != null) {
			Image nuevaImagen = imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST);
			backgroundImage.setImage(nuevaImagen);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		backgroundLabel = new JLabel("" , backgroundImage , JLabel.CENTER);
		
		
		backgroundImage.setImageObserver(backgroundLabel); //Sets image observer as the background label to allow to play gif animations.
		
		
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());

		getContentPane().add(backgroundLabel);
	
		backgroundLabel.repaint();
		
	}
	
	private void resize(ImageIcon image, int width, int height) {
		
		Image recoveredImage = image.getImage();
		
		if(recoveredImage != null) {
			recoveredImage = recoveredImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		}
		
		image.setImage(recoveredImage);
		
	}
	
	private void updateLabelIcon(JLabel label, ImageIcon image) {
		label.setIcon(image);
		label.repaint();
	}
	
	private void updateCell(Cell c) {
		
	} 
	
	private void updatePickup(Pickeable p) {
		
	}
	
	private void updateCharacter(Character c) {
		
	}
	
}
