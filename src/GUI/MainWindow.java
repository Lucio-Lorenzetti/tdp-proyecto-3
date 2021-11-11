package GUI;



import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameLogic.*;
import Images.ResourceManager;

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

public class MainWindow extends JFrame{

	private JFrame frame;

	private Game game;
	
	private JLabel[][] BottomLayer;
	private JLabel[][] PickupLayer;
	private JLabel mainCharacter;
	private JLabel Ghost1;
	private JLabel Ghost2;
	private JLabel Ghost3;
	private JLabel Ghost4;
	private JLabel temp;
	private JLabel background;
	private JLabel lblscore;
	
	private Font gameFont;
	
	
	private JPanel BottomLayerPanel;
	private JPanel PickupLayerPanel;
	private JPanel CharacterLayerPanel;
	private JPanel contentPane;
	private JPanel panel;
	
	private JButton TEST_1;
	private JButton nextlvlButton;
	
	private int gridWidth;
	private int gridHeight;
	
	private int cellWidth;
	private int cellHeight;
	
	
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
		BottomLayerPanel = createGamePanel();
		
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(526, 73, 448, 440);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton EXIT_BUTTON = new JButton("EXIT");
		EXIT_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		EXIT_BUTTON.setBounds(10, 394, 168, 35);
		panel.add(EXIT_BUTTON);
		
		TEST_1 = new JButton("TEST_1");
		TEST_1.setBounds(276, 11, 162, 95);
		panel.add(TEST_1);
		
		nextlvlButton = new JButton("Siguiente Nivel");
		nextlvlButton.setBounds(10, 11, 162, 95);
		panel.add(nextlvlButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 279, 150, 150);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Score = new JLabel("Score");
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Score.setBounds(53, 11, 46, 14);
		panel_1.add(Score);
		
		lblscore = new JLabel("-Score-");
		lblscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblscore.setBounds(53, 50, 46, 14);
		panel_1.add(lblscore);
		
		
		
		cellWidth = BottomLayerPanel.getHeight() / gridHeight;
		cellHeight = BottomLayerPanel.getWidth() / gridWidth;
		
		
		
		
		/**
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 458, 708, 41);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel RightPanel = new JPanel();
		RightPanel.setBounds(458, 0, 250, 448);
		frame.getContentPane().add(RightPanel);
		RightPanel.setLayout(null);
		*/
		
		for(int i = 0; i < gridWidth ; i++)
			for(int k = 0; k < gridHeight ; k++) {
					
				temp = new JLabel();				
			
				ImageIcon iconoLabel = ResourceManager.getProvider().getTileImages()[0];
				
				iconoLabel.setImageObserver(temp); //Allows playing gifs.
				
				//temp.setIcon(iconoLabel);
				
				resize(iconoLabel, temp);		//Resize the 
				
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

		
		
		
		ImageIcon characterIcon = new ImageIcon(this.getClass().getResource("/Images/sprites1.png"));
		
		mainCharacter.setIcon(characterIcon);
		
		CharacterLayerPanel.setVisible(true);
		PickupLayerPanel.setVisible(true);
		BottomLayerPanel.setVisible(true);
		
		
		setBackground();
		
		this.setVisible(true);
		
		
		
		
		
	}
	
	public void clearGameScreen() {
		
		for(int i = 0; i < gridWidth ; i++) {
			for(int k = 0; k < gridHeight ; k++) {
							
				ImageIcon iconoLabel = new ImageIcon(this.getClass().getResource("/Images/road.png"));
				
				temp = BottomLayer[i][k];
				
				resize(iconoLabel, temp);
			}
		}
		
		for(int i = 0; i < gridWidth ; i++) {
			
			for(int k = 0; k < gridHeight ; k++) {
					
				temp = PickupLayer[i][k];				
				
				temp.setIcon(null);
		
			}
		}
		
		
		mainCharacter.setIcon(null);
		
	}
	
	
	private JPanel createGamePanel() {
		
		JPanel GamePanel = new JPanel();
		GamePanel.setBounds(44, 73, 440, 440);
		this.getContentPane().add(GamePanel);
		GamePanel.setLayout(new GridLayout(gridHeight, gridWidth, 0, 0));
		GamePanel.setOpaque(false);
		
		return GamePanel;
	}
	
