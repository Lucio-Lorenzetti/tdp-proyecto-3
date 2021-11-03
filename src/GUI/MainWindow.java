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

public class MainWindow {

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
		
		
		gameFont = null;

		/*
		gameFont = loadFont("/Fonts/text-font.ttf", 16f);
		*/
		
		gridHeight = 20;
		gridWidth = 20;
		
		BottomLayer = new JLabel[gridHeight][gridWidth];
		PickupLayer = new JLabel[gridHeight][gridWidth];
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 724, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PickupLayerPanel = createGamePanel();
		BottomLayerPanel = createGamePanel();
		
		PickupLayerPanel.setOpaque(false);
		BottomLayerPanel.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(480, 25, 218, 448);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(0, 11, 218, 14);
		panel.add(lblNewLabel);
		if(gameFont != null) {
			lblNewLabel.setFont(gameFont);
		}
		
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
		
		
		
		frame.setVisible(true);
		
		
	}
	
	private JPanel createGamePanel() {
		
		JPanel GamePanel = new JPanel();
		GamePanel.setBounds(22, 25, 448, 448);
		frame.getContentPane().add(GamePanel);
		GamePanel.setLayout(new GridLayout(gridHeight, gridWidth, 0, 0));
		
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
			Image nuevaImagen = imagen.getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH);
			grafico.setImage(nuevaImagen);
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
	
	public void setGame(Game g) {
		game = g;
	}

	/*
	public static Font loadFont(String path, float size){   
		
		try {
			URL fontUrl = new URL("/Fonts/textfont.ttf");
	        Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
	        
	        customFont = customFont.deriveFont(16f);
	        
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(customFont);
		    return customFont; 
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		return null;
    }*/
	
	
}




