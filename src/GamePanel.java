package main;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;


public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed=60;

	public GamePanel() {

		mouseInputs = new MouseInputs(this);
		
		importImg();
		loadAnimations();
		
		
		setPanelSize();
		
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

		
	}
	private void loadAnimations() {
		animations = new BufferedImage[8][5];
		
		for(int j =0; j<animations.length;j++) {
		for(int i = 0; i<animations[j].length; i++ ) {
			animations[j][i]= img.getSubimage(i*53,j* 83, 53, 83);
		}
		}
	}
	
		
	
	
	private void importImg() {
		//InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		InputStream is = getClass().getResourceAsStream("/MIKE.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		}
//sets the panel size
	private void setPanelSize() { 
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}
	
	
	
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		
		//like paint componment and drawing again 
	}

	public void changeYDelta(int value) {
		this.yDelta += value;
		
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		
	}

	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	updateAnimationTick();
	
		g.drawImage(animations[1][aniIndex],(int)xDelta,(int)yDelta,61,83,null);
		
		
		
	}
	private void updateAnimationTick() {
		
		aniTick++;
		  if(aniTick>=aniSpeed){
		  aniTick = 0;
		  aniIndex++;
		  if(aniIndex >= 5)
		  aniIndex = 0;
		 
		}
	}
	}
		
		
	



