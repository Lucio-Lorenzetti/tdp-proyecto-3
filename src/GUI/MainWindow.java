package GUI;



import java.awt.Image;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GameLogic.*;
import Images.ResourceManager;
import PickeableElements.Pickeable;

import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;

import CharacterElements.Ghost;
import CharacterElements.Role;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MainWindow extends JFrame{

	private Game myGame;
	
	private JLabel[][] BottomLayer;
	private JLabel[][] PickupLayer;
	
	
	private HashMap<Object,JLabel> characterLabels;
	
	private JLabel mainCharacter;
	private JLabel Ghost1;
	private JLabel Ghost2;
	private JLabel Ghost3;
	private JLabel Ghost4;
	
	
	private JLabel temp;
	private JLabel background;
	private JLabel lblscore;
	
	String[][] tableData;
	String[] tableHeaders;
	
	
	private Font gameFont;
	
	private JPanel BottomLayerPanel;
	private JPanel PickupLayerPanel;
	private JPanel CharacterLayerPanel;
	private JPanel GameOverPanel;
	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane ScoreboardPanel;
	
	private int gridWidth;
	private int gridHeight;
	
	private int cellWidth;
	private int cellHeight;
	private JTable table;

	private Clip music;
	private boolean muteMusic;
	
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */	
	public MainWindow() {
		setUndecorated(true);
		
		
		this.setFocusable(true);
		this.requestFocus();
		
		characterLabels = new HashMap<Object, JLabel>();
		
		
		gameFont = null;

		/*
		gameFont = loadFont("/Fonts/text-font.ttf", 16f);
		*/
		
		gridHeight = 22;
		gridWidth = 22;
		
		BottomLayer = new JLabel[gridHeight][gridWidth];
		PickupLayer = new JLabel[gridHeight][gridWidth];
	
		
		this.setResizable(false);
		this.setBounds(0, 0, 1000, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		CharacterLayerPanel = createGamePanel();
		CharacterLayerPanel.setLayout(null);
		
		PickupLayerPanel = createGamePanel();
		//PickupLayerPanel.setLayout(null);
		
		BottomLayerPanel = createGamePanel();
		
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(542, 40, 448, 525);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton EXIT_BUTTON = new JButton("EXIT");
		EXIT_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				obtainFocus();
				System.exit(EXIT_ON_CLOSE);
			}
		});
		EXIT_BUTTON.setBounds(224, 385, 202, 35);
		panel.add(EXIT_BUTTON);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(224, 279, 202, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Score = new JLabel("Score");
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Score.setBounds(10, 11, 182, 14);
		panel_1.add(Score);
		
		lblscore = new JLabel("-Score-");
		lblscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblscore.setBounds(10, 50, 182, 14);
		panel_1.add(lblscore);
		
		
		ScoreboardPanel = new JScrollPane();
		ScoreboardPanel.setBounds(224, 11, 202, 257);
		panel.add(ScoreboardPanel);
		ScoreboardPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(101, 5, 0, 0);
		
		table.setRowSelectionAllowed(false);
		ScoreboardPanel.add(table);
		
		JButton pauseMusic = new JButton("Mute Music");
		pauseMusic.setBounds(10, 11, 204, 95);
		panel.add(pauseMusic);
		pauseMusic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!muteMusic){
					muteMusic = true;
					pauseMusic.setText("Unmute Music");
					music.stop();
				} else {
					muteMusic = false;
					pauseMusic.setText("Mute Music");
					music.start();
				}
				
				obtainFocus();
			}
		});
		
		
		
		cellWidth = BottomLayerPanel.getHeight() / gridHeight;
		cellHeight = BottomLayerPanel.getWidth() / gridWidth;
		
		
		
		
		
		
		for(int i = 0; i < gridWidth ; i++)
			for(int k = 0; k < gridHeight ; k++) {
					
				temp = new JLabel();				
			
				ImageIcon iconoLabel = ResourceManager.getProvider().getWallImages()[0];
				
				iconoLabel.setImageObserver(temp); 
	
				resize(iconoLabel, cellWidth, cellHeight);
				
				updateLabelIcon(temp, iconoLabel);
				
				
				
				BottomLayerPanel.add(temp);
				
				BottomLayer[i][k] = temp;
				
		}
		
		for(int i = 0; i < gridWidth ; i++)
			
			for(int k = 0; k < gridHeight ; k++) {
					
				temp = new JLabel();				
			
				PickupLayerPanel.add(temp);
				
				PickupLayer[i][k] = temp;
				
		}
		
		mainCharacter = new JLabel();

		
		
		
		ImageIcon characterIcon = new ImageIcon(this.getClass().getResource("/Images/AmongUs/characters/pacman/Neutral.gif"));
		
		mainCharacter.setIcon(characterIcon);
		
		CharacterLayerPanel.setVisible(true);
		PickupLayerPanel.setVisible(true);
		BottomLayerPanel.setVisible(true);
		
		
		setBackground();
		
		this.setVisible(true);
		
		music = ResourceManager.getProvider().getBackgroundMusic()[0];
		music.loop(music.LOOP_CONTINUOUSLY);
		music.start();	
		
		
	}
	
	public void clearGameScreen() {
		
		for(int i = 0; i < gridWidth ; i++) {
			for(int k = 0; k < gridHeight ; k++) {
							
				ImageIcon iconoLabel = new ImageIcon(this.getClass().getResource("/Images/AmongUs/tiles/road/road.png"));
				
				temp = BottomLayer[i][k];
				
				updateLabelIcon(temp, null);
				
			}
		}
		
		for(int i = 0; i < gridWidth ; i++) {
			
			for(int k = 0; k < gridHeight ; k++) {
					
				temp = PickupLayer[i][k];				
				
				updateLabelIcon(temp, null);
		
			}
		}
		
		for(Component c: CharacterLayerPanel.getComponents()) {
			CharacterLayerPanel.remove(c);
		}
		
	}

	
	
	private JPanel createGamePanel() {
		
		JPanel GamePanel = new JPanel();
		GamePanel.setBounds(10, 37, 528, 528);
		this.getContentPane().add(GamePanel);
		GamePanel.setLayout(new GridLayout(gridHeight, gridWidth, 0, 0));
		GamePanel.setOpaque(false);
		
		return GamePanel;
	}
	
	/*
	private void resize(ImageIcon grafico, JLabel label) {
		
		Image imagen = grafico.getImage();
		
		if(imagen != null) {
			Image nuevaImagen = imagen.getScaledInstance(cellWidth, cellHeight, Image.SCALE_FAST);
			grafico.setImage(nuevaImagen);
			label.setIcon(grafico);
			label.repaint();	
		}
		
	}*/
	
	/*
	private void resize(ImageIcon grafico, JLabel label, int width, int heigth) {
		
		Image imagen = null;
		
		if(grafico != null) { 
			
			imagen = grafico.getImage();
			
			if(imagen != null) {
				
				Image nuevaImagen = imagen.getScaledInstance(width, heigth, Image.SCALE_FAST);
				grafico.setImage(nuevaImagen);
				label.setIcon(grafico);
				
			} 
			
		} 
		
		label.setIcon(grafico);
		
		label.repaint();	
		
	}*/
	
	
	private void resize(ImageIcon image, int width, int height) {
		
		Image recoveredImage = null;
		
		if(image != null) {
			recoveredImage = image.getImage();
		}
		
		if(recoveredImage != null) {
			recoveredImage = recoveredImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		}
		
		image.setImage(recoveredImage);
		
	}
	
	private void updateLabelIcon(JLabel label, ImageIcon image) {
		label.setIcon(image);
		label.repaint();
	}
	
	
	public void paintCell(Cell celda) {
		
		ImageIcon nuevaImagen = celda.getGraphicEntity().getIcon();
		
		resize(nuevaImagen, cellWidth, cellHeight);
		
		updateLabelIcon(BottomLayer[celda.getRow()][celda.getColumn()], nuevaImagen);
		
		//resize(nuevaImagen, BottomLayer[celda.getRow()][celda.getColumn()]);
		
	}
	
	
	public void paintPickup(Pickeable p, int posFila, int posColumna) {
		
		ImageIcon nuevaImagen = null;
		
		int width = 0;
		int height = 0;
		
		if(p != null) {
			nuevaImagen = p.getGraphicEntity().getIcon();
			width = p.getWidth();
			height = p.getHeight();
		}
		
		//boolean pEsNulo =  p == null;
		
		//System.out.println( pEsNulo + " width: " + width + " height: " + height + " Fila: " + posFila + " Columna: " + posColumna);
		
		//resize(nuevaImagen, PickupLayer[posFila][posColumna], width, height);
		
		if(nuevaImagen != null) {
			resize(nuevaImagen, width, height);
		}
		updateLabelIcon(PickupLayer[posFila][posColumna], nuevaImagen);
		
	}
	
	public void paintCharacter(Role c) {
		ImageIcon nuevaImagen = c.getGraphicEntity().getIcon();
		
		//System.out.println("Painting Character");
		
		resize(nuevaImagen, c.getWidth(), c.getHeight());
		
		updateLabelIcon(characterLabels.get(c), nuevaImagen);
		
		//resize(nuevaImagen, characterLabels.get(c));
	}
	
	
	
	public void createCharacterGraphic(Role ch) {
		
		JLabel newCharacter = new JLabel();
		newCharacter.setBounds(ch.getPosX(), ch.getPosY(), ch.getWidth(), ch.getHeight());
		
		
		characterLabels.put(ch, newCharacter);
		
		
		ImageIcon mainCharImg = ch.getGraphicEntity().getIcon(); 
		
		
		mainCharImg.setImageObserver(newCharacter);
		
		newCharacter.setIcon(mainCharImg);
		
		paintCharacter(ch);
		
		CharacterLayerPanel.add(newCharacter);
		
	}
	
	
	public void displaceCharacter(Role displacedCharacter) {
		
		//System.out.println(displacedCharacter.getPosX() + " " + displacedCharacter.getPosY() + " " + displacedCharacter.getWidth() + " " + displacedCharacter.getHeight());
		
		characterLabels.get(displacedCharacter).setBounds(displacedCharacter.getPosX(), displacedCharacter.getPosY(), displacedCharacter.getWidth(), displacedCharacter.getHeight());
		
	}
	
	public void createTable() {
		
		int playerAmount = 10;
		
		String[] tableHeaders = {"SCORE", "PLAYER"};
		tableData = new String[playerAmount][2];
		
		
		
		table = new JTable(tableData, tableHeaders);

		table.setBounds(ScoreboardPanel.getX(), ScoreboardPanel.getY(), ScoreboardPanel.getWidth(), ScoreboardPanel.getHeight());
		
		//ScoreboardPanel.clear();
		
		table.setVisible(true);
		
		ScoreboardPanel.add(table);
		
		table.repaint();
	}
	
	private void setBackground(){

		//Selects a background image from the resource manager randomly
		ImageIcon[] backgroundImages = ResourceManager.getProvider().getBackgroundImages();
		
		int imageSelection = (int) (java.lang.System.currentTimeMillis() % backgroundImages.length);
		
		//ImageIcon fondo = new ImageIcon(this.getClass().getResource("/Images/backgrounds/background5.gif"));
		
		ImageIcon fondo = backgroundImages[imageSelection];
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Scales the obtained image and upscales it to the current window size
		
		Image imagen = fondo.getImage();
			
		if(imagen != null) {
			Image nuevaImagen = imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST);
			fondo.setImage(nuevaImagen);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		background = new JLabel("" , fondo , JLabel.CENTER);
		
		
		fondo.setImageObserver(background); //Sets image observer as the background label to allow to play gif animations.
		
		
		background.setBounds(0, 0, this.getWidth(), this.getHeight());

		getContentPane().add(background);
	
		background.repaint();
		


	}
	
	
	public void setGame(Game g) {
		
		myGame = g;
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		
		createTable();

		
		////////////////////////////////////////////////////////////////////////////////////
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					myGame.changeDirection(Directions.getUp(), myGame.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					myGame.changeDirection(Directions.getDown(), myGame.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					myGame.changeDirection(Directions.getLeft(), myGame.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					myGame.changeDirection(Directions.getRight(), myGame.getPacMan());
				}
			}
		});
		
		
	}
	
	public void updateScore(int score) {
		
		lblscore.setText( String.valueOf(score) ); 
	
	}
	
	public int getCellWidth() {
		return cellWidth;
	}
	
	public int getCellHeight() {
		return cellHeight;
	}
	
	
	public void obtainFocus() {
		this.requestFocus();
	}
}




