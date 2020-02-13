package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		
	}

	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	

	// Draw 3 lines
	// public void draw()
	// {	
	// 	background(0);		
	// 	stroke(255);
	// 	line(10, 10, 100, 10);
	// 	line(10, 20, 100, 20);
	// 	line(10, 30, 100, 30);
	// 	line(10, 40, 100, 40);

	// 	for(int y = 10 ; y <= 40 ; y += 10)
	// 	{
	// 		line(200, y, 300, y);
	// 	}

	// 	int yy = 10;
	// 	while(yy <= 40)
	// 	{
	// 		line(300, yy, 400, yy);
	// 		yy += 10;
	// 	}
		
	
	// }

	public void draw()
	{
		// LineXThing();
		// CirclesinLine();
		// Rainbow();
		// Circle();
		// BattleShip();
		// Cone();
		// checkbox();
		// LineXThingSolution();
		// CirclesSolution();
		// CirclesAcrossScreen();
		BattleShipSolution();
	}


	public void LineXThingSolution()
	{
		background(0);
		stroke(255);
		int numLines = (int) (30 * (mouseX / (float) width));
		float gap = mouseX / (float)numLines;
		for(int i = 0; i <= numLines; i++)
		{
			float x = i * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height - x);
		}

	}

	public void CirclesSolution()
	{
		background(0);
		noStroke();
		int numCircles = (int) (30 * (mouseX / (float) width));

		float w = width / (float) numCircles;
		float radius = w / 2.0f;

		colorMode(HSB);
		float cGap = 255 / (float) numCircles;

		for(int i = 0; i < numCircles; i++)
		{
			float x = radius +( i * w);
			fill(cGap * i, 255, 255);
			ellipse(x, height / 2, w, w);
		}
	}

	float offset = 0;

	public void CirclesAcrossScreen()
	{
		background(0);
		noStroke();
		int numCircles = (int) (30 * (mouseX / (float) width));

		float w = width / (float) numCircles;
		float radius = w / 2.0f;

		colorMode(HSB);
		float cGap = 255 / (float) numCircles;

		for(int j = 0; j < numCircles; j++)
		{
			for(int i = 0; i < numCircles; i++)
			{
				float x = radius +( i * w);
				float y = radius +( j * w);
				float c = (cGap * i * j + offset) % 255;
				fill(c , 255, 255);
				ellipse(x, y, w, w);
			}
		}
		offset += 1;
	}


	public void BattleShipSolution()
	{
		float gap = width * 0.1f;
		float halfGap = gap / 2.0f;
		background(0);
		colorMode(RGB);
		stroke(0, 255, 0);
		textAlign(CENTER, CENTER);

		for(int i = -5; i <= 5; i++)
		{
			float x = 	map(i, -5, 5, gap, width - gap);
			line(x, gap, x, height - gap);
			line(gap, x, width - gap, x);
			fill(255);
			text(i, x, halfGap );
			text(i, halfGap, x);
		}
	}

	// Line x thing
	public void LineXThing()
	{
		int x = 250;
		int x2 = 0;
		int y = 250;
		int y2 = 0;
		int count = 0;
		background(240, 240, 240);
		stroke(0);

		while(count != 2010)
		{
			if(count <= 500)
			{
				line(x, y, x2, y2);
				y2 += 10;
			}

			if(count <= 1000 && count >= 500)
			{
				line(x, y, x2, y2);
				x2 += 10;
			}

			if(count <= 1500 && count >= 1000)
			{
				line(x, y, x2, y2);
				y2 -= 10;
			}

			if(count <= 2010 && count >= 1500)
			{
				line(x, y, x2, y2);
				x2 -= 10;
			}
			

			count += 10;
		}
	}

	// circles in a line
	public void CirclesinLine() 
	{
		background(240, 240, 240);
		stroke(0);
		int x = 25;
		int y = height/2;
		
		
		for(int i = 0; i < 500; i += 30)
		{
			ellipse(x, y, 50, 50 );
			x += 50;
		}
	}

	//rainbow
	public void Rainbow()
	{
		float r = 255;
		float g = 0;
		float bl = 0;

		int a = 0;
		int b = 0;
		int c = 50;
		int d = 500;

		int count1 = 0;

		background(240, 240, 240);
		while(a != 500)
		{
			fill(r, g, bl);
			rect(a, b, c, d);
			a += 50;
			if(r == 255)
			{
				g += 127.5;
				count1++;
			}

			if(count1 > 2)
			{
				r -= 127.5;
				count1++;
			}

			if(count1 > 5)
			{
				bl += 127.5;
				count1++;
			}

			if(count1 > 7)
			{
				g -= 127.5;
			}

			
		}
		
	}

	//rainbow circle
	public void Circle()
	{
		float r = 255;
		float g = 0;
		float bl = 0;

		
		int count1 = 0;

		background(240, 240, 240);
		
			int x = 25;
			int y = height/2;
		
		
			for(int i = 0; i < 500; i += 30)
			{
				fill(r, g, bl);
				ellipse(x, y, 50, 50 );
				x += 50;
				
				if(r == 255)
				{
					g += 127.5;
					count1++;
				}

				if(count1 > 2)
				{
					r -= 127.5;
					count1++;
				}

				if(count1 > 5)
				{
					bl += 127.5;
					count1++;
				}

				if(count1 > 7)
				{
					g -= 127.5;
				}
			}
		
	}


	//battle ship
	public void BattleShip()
	{
		int num = -5;
		int numx = 35;
		int numy = 45;
		background(0);
		fill(255, 255, 255);
		textSize(10);
		for(int k = 0; k < 440; k += 40)
		{
			text(num, numx, 20);
			text(num, 10, numy);
			num ++;
			numx += 40;
			numy += 40;
		}
		stroke(0, 255, 0);
		fill(0);
		int x = 40;
		int y = 40;
		for(int j = 0; j < 400; j += 40)
		{
			for(int i = 0; i < 400; i += 40)
			{
				rect(x, y, 40, 40);
				x += 40;
			}
			x = 40;
			y += 40;
		}	
		
	}

	//cone thing
	public void Cone()
	{
		background(240);
		float a = 200;
		int b = 60;
		float x = width/2 - a/2;
		int y = 10;
		
		for(int i = 0; i < 5; i++)
		{

			rect(x, y, a, b);
			x = x + 20;
			y = y + b;
			a = a - 40;
		}

	}


	//circle gradient
	// too muchg effort


	// checkbox
	public void checkbox()
	{
		int x = 0;
		int y = 0;
		int a = 25;
		int b = 25;
		int swap = 1;

		for(int i = 0; i < height; i += 25)
		{
			for(int j = 0; j < width; j += 50)
			{
				if(swap == 1)
				{
					fill(0, 0, 255);
					rect(x, y, a, b);
					x += 25;
					fill(0, 15, 92);
					rect(x, y, a, b);
					x += 25;
				}
				else if(swap == -1)
				{
					fill(0, 15, 92);
					rect(x, y, a, b);
					x += 25;
					fill(0, 0, 255);
					rect(x, y, a, b);
					x += 25;
				}
				
			}
			swap = swap *-1;
			y += 25;
			x = 0;
		}
	}
}
