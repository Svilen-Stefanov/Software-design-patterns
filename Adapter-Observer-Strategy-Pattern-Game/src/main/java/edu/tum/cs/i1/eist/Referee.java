package edu.tum.cs.i1.eist;

import java.applet.AudioClip;

import javax.swing.JOptionPane;

import edu.tum.cs.i1.eist.car.Car;


public class Referee implements Runnable {
	
	public static AudioClip MUSIC;
	public static AudioClip BANG;
	
	private static int SLEEP_TIME = 200;

	private Thread theThread;
    private boolean isRunning;
    
    private GameBoard gameBoard;
	
	private CollisionStrategy collisionStrategy = new DefaultCollision();

	Referee(GameBoard gameBoard){
		setFramesPerSecond(25);
		this.gameBoard = gameBoard;
		this.gameBoard.setup();
	}
	
	public void startGame() {
		if(isRunning){ return;}
		MUSIC.loop();
		isRunning = true;
		theThread = new Thread(this);
		theThread.start();
		gameBoard.game.toolBar.enableButtons();
	}
	
    public void stopGame() {
		if(!isRunning){ return;}
		MUSIC.stop();
		isRunning = false;
		gameBoard.game.toolBar.enableButtons();
    }
	
	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(SLEEP_TIME);
			}
			catch (InterruptedException e) { e.printStackTrace(); }
			moveCars();
		}
	}
	
	private void moveCars() {
		Car[] cars = gameBoard.getCars();
		
		int max_x = gameBoard.getSize().width;
		int max_y = gameBoard.getSize().height;
		
		for (int i = 0; i < cars.length; i++) {
			cars[i].updatePosition(max_x, max_y);
		}
		gameBoard.userCar.updatePosition(max_x, max_y);
		gameBoard.repaint();
		
		Car userCar = gameBoard.userCar;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].isCrunched( )) {continue;}
			
			Car crashedCar = collisionStrategy.detectCollision(userCar, cars[i]);
			if(crashedCar != null){
				BANG.play();
				crashedCar.setCrunched();
				if(userCar.isCrunched()){
					stopGame();
					JOptionPane.showMessageDialog(null,
												  "You lost the game!",
												  "Information",
												  JOptionPane.INFORMATION_MESSAGE);
					gameBoard.setup();
				}else{
					boolean playerWon = true;
					for (int z = 0; z < cars.length; z++) {
						playerWon = playerWon && cars[z].isCrunched();
						if(!playerWon){ break; }
					}
					if(playerWon){
						stopGame();
						JOptionPane.showMessageDialog(null,
													  "Congratulation, You win the game!",
													  "Information",
													  JOptionPane.INFORMATION_MESSAGE);
						gameBoard.setup();
					}
				}
			}
		}
	}
	
	public boolean isRunning(){
		return this.isRunning;
	}
	
	public static int getFramesPerSecond(){
		return 1000 / SLEEP_TIME;
	}
	
	public static void setFramesPerSecond(int framesPerSecond) throws IllegalArgumentException {
		if(framesPerSecond > 0){
			SLEEP_TIME = 1000 / framesPerSecond;
		}else{
			throw new IllegalArgumentException("Frames per second must be greater than 0.");
		}
	}
	
	
	public void setCollisionStrategy(CollisionStrategy collisionStrategy) {
		this.collisionStrategy = collisionStrategy;
	}
	
	public CollisionStrategy getCollisionStrategy() {
		return collisionStrategy;
	}
}