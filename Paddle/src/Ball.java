/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author minaa
 */
import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	Ball(int x, int y, int width, int height){
		super(x,y,width,height);
		// random = new Random();
		// int randomXDirection = random.nextInt(2);
		// if(randomXDirection == 0)
		// 	randomXDirection--;
		// setXDirection(randomXDirection*initialSpeed);
		
		// int randomYDirection = random.nextInt(2);
		// if(randomYDirection == 0)
		// 	randomYDirection--;
		// setYDirection(randomYDirection*initialSpeed);
		
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move(int xVelocity2,int yVelocity2,Keeper keeper) {
            
            x += xVelocity2;
            y += yVelocity2;
    
            	
                

	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}
