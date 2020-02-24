package ie.tudublin;

import java.util.Arrays; 
import java.util.Collections; 

import processing.core.PApplet;

public class ArraysExample extends PApplet
{	

	//float[] rainFall = new float[12]; 
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			println(months[i] + "\t" + rainFall[i]);
		}

		for(float f:rainFall)
		{
			println(f);
		}

		for(String s:months)
		{
			println(s);
		}

		int minIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}
		println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]);
		
		int maxIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}
		println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);

		// You can also calculate the minimum and max of an arry this way:
		// Note the array is of type Float not float
		// Float are objects float is a primitive type
		Float[] floatArray = {10.0f, 5.0f, 20.0f};
		float min = Collections.min(Arrays.asList(floatArray)); 
        float max = Collections.max(Arrays.asList(floatArray));
	}

	void drawBarChart()
	{
		float w = width / (float) rainFall.length;
		float cGap = 255 / (float) rainFall.length;
		noStroke();
		colorMode(HSB);
		for(int i = 0 ; i < rainFall.length ; i ++)
		{
			float x = i * w;
			fill(i * cGap, 255, 255);
			rect(x, height, w, -rainFall[i]);
		}
	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	

	public void draw()
	{	
		background(0);		
		colorMode(HSB);	

		// DrawLine();
		pieChart();
		
	}

	void pieChart()
	{
		fill(255);
		stroke(255);
		int x1 = 250;
		int y1 = 250;
		int x2 = 400;
		int y2 = 400;

		float percentage = 0f;
		float previous_position = 0f;
		float total_months = 0f;

		for(int j = 0; j < months.length - 1; j ++)
		{
			total_months = total_months + rainFall[j];
		}

		for(int i = 0; i < months.length - 1; i ++)
		{
			// float x = map(i, 0, months.length - 1, 0, 2*PI);
			percentage = rainFall[i] / total_months;
			arc(x1, y1, x2, y2, previous_position, percentage);
			previous_position = percentage;
		}
	}

	void DrawLine()
	{
		float border = width * 0.10f;

		textAlign(CENTER, CENTER);
		fill(255);
		stroke(255);
		line(border, border, border, height - border);
		for(int ya = 0; ya <= 150; ya += 10)
		{
			float y = map(ya, 0, 150, height - border, border);
			line(border, y, border - 5, y);
			text(ya, border / 2, y);

		}

		line(border, height - border, width - border, height - border);
		for(int xa  = 0; xa < months.length; xa ++)
		{
			float x = map(xa, 0, months.length - 1, border, width - border);
			line(x, height - border, x, height - (border - 5));
			text(months[xa], x, height - border / 2);
		}

		for(int i = 0; i < rainFall.length - 1; i++)
		{
			float x1 = map(i, 0, months.length - 1, border, width - border);
			float x2 = map(i + 1, 0, months.length - 1, border, width - border);

			float y1 = map(rainFall[i], 0, 150, height - border, border);
			float y2 = map(rainFall[i] + 1, 0, 150, height - border, border);

			line(x1, y1, x2, y2);
		}

		// float gap = width * 0.1f;
		// float halfGap = gap / 2.0f;
		// colorMode(RGB);
		// stroke(255, 255, 255);
		// textAlign(CENTER, CENTER);
		// for(int i = 0 ; i <=150 ; i += 10)
		// {
		// 	float x = map(i, 150, 0, gap, width -gap);				
		// 	line(halfGap + 20, x, halfGap + 25, x);
		// 	fill(255);
		// 	// text(i, x, halfGap);
		// 	text(i, halfGap, x);
			
		// }	
		// for(int j = 35; j < 455; j += 35)
		// {
		// 	float x = map(j, 420, 0, gap, width -gap);	
		// 	line(x, halfGap + 425, x, halfGap + 435);
		// }

		// for(int m = 0; m < 12; m ++)
		// {
		// 	float x = map(m, 0, 12, gap, width -gap);	
		// 	text(months[m], x, 470);
		// }
		// line(50, gap, 50, height - gap);
		// line(gap, 450, height - gap, 450);
	}
}
