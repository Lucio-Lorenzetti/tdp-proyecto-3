package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameLogic.Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	private Font gameFont;
	
	
	private JPanel BottomLayerPanel;
	private JPanel PickupLayerPanel;
	private JPanel CharacterLayerPanel;
	private JPanel contentPane;
	private JPanel panel;
	
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
		
		
		this.setFocusable(true);
		this.requestFocus();
		
		
		gameFont = null;

		/*
		gameFont = loadFont("/Fonts/text-font.ttf", 16f);
		*/
		
		gridHeight = 20;
		gridWidth = 20;
		
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
			
				ImageIcon iconoLabel = new ImageIcon(this.getClass().getResource("/Images/road.png"));
				
				temp.setIcon(iconoLabel);
				
				resize(iconoLabel, temp);
				
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
		
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					game.doMoveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.doMoveDown();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.doMoveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.doMoveRight();
				}
			}
		});
		
		
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
			//grafico.setImageObserver(label);
			label.setIcon(grafico);
			label.repaint();	
		}
	}
	
	
	public void paintCell(GraphicEntity nuevoGrafico, int posFila, int posColumna) {
		ImageIcon nuevaImagen = nuevoGrafico.getGrafico();
		
		resize(nuevaImagen, BottomLayer[posFila][posColumna]);
	}
	
	public void paintPickup(GraphicEntity nuevoGrafico, int posFila, int posColumna) {
		
		ImageIcon nuevaImagen = nuevoGrafico.getGrafico();
		
		resize(nuevaImagen, PickupLayer[posFila][posColumna]);
		
	}
	
	public void paintCharacter(GraphicEntity nuevoGrafico) {
		ImageIcon nuevaImagen = nuevoGrafico.getGrafico();
		
		System.out.println("Painting Character");
		
		resize(nuevaImagen, mainCharacter);
	}
	
	public void createMainCharacterGraphic(CharacterElements.Character ch) {
		
		System.out.println("MC col: " + ch.getColumn());
		System.out.println("MC row: " + ch.getRow());
		System.out.println("MC width: " + ch.getWidth());
		System.out.println("MC height: " + ch.getHeight());
		
		mainCharacter = new JLabel();
		mainCharacter.setBounds(ch.getColumn(), ch.getRow(), ch.getWidth(), ch.getHeight());
		
		System.out.println("MC lbl col: " + mainCharacter.getAlignmentX());
		System.out.println("MC lbl row: " + mainCharacter.getAlignmentY());
		System.out.println("MC lbl width: " + mainCharacter.getWidth());
		System.out.println("MC lbl height: " + mainCharacter.getHeight());
		
		ImageIcon mainCharImg = ch.getGraphicEntity().getGrafico(); 
		
		mainCharImg.setImageObserver(mainCharacter);
		
		mainCharacter.setIcon(mainCharImg);
		
		paintCharacter(ch.getGraphicEntity());
		
		CharacterLayerPanel.add(mainCharacter);
		
	}
	
	
	public void displaceCharacter(int posX, int posY, int width, int height) {
		//mainCharacter.setAlignmentX(posX);
		//miamainCharacter.setAlignmentY(posY);
		
		mainCharacter.setBounds(posX, posY, width, height);
		
	}
	
	
	private void setBackground(){

		ImageIcon fondo = new ImageIcon(this.getClass().getResource("/Images/backgrounds/background5.gif"));
		

	
		Image imagen = fondo.getImage();
		
		

		
		if(imagen != null) {
			Image nuevaImagen = imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
			fondo.setImage(nuevaImagen);
		}
		
		
		JLabel background = new JLabel("" ,fondo , JLabel.CENTER);
	
		
		fondo.setImageObserver(background);
		
		
		background.setBounds(0, 0, this.getWidth(), this.getHeight());

		getContentPane().add(background);
	
		background.repaint();
		


	}
	
	
	public void setGame(Game g) {
		game = g;
		
		JButton nextlvlButton = new JButton("Siguiente Nivel");
		nextlvlButton.setBounds(0, 109, 218, 95);
		panel.add(nextlvlButton);
		nextlvlButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.getLevel().passLevel(cellHeight, cellWidth);
				obtainFocus();
			}
		});
		
		
		
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




