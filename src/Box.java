import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Box
{
	public static void main(String [] args)
	{
		myFrame frame=new myFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class myFrame extends JFrame
{
	public myFrame()
	{
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int x=(screenSize.width-DEFAULT_WIDTH)/2;
		int y=(screenSize.height-DEFAULT_HEIGHT)/2;
		setLocation(x,y);
		setIconImage(new ImageIcon("images/Box.png").getImage());
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		myPanel panel=new myPanel();
		add(panel);
	}
	private static final int DEFAULT_WIDTH=800;
	private static final int DEFAULT_HEIGHT=600;
}
class myPanel extends JPanel
{
	public myPanel()
	{
	    addKeyListener(listener);
	    setFocusable(true);
	    mapInit();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g2d=(Graphics2D)g;
		btnStart.setBounds(0,0,200,50);
		btnStartListener btnAction=new btnStartListener();
		btnStart.addActionListener(btnAction);
		add(btnStart);
		Image imgae0=tll.getImage("images/0.png");
		Image imgae1=tll.getImage("images/1.png");
		Image imgae2=tll.getImage("images/2.png");
		Image imgae3=tll.getImage("images/3.png");
		Image imgae4=tll.getImage("images/4.png");
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
			{
				if(map[i][j]==0)g.drawImage(imgae0,boundX+i*delta,boundY+j*delta,delta,delta,this);
				else if(map[i][j]==1)g.drawImage(imgae1,boundX+i*delta,boundY+j*delta,delta,delta,this);
				else if(map[i][j]==2)g.drawImage(imgae2,boundX+i*delta,boundY+j*delta,delta,delta,this);
				else if(map[i][j]==3||map[i][j]==-1)g.drawImage(imgae3,boundX+i*delta,boundY+j*delta,delta,delta,this);
				else g.drawImage(imgae4, boundX+i*delta,boundY+j*delta,delta,delta,this);
			}
		Image imgaeP=tll.getImage("images/p.png");
		g.drawImage(imgaeP,personX,personY,delta,delta,this);
	}
	class btnStartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			personX=400;
			personY=300;
			mapInit();
			repaint();
		}
	}
	private class KeyHandler implements KeyListener
	{
		public void keyPressed(KeyEvent event)
		{
			int keyCode=event.getKeyCode();
			if(keyCode==KeyEvent.VK_LEFT&&map[(personX-boundX-delta)/delta][(personY-boundY)/delta]!=1&&map[(personX-boundX-delta)/delta][(personY-boundY)/delta]!=-1)
			{
				if(map[(personX-boundX-delta)/delta][(personY-boundY)/delta]==3)
				{
					if(map[(personX-boundX-delta*2)/delta][(personY-boundY)/delta]==2)
					{
						map[(personX-boundX-delta)/delta][(personY-boundY)/delta]=2;
						map[(personX-boundX-delta*2)/delta][(personY-boundY)/delta]=3;
						personX-=delta;
					}
					else if(map[(personX-boundX-delta*2)/delta][(personY-boundY)/delta]==4)
					{
						map[(personX-boundX-delta)/delta][(personY-boundY)/delta]=2;
						map[(personX-boundX-delta*2)/delta][(personY-boundY)/delta]=-1;
						personX-=delta;
					}
				}
				else personX-=delta;
			}
			else if(keyCode==KeyEvent.VK_RIGHT&&map[(personX-boundX+delta)/delta][(personY-boundY)/delta]!=1&&map[(personX-boundX+delta)/delta][(personY-boundY)/delta]!=-1)
			{
				if(map[(personX-boundX+delta)/delta][(personY-boundY)/delta]==3)
				{
					if(map[(personX-boundX+delta*2)/delta][(personY-boundY)/delta]==2)
					{
						map[(personX-boundX+delta)/delta][(personY-boundY)/delta]=2;
						map[(personX-boundX+delta*2)/delta][(personY-boundY)/delta]=3;
						personX+=delta;
					}
					else if(map[(personX-boundX+delta*2)/delta][(personY-boundY)/delta]==4)
					{
						map[(personX-boundX+delta)/delta][(personY-boundY)/delta]=2;
						map[(personX-boundX+delta*2)/delta][(personY-boundY)/delta]=-1;
						personX+=delta;
					}
				}
				else personX+=delta;
			}
			else if(keyCode==KeyEvent.VK_UP&&map[(personX-boundX)/delta][(personY-boundY-delta)/delta]!=1&&map[(personX-boundX)/delta][(personY-boundY-delta)/delta]!=-1)
			{
				if(map[(personX-boundX)/delta][(personY-boundY-delta)/delta]==3)
				{
					if(map[(personX-boundX)/delta][(personY-boundY-delta*2)/delta]==2)
					{
						map[(personX-boundX)/delta][(personY-boundY-delta)/delta]=2;
						map[(personX-boundX)/delta][(personY-boundY-delta*2)/delta]=3;
						personY-=delta;
					}
					else if(map[(personX-boundX)/delta][(personY-boundY-delta*2)/delta]==4)
					{
						map[(personX-boundX)/delta][(personY-boundY-delta)/delta]=2;
						map[(personX-boundX)/delta][(personY-boundY-delta*2)/delta]=-1;
						personY-=delta;
					}
				}
				else personY-=delta;
			}
			else if(keyCode==KeyEvent.VK_DOWN&&map[(personX-boundX)/delta][(personY-boundY+delta)/delta]!=1&&map[(personX-boundX)/delta][(personY-boundY+delta)/delta]!=-1)
			{
				if(map[(personX-boundX)/delta][(personY-boundY+delta)/delta]==3)
				{
					if(map[(personX-boundX)/delta][(personY-boundY+delta*2)/delta]==2)
					{
						map[(personX-boundX)/delta][(personY-boundY+delta)/delta]=2;
						map[(personX-boundX)/delta][(personY-boundY+delta*2)/delta]=3;
						personY+=delta;
					}
					else if(map[(personX-boundX)/delta][(personY-boundY+delta*2)/delta]==4)
					{
						map[(personX-boundX)/delta][(personY-boundY+delta)/delta]=2;
						map[(personX-boundX)/delta][(personY-boundY+delta*2)/delta]=-1;
						personY+=delta;
					}
				}
				else personY+=delta;
			}
			repaint();
			boolean flag=true;
			for(int i=0;i<10;i++)
				for(int j=0;j<10;j++)
					if(map[i][j]==4)
						flag=false;
			if(flag==true)
				JOptionPane.showMessageDialog(null,"You`ve Got It!","Victory", JOptionPane.ERROR_MESSAGE); 
		}
		public void keyTyped(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
	}
	public void mapInit()
	{
		map=new int [][]{{0,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,1,1,1,0,0,0},
						 {0,0,0,0,1,4,1,0,0,0},
						 {0,1,1,1,1,2,1,0,0,0},
						 {0,1,4,2,3,3,1,1,1,0},
						 {0,1,1,1,2,2,3,4,1,0},
						 {0,0,0,1,3,1,1,1,1,0},
						 {0,0,0,1,4,1,0,0,0,0},
						 {0,0,0,1,1,1,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0,0}};
	}
	private static final int delta=50;
	private static final int boundX=150;
	private static final int boundY=50;
	private int personX=400;
	private int personY=300;
	KeyHandler listener=new KeyHandler();
	JButton btnStart=new JButton("ÖØÖÃÓÎÏ·");
	Graphics2D g2d;
	Toolkit tll=Toolkit.getDefaultToolkit();
	int[][] map;
}