	private JPanel createMenuPanel() {
		
		JPanel MenuPanel = new JPanel();
		
		return MenuPanel;
		
	}
	
	private JPanel createEndGamePanel() {
		
		JPanel MenuPanel = new JPanel();
		
		return MenuPanel;
		
	}
	
	private JPanel createScoreBoardPanel() {
		
		JPanel ScoreBoard = new JPanel();
		
		return ScoreBoard;
		
	}
	
	private void resize(ImageIcon grafico, JLabel label) {
		
		Image imagen = grafico.getImage();
		
		if(imagen != null) {
			Image nuevaImagen = imagen.getScaledInstance(cellWidth, cellHeight, Image.SCALE_DEFAULT);
			grafico.setImage(nuevaImagen);
			label.setIcon(grafico);
			label.repaint();	
		}
		
	}
	
	private void resize(ImageIcon grafico, JLabel label, int width, int heigth) {
		
		Image imagen = null;
		
		if(grafico != null) {
			
			imagen = grafico.getImage();
			
			if(imagen != null) {
				
				Image nuevaImagen = imagen.getScaledInstance(width, heigth, Image.SCALE_DEFAULT);
				grafico.setImage(nuevaImagen);
				label.setIcon(grafico);
				
			} 
			
		} else {
		
			label.setIcon(null);
			
		} 
		
		label.repaint();	
		
	}
	
	
	public void paintCell(GraphicEntity nuevoGrafico, int posFila, int posColumna) {
		ImageIcon nuevaImagen = nuevoGrafico.getIcon();
		
		resize(nuevaImagen, BottomLayer[posFila][posColumna]);
	}
	
	public void paintPickup(GraphicEntity nuevoGrafico, int posFila, int posColumna) {
		
		paintPickup(nuevoGrafico, posFila, posColumna, 17, 17);
		
	}
	
	public void paintPickup(GraphicEntity nuevoGrafico, int posFila, int posColumna, int width, int height) {
		
		ImageIcon nuevaImagen = null;
		
		if(nuevoGrafico != null) {
			nuevaImagen = nuevoGrafico.getIcon();
		}
		
		resize(nuevaImagen, PickupLayer[posFila][posColumna], width, height);
		
	}
	
	public void paintCharacter(GraphicEntity nuevoGrafico) {
		ImageIcon nuevaImagen = nuevoGrafico.getIcon();
		
		//System.out.println("Painting Character");
		
		resize(nuevaImagen, mainCharacter);
	}
	
	public void createMainCharacterGraphic(CharacterElements.Role ch) {
		
		mainCharacter = new JLabel();
		mainCharacter.setBounds(ch.getPosX(), ch.getPosY(), ch.getWidth(), ch.getHeight());
		
		
		ImageIcon mainCharImg = ch.getGraphicEntity().getIcon(); 
		
		
		mainCharImg.setImageObserver(mainCharacter);
		
		mainCharacter.setIcon(mainCharImg);
		
		paintCharacter(ch.getGraphicEntity());
		
		CharacterLayerPanel.add(mainCharacter);
		
	}
	
	
	public void displaceCharacter(int posX, int posY, int width, int height) {
		
		mainCharacter.setBounds(posX, posY, width, height);
		
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
		
		game = g;
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		
		nextlvlButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.getLevel().passLevel(cellHeight, cellWidth);
				obtainFocus();
			}
		});
		
		
		TEST_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.printScores();
				obtainFocus();
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					game.changeDirection(Directions.getUp(), game.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.changeDirection(Directions.getDown(), game.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.changeDirection(Directions.getLeft(), game.getPacMan());
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.changeDirection(Directions.getRight(), game.getPacMan());
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




