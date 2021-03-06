/*
	Isabella Moreira
	July 24, 2013
	COP 3330: Professor Eisler
	
	Description
	===========
	Classic Asteroids game with GUI interface
	
	Includes:
		- Sound effects
		- Scoring mechanism
		- Multiple levels with easy additional configurations
		
	File
	====
	LargeComet.java
		- Comet with a radius of 40
		- Top of hierarchy
*/



//package import
package comets;
//standard Java import
import java.util.*;

public class LargeComet extends Comet{

	//Class constructor
	public LargeComet(double xPos, double yPos, 
					  double xVel, double yVel) {
		super(xPos, yPos, xVel, yVel, 40);
	}
	
	//generate random angle
	//generate random speed
	//calculate xVel and yVel
	// 100 <= xVel^2 + yVel^2
	//
	// s=sqrt(vx^2+vy^2) 
	// s^2 = vx^2 + vy^2
	public java.util.Vector<Comet> explode(){
		Vector <Comet> v = new Vector();
		Random rand = new Random(5);	// 0-9 for max speed
		
		//speed of the new comets
		double actualSpeed = 0;
		
		//boolean for negative velocity
		int xNeg, yNeg;
		
		//velocities of the new comets
		double newxVel1, newyVel1;
		for(int i = 0; i < 2; i++){
			//1 = negative, 0 = positive
			xNeg = 0 + (int)(Math.random() * ((1 - 0) + 1));
			yNeg = 0 + (int)(Math.random() * ((1 - 0) + 1));
			
			do{
				//generate the x velocity
				newxVel1 = 1 + (Math.random() * ((5 - 1) + 1));
				//the y velocity is just the difference
				newyVel1 = 1 + (Math.random() * ((5 - 1) + 1));
				
				while(newxVel1 == 0.0 || newyVel1 == 0) continue;
		
				//speed, according to the formula
				actualSpeed = Math.sqrt(Math.pow(newxVel1, 2) + Math.pow(newyVel1, 2));
			} while(actualSpeed > 3);
			
			//negate if necessary
			if(xNeg == 1) newxVel1*= -1;
			if(yNeg == 1) newyVel1*= -1;
			
			//create the comets
			v.add(new MediumComet(xPosition, yPosition, newxVel1, newyVel1));
		}
		
		return v;
	}
}
