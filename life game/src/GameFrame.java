import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener{
	private static GameFrame frame;
	private JButton btnStart;
	private JPanel backPanel;
	private JPanel buttonPanel;
	private JLabel shezhiLabel;
	private JButton btn1,btn2,btn3;
	private JButton btnExit;
	private boolean running;
	private int t;
	
	private Life life;
	private Graphics gr;
	
	public GameFrame()
	{
		life = new Life();
		frame = new GameFrame("生命游戏");
	}
	
	public GameFrame(String name)
	{
		super(name);
	}
	
	public void initGUI()	//游戏界面初始化
	{
		backPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new GridLayout(5,1));
		btnStart = new JButton("开始游戏");
		shezhiLabel = new JLabel("选择游戏初始图形");
		btn1 = new JButton("图形1");
		btn2 = new JButton("图形2");
		btn3 = new JButton("图形3");
		btnExit = new JButton("退出");
		this.setContentPane(backPanel);
		backPanel.add(buttonPanel,"East");
		
		buttonPanel.add(shezhiLabel);
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		buttonPanel.add(btn3);
		buttonPanel.add(btnStart);
		buttonPanel.add(btnExit);
		
		Container p = getContentPane();
		setBounds(80,80,1000,1000);
		setVisible(true);
		p.setBackground(Color.WHITE);
		setLayout(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gr = this.getGraphics();
		//设置线条颜色为黑色	
		gr.setColor(Color.BLACK);
		updateMap(gr);
        btn1.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						life.InitLife1();
						running = false;
						btnStart.setText("开始游戏");}
        		});
        btn2.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						life.InitLife2();
						running = false;
						btnStart.setText("开始游戏");}
        		});
        btn3.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						life.InitLife3();
						running = false;
						btnStart.setText("开始游戏");}
        		});
        btnStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				btnStart.setText("下一代");
				run();		
			}
		});
        btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {System.exit(0);}
		}
        );
	}
	public void run()
	{
		gr = getGraphics();
		updateMap(gr);
			life.nextMap();
			updateMap(gr);
			life.updateLife();
	}
	//函数名：updateMap()
	//函数功能：更新下一时刻游戏地图
	public void updateMap(Graphics g)
	{
		for(int i=0; i<30; i++)
		{
			for(int j=0; j<30; j++)
			{
				int x=80+i*20;
				int y=80+j*20;
				if(!life.getLife(i, j))
				{
					//细胞是死的
					g.setColor(Color.WHITE);
					g.fillRect(x, y, 20, 20);
				}
				else
				{
					//细胞是活的
					g.setColor(Color.BLACK);
					g.fillRect(x, y, 20, 20);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
