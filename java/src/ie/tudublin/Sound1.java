package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class Sound1 extends PApplet
{	
	Minim minim;
	AudioInput ai;

	public void settings()
	{
		size(1024, 500);
	}

	public void setup() 
	{
		minim = new Minim(this);
		ai = minim.getLineIn(Minim.MONO, width, 44100, 16);

		colorMode(HSB);
	}

	
	public void draw()
	{	
		// background(0);		
		// stroke(255);
		// float cy = height / 2;
		
		// for(int i = 0 ; i < ai.bufferSize() ; i ++)
		// {
		// 	stroke(
		// 		map(i, 0, ai.bufferSize(), 0, 255)
		// 		, 255
		// 		, 255
		// 	);
		// 	line(i, cy, i, cy + ai.left.get(i) * cy);
		// }

		background(0);
		float cy = height / 2;
		float cx = width / 2;
		float average = 0;
		float sum = 0;
		for(int i = 0 ; i < ai.bufferSize() ; i ++)
		{
			fill(
				map(i, 0, ai.bufferSize(), 0, 255)
				, 255
				, 255
			);
			sum = abs(sum + ai.left.get(i));
		}
		average = sum / ai.bufferSize();
		float diameter = average * 1000;
		ellipse(cx, cy, diameter, diameter);
	}
}
