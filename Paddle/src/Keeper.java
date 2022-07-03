import java.awt.*;
import java.util.*;
import java.awt.event.*;
import static java.lang.Math.abs;

public class Keeper extends Rectangle{

    Random random;
	int yVelocity;
	int speed = 1;
	
	Keeper(int x, int y, int Keeper_WIDTH, int Keeper_HEIGHT){
		super(x,y,Keeper_WIDTH,Keeper_HEIGHT);
        random = new Random();
		 int yDirection = random.nextInt(2);
	if(yDirection == 0)
          setYDirection(-speed);
        else    
           setYDirection(speed);
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move(int Yball) {
                    if(y > Yball)
                        y -= abs(yVelocity);
                    
                    else if (y < Yball)
                        y += abs(yVelocity);
                    
                    
                    
                
                
	}
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
	}
}