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

public class Paddle extends Rectangle implements Runnable{

	int id;
        private int state = 0 ;
	int yVelocity;
	int xVelocity;
	int speed = 10;
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id,int states){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id=id;
                this.state = states;
	}
	
	public void keyPressed(KeyEvent e) {
            
		//switch(id) {
		//case 1:
                if(state == 1){
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_A) {
				setXDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
				setXDirection(speed);
			}
                }
		//	break;
		//case 2:
			 /*
                        if(e.getKeyCode()==KeyEvent.VK_UP) {
			 	setYDirection(-speed);
			 }
			 if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			 	setYDirection(speed);
			 }
                         if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			 	setXDirection(-speed);
			 }
			 if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			 	setXDirection(speed);
			 }
			break;
                    */
		//}
            
	}
	public void keyReleased(KeyEvent e) {
           
		//switch(id) {
		//case 1:
                if(state == 1){
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_A) {
				setXDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
				setXDirection(0);
			}
                }
		//	break;
		//case 2:
                    /*
			 if(e.getKeyCode()==KeyEvent.VK_UP) {
			 	setYDirection(0);
			 }
			 if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			 	setYDirection(0);
			 }
                         if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			 	setXDirection(0);
			 }
			 if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			 	setDirection(0);
			 }
			break;*/
		//}
            
	}
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void setXDirection(int xDirection) {
		xVelocity = xDirection;
	}
        
	public void move() {
		y+=yVelocity;
		x+=xVelocity;

	}
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
        public void run(){
        }
        public void play(){
            state = 1;
        }
        public void done(){
            state = 2;
        }
        public void sleep(){
            state = 0;
        }
        public int getState(){
            return state;
        }
        ///
        public int getYVelocity() {
		return yVelocity ;
	}
	public int getXVelocity() {
		return xVelocity ;
	}
}

    

 
