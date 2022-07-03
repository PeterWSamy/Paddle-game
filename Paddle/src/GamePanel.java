/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author minaa
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 40;
	static final int PADDLE_WIDTH = 50;
	static final int PADDLE_HEIGHT = 50;
	static final int Keeper_WIDTH = 25;
	static final int Keeper_HEIGHT = 100;
	Thread gameThread,thread1,thread2;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Keeper keeper;
	Ball ball;
	Score score;
        int state1 = 0;
        int state2 = 0;
	
	GamePanel(){
		newPaddles();
		newBall();
		newKeeper();
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
                
                
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPaddles() {
		paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1,state1);
		paddle2 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2,state2);
                
                thread1 = new Thread(paddle1);
                thread2 = new Thread(paddle2);
                
                
                if(paddle2.getState() == 1 || paddle1.getState() == 0 || paddle1.getState() == 2 ){
                   paddle1.play();
                   paddle2.done();
                    try{
                             thread2.sleep(2000);
                        }catch(Exception e){
                            System.out.println(e);
                            }
                }
              
                else if(paddle1.getState() == 1 && paddle2.getState() == 2){
                    paddle1.done();
                    paddle2.play();
                    
                    try{
                             thread1.sleep(2000);
                        }catch(Exception e){
                            System.out.println(e);
                            }
                
                }
                
                

		// paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
		
	}
	public void newKeeper(){
		random = new Random();
		keeper = new Keeper(GAME_WIDTH-Keeper_WIDTH,(GAME_HEIGHT/2)-(Keeper_HEIGHT/2),Keeper_WIDTH,Keeper_HEIGHT);
                
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		keeper.draw(g);
		ball.draw(g);
		score.draw(g);
Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation

	}
	public void move() {
		
                
                paddle1.move();   
              
                paddle2.move();
                
		keeper.move(ball.y);
		ball.move(ball.xVelocity,ball.yVelocity,keeper);
	}
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		// if(ball.y <=0) {
		// 	ball.setYDirection(-ball.yVelocity);
		// }
		// if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
		// 	ball.setYDirection(-ball.yVelocity);
		// }
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			// if(ball.yVelocity>0)
			// 	ball.yVelocity++; //optional for more difficulty
			// else
			// 	ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(paddle1.getYVelocity());
                       // ball.move(paddle1.getXVelocity(), paddle1.getYVelocity());
		}
                if(ball.intersects(paddle2) ) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			// if(ball.yVelocity>0)
			// 	ball.yVelocity++; //optional for more difficulty
			// else
			// 	ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(paddle2.getYVelocity());
                       // ball.move(paddle1.getXVelocity(), paddle1.getYVelocity());
		}
		//bounce ball of keeper
		if(ball.intersects(keeper)) {
                    /*
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--; 
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);

                    */
                    
                    
                        
                        
                      /*  if(paddle1.getState() == 1){
                        paddle1.done();
                        paddle2.play();
                        
                        
                        }
                        if(paddle2.getState() == 1){
                        paddle2.done();
                        paddle1.play();
                        

                    }*/
                    state1 = paddle1.getState();
                    state2 = paddle2.getState();
                    
                    
                    newBall();
                    score.player2++;
                    newPaddles();
                    System.out.println("Player 2: "+score.player2);
                    
                    
                    

		}
		//stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(paddle1.x<=0)
			paddle1.x=0;
		if(paddle1.x >= (GAME_WIDTH-PADDLE_WIDTH)/2)
			paddle1.x = (GAME_WIDTH-PADDLE_WIDTH)/2;

		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		// stops keeper at window edge
		if(keeper.y<=0)
			keeper.y=0;
		if(keeper.y >= (GAME_HEIGHT-Keeper_HEIGHT))
			keeper.y = GAME_HEIGHT-Keeper_HEIGHT;
		//give a player 1 point and creates new paddles & ball
		if(ball.x <=0) {
			score.player2++;
			newPaddles();
			newBall();
			System.out.println("Player 2: "+score.player2);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
                        
                        
                        /*
                        if(paddle1.getState() == 1){
                        paddle1.done();
                        paddle2.play();
                        
                        
                        }
                        if(paddle2.getState() == 1){
                        paddle2.done();
                        paddle1.play();
                    }*/
                    state1 = paddle1.getState();
                    state2 = paddle2.getState();
                    
                    newBall();
                    score.player1++;
                    newPaddles();
                    System.out.println("Player 1: "+score.player1);
                        
		}
                
                // ball collision with the game frame
                if(ball.y >= GAME_HEIGHT-BALL_DIAMETER/2 ) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--; 
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(-ball.yVelocity);
		}
                if(ball.y < 0 ) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--; 
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(-ball.yVelocity);
		}
                
	}
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
                    
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
			// keeper.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
			// keeper.keyReleased(e);
		}
	}
}
