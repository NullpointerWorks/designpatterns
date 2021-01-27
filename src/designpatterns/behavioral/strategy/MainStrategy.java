package designpatterns.behavioral.strategy;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Strategy Pattern
 * 
 * This is more complicated example to demonstrate this pattern. The Graph
 * class generates JLabels which contains a graph of points connected using
 * an interpolation technique. The method of interpolation can be selected
 * using a strategy implementation.
 * 
 * 
 * 
 */
public class MainStrategy 
{
	public static void main(String[] args) 
	{
		GraphGenerator gg = new GraphGenerator(320, 240);
		
		float[] yPoints = new float[10];
		for (int n=9;n>=0;n--) yPoints[n] = (float)(20.0 + Math.random()*200.0);
		
		gg.setStrategy( new LinearInterpolation() );
		ImageIcon lin = gg.generateImage(yPoints);
		
		gg.setStrategy( new CosineInterpolation() );
		ImageIcon cos = gg.generateImage(yPoints);
		
		gg.setStrategy( new CubicInterpolation() );
		ImageIcon cub = gg.generateImage(yPoints);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add( new JLabel(lin) );
		panel.add( new JLabel(cos) );
		panel.add( new JLabel(cub) );
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setTitle("Strategy Pattern For Interpolation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

/*
 * define a strategy interface with a single method
 */
interface Strategy
{
	float interpolate(float y0, float y1, float y2, float y3, float lerp);
}

/*
 * linear interpolation
 */
class LinearInterpolation implements Strategy
{
	@Override
	public float interpolate(float y0, float y1, float y2, float y3, float lerp) 
	{
		return y1 + (y2-y1)*lerp;
	}
}

/*
 * trigonometric interpolation
 */
class CosineInterpolation implements Strategy
{
	private final double PI = 3.1415;
	
	@Override
	public float interpolate(float y0, float y1, float y2, float y3, float lerp) 
	{
		float mu = (float)((1.0 - Math.cos(lerp*PI)) * 0.5);
		return y1 + (y2-y1)*mu;
	}
}

/*
 * cubic spline interpolation
 */
class CubicInterpolation implements Strategy
{
	@Override
	public float interpolate(float y0, float y1, float y2, float y3, float mu) 
	{
		float a0,a1,a2,a3,mu2 = mu*mu;
		
		// calculate spline
		a0 = -0.5f*y0 + 1.5f*y1 - 1.5f*y2 + 0.5f*y3;
		a1 =       y0 - 2.5f*y1 +   2f*y2 - 0.5f*y3;
		a2 = -0.5f*y0 + 0.5f*y2;
		a3 =       y1;
		
		// return 3rd degree polynomial
		return (a0*mu*mu2 + a1*mu2 + a2*mu + a3);
	}
}

/*
 * graph generator
 */
class GraphGenerator
{
	private final int BLACK = 0x000000;
	private final int RED = 0xff0000;
	private int width;
	private int height;
	private Strategy lerpStrategy;
	
	public GraphGenerator(int w, int h)
	{
		width = w;
		height = h;
		lerpStrategy = new LinearInterpolation(); // default
	}
	
	public void setStrategy(Strategy st)
	{
		lerpStrategy = st;
	}
	
	public ImageIcon generateImage(float... yPoints)
	{
		BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] pix = ((DataBufferInt)canvas.getRaster().getDataBuffer()).getData();
		clear(pix, BLACK);
		
		int leng = yPoints.length;
		if (leng > 1)
		{
			float y0, y1, y2, y3;
			int xStart = 0;
			int xStep = width / (leng - 1);
			int xEnd = xStep;
			
			for (int p = 0, pl = leng - 1; p<pl; p++)
			{
				y0 = yPoints[ wrap(p-1, leng) ];
				y1 = yPoints[ wrap(p  , leng) ];
				y2 = yPoints[ wrap(p+1, leng) ];
				y3 = yPoints[ wrap(p+2, leng) ];
				lerp(y0,y1,y2,y3, xStart,xEnd, pix);
				xStart = xEnd;
				xEnd += xStep;
			}
		}
		
		return new ImageIcon(canvas);
	}
	
	private void lerp(	float y0, 
						float y1, 
						float y2, 
						float y3, 
						int xS, 
						int xE, 
						int[] pix)
	{
		float accum = 0f;
		float step = 1f/(float)(xE-xS);
		for (int x=xS; x<xE; x++)
		{
			float lerp = lerpStrategy.interpolate(y0, y1, y2, y3, accum);
			int y = height - round(lerp); // invert y to display mathematically correct
			pix[x + y*width] = RED;
			accum += step;
		}
	}
	
	private int round(float x) 
	{
		return (int)(x+0.5f);
	}
	
	private void clear(int[] p, int c)
	{
		for (int l=p.length-1; l>=0; l--) p[l] = c;
	}
	
	private int wrap(int x, int l) 
	{
		return (x+l)%l;
	}
}
