package GUI;



import java.awt.Image;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Game myGame;
	
	private JLabel[][] BottomLayer;
	private JLabel[][] PickupLayer;
	
	
	private HashMap<Object,JLabel> characterLabels;
	
	private JLabel mainCharacter;
	
	private JLabel temp;
	private JLabel background;
	private JLabel lblscore;
	
	String[][] tableData;
	String[] tableHeaders;
	
	
	private JPanel BottomLayerPanel;
	private JPanel PickupLayerPanel;
	private JPanel CharacterLayerPanel;
	private JPanel GameOverPanel;
	private JPanel contentPane;
	private JPanel menuPanel;
	private JScrollPane ScoreboardPanel;
	
	private int gridWidth;
	private int gridHeight;
	
	private int cellWidth;
	private int cellHeight;
	private JTable table;

	private Clip music;
	private JButton pauseMusic;
	private JLabel lifeCounter;
	private JButton PAUSE_BUTTON;
	private JButton RESETGAME;
	private JButton EXIT_BUTTON;
	
	private boolean stopMusic;
	private JButton SeeScores;
	
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */	
	public MainWindow() {
		
		stopMusic = false;
		
		setUndecorated(true);
		
		
		this.setFocusable(true);
		this.requestFocus();
		
		characterLabels = new HashMap<Object, JLabel>();

		
		gridHeight = 22;
		gridWidth = 22;
		
		BottomLayer = new JLabel[gridHeight][gridWidth];
		PickupLayer = new JLabel[gridHeight][gridWidth];
	
		
		this.setResizable(false);
		this.setBounds(0, 0, 1000, 600);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		CharacterLayerPanel = createGamePanel();
		CharacterLayerPanel.setLayout(null);
		
		PickupLayerPanel = createGamePanel();
		
		BottomLayerPanel = createGamePanel();
		
		
		menuPanel = new JPanel();
		menuPanel.setOpaque(false);
		menuPanel.setBounds(542, 40, 448, 525);
		this.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);
		
		
		EXIT_BUTTON = new JButton("EXIT");
		EXIT_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(EXIT_BUTTON.isEnabled()) {
					obtainFocus();
					myGame.saveScores();
					System.exit(EXIT_ON_CLOSE);
				}
			}
		});
		EXIT_BUTTON.setBounds(12, 390, 202, 124);
		menuPanel.add(EXIT_BUTTON);
		
		JPanel ScorePanel = new JPanel();
		ScorePanel.setBounds(12, 175, 202, 95);
		menuPanel.add(ScorePanel);
		ScorePanel.setLayout(null);
		
		JLabel Score = new JLabel("Score");
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Score.setBounds(10, 11, 182, 14);
		ScorePanel.add(Score);
		
		lblscore = new JLabel("0");
		lblscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblscore.setBounds(10, 50, 182, 14);
		ScorePanel.add(lblscore);
		
	
		
		pauseMusic = new JButton("MUTE MUSIC");
		pauseMusic.setBounds(10, 11, 204, 95);
		menuPanel.add(pauseMusic);
		pauseMusic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				stopMusic = !stopMusic;
				if(stopMusic) {
					music.stop();
					pauseMusic.setText("UNMUTE MUSIC");
				} else {
					music.start();
					pauseMusic.setText("MUTE MUSIC");
				}
			}
		});
		
		JPanel HealthPanel = new JPanel();
		HealthPanel.setBounds(11, 281, 203, 86);
		menuPanel.add(HealthPanel);
		HealthPanel.setLayout(null);
		
		JLabel lblLives = new JLabel("Lives");
		lblLives.setHorizontalAlignment(SwingConstants.CENTER);
		lblLives.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLives.setBounds(10, 5, 183, 14);
		HealthPanel.add(lblLives);
		
		lifeCounter = new JLabel("3");
		lifeCounter.setHorizontalTextPosition(SwingConstants.CENTER);
		lifeCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lifeCounter.setBounds(10, 45, 183, 14);
		HealthPanel.add(lifeCounter);
		
		PAUSE_BUTTON = new JButton("PAUSE");
		PAUSE_BUTTON.setBounds(12, 117, 202, 35);
		menuPanel.add(PAUSE_BUTTON);
		
		
		
		GameOverPanel = createGamePanel();
		GameOverPanel.setLayout(null);
		
		
		this.setBackground(GameOverPanel, ResourceManager.getProvider().getGameOverScreen() );
		
	
		
		
		
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
		
		
		
		
		this.setVisible(true);
		
		music = ResourceManager.getProvider().getBackgroundMusic()[0];
		music.loop(Clip.LOOP_CONTINUOUSLY);
		music.start();	
		
		setBackground();
 
        
        RESETGAME = new JButton("RESTART GAME");
        RESETGAME.setEnabled(false);
        RESETGAME.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(RESETGAME.isEnabled()) {
        			showGameOver(true);
        			lblscore.setText(Integer.toString(0));
        			lifeCounter.setText(Integer.toString(3));
        		}
        	}
        });
        RESETGAME.setBounds(224, 281, 204, 233);
        menuPanel.add(RESETGAME);
        
        SeeScores = new JButton("SCOREBOARD");
        SeeScores.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		JFrame f;    
        	    f=new JFrame();    
        	    f.setResizable(false);
        	    String data[][]= myGame.getScoreBoard(50);
        	    String column[]={"POSITION","SCORE","NAME"};         
        	    JTable jt=new JTable(data,column);
        	    jt.setColumnSelectionAllowed(false);
        	    jt.setEnabled(false);
        	    jt.setBounds(30,40,200,300);          
        	    JScrollPane sp=new JScrollPane(jt);    
        	    f.getContentPane().add(sp);          
        	    f.setSize(300,400);    
        	    f.setVisible(true); 
        	}
        });
        SeeScores.setBounds(224, 11, 204, 259);
        menuPanel.add(SeeScores);
       
        
		
       
		
	}
	
	public void clearGameScreen() {
		
		for(int i = 0; i < gridWidth ; i++) {
			for(int k = 0; k < gridHeight ; k++) {

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
		
		if(nuevaImagen != null) {
			resize(nuevaImagen, width, height);
		}
		updateLabelIcon(PickupLayer[posFila][posColumna], nuevaImagen);
		
	}
	
	public void paintCharacter(Role c) {
		ImageIcon nuevaImagen = c.getGraphicEntity().getIcon();
		
		resize(nuevaImagen, c.getWidth(), c.getHeight());
		
		updateLabelIcon(characterLabels.get(c), nuevaImagen);
		
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

		characterLabels.get(displacedCharacter).setBounds(displacedCharacter.getPosX(), displacedCharacter.getPosY(), displacedCharacter.getWidth(), displacedCharacter.getHeight());
		
	}
	
	public void createTable() {
		
		int playerAmount = 10;
		
		String[] tableHeaders = {"SCORE", "PLAYER"};
		tableData = new String[playerAmount][2];
		
		
		
		table = new JTable(tableData, tableHeaders);

		table.setBounds(ScoreboardPanel.getX(), ScoreboardPanel.getY(), ScoreboardPanel.getWidth(), ScoreboardPanel.getHeight());
		
		table.setVisible(true);
		
		ScoreboardPanel.add(table);
		
		table.repaint();
	}
	

	
	private void setBackground(JPanel back, ImageIcon image) {
		
		Image imagen;
		
		
		imagen = image.getImage();
	
		
		if(imagen != null) {
			Image nuevaImagen = imagen.getScaledInstance(back.getWidth(), back.getHeight(), Image.SCALE_FAST);
			image.setImage(nuevaImagen);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel backgroundLabelHolder = new JLabel("" , image , JLabel.CENTER);
		
		backgroundLabelHolder.setBounds(back.getX(), back.getY(), back.getWidth(), back.getHeight());
		
		image.setImageObserver(backgroundLabelHolder); //Sets image observer as the background label to allow to play gif animations.
		
		
		back.add(backgroundLabelHolder);
		
		
		
		back.repaint();
	}
	
	
	private void setBackground(){

		//Selects a background image from the resource manager randomly
		ImageIcon[] backgroundImages = ResourceManager.getProvider().getBackgroundImages();
		
		int imageSelection = (int) (java.lang.System.currentTimeMillis() % backgroundImages.length);
		
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
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					myGame.changeDirection(Directions.getUp(), Game.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					myGame.changeDirection(Directions.getDown(), Game.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					myGame.changeDirection(Directions.getLeft(), Game.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					myGame.changeDirection(Directions.getRight(), Game.getPacMan());
				}
			}
		});
		
		PAUSE_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGame.pauseOrUnpause();				
				obtainFocus();
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

	/**
	 * Updates the display that indicates the actual lives of the main character.
	 * @param hearts amount of lives to update.
	 */
	public void updateLifeCounter(int hearts) {
		
		lifeCounter.setText(Integer.toString(hearts));
		
	}

	public void showGameOver(boolean endingGame) {
	
		boolean gameOver = endingGame;
		
		clearGameScreen();
		
		BottomLayerPanel.setVisible(gameOver);
		PickupLayerPanel.setVisible(gameOver);
		CharacterLayerPanel.setVisible(gameOver);
		
		GameOverPanel.setVisible(!gameOver);
		
		
		
		BottomLayerPanel.setEnabled(gameOver);
		PickupLayerPanel.setEnabled(gameOver);
		CharacterLayerPanel.setEnabled(gameOver);
		
		GameOverPanel.setEnabled(!gameOver);
		
	
		
		for(Component c : menuPanel.getComponents()) {
			c.setEnabled(gameOver);
		}
		
		RESETGAME.setEnabled(!gameOver);
		EXIT_BUTTON.setEnabled(true);
		SeeScores.setEnabled(true);
		
		if(endingGame) {
			myGame.resetGame();
		} else {
			String s = (String) JOptionPane.showInputDialog("TYPE YOUR NAME");
			myGame.setPlayerName(s);
			myGame.pushScoreBoard();
		}
		
		this.repaint();
		
		
	}
	
	public void resumeGame() {
		
		boolean gameOver = true;
		
		clearGameScreen();
		
		BottomLayerPanel.setVisible(gameOver);
		PickupLayerPanel.setVisible(gameOver);
		CharacterLayerPanel.setVisible(gameOver);
		
		menuPanel.setVisible(gameOver);
		
		
		BottomLayerPanel.setEnabled(gameOver);
		PickupLayerPanel.setEnabled(gameOver);
		CharacterLayerPanel.setEnabled(gameOver);
		
		menuPanel.setEnabled(gameOver);
		
		
	}
}




