import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	Ball(int x, int y, int width, int height){
		super(x,y,width,height);
		
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
