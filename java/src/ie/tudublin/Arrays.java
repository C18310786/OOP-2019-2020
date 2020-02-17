package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{	

	//one way to make array
	// float[] rainfall = new float[12];

	//second way to make array;
	float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		int min = 0;
		int max = 0;
		float average = 0;

		for(int i = 0; i < rainfall.length; i++)
		{
			println(months[i] + "\t" + rainfall[i]);
		}

		for(int j = 0; j < rainfall.length; j++)
		{
			if(rainfall[min] < rainfall[j])
			{
				min = j;
				
			}

			if(rainfall[max] > rainfall[j])
			{
				max = j;
			}

			average = average + rainfall[j];
		}
		println("Min month for rainfall = " + months[min] + ": " + rainfall[min]);
		println("Max month for rainfall = " + months[max] + ": " + rainfall[max]);
		println("Average = " + average / 12);

		// for(float f:rainfall)
		// {
		// 	println(f);
		// }

		// for(String s:months)
		// {
		// 	println(s);
		// }
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
		DrawBarchart();

	}

	public void DrawBarchart()
	{
		float x = 0;
		float y = height;
		float w = width / (float) rainfall.length;
		float h = 0;
		float cGap = 255 / (float) rainfall.length;

		for(int i = 0; i < rainfall.length; i++)
		{
			x = i * w;
			h = rainfall[i];
			fill(i * cGap, 255, 255);
			rect(x, y, w, -h * 3);
			
		}
	}
}
