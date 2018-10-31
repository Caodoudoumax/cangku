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
		frame = new GameFrame("������Ϸ");
	}
	
	public GameFrame(String name)
	{
		super(name);
	}
	
	public void initGUI()	//��Ϸ�����ʼ��
	{
		backPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new GridLayout(5,1));
		btnStart = new JButton("��ʼ��Ϸ");
		shezhiLabel = new JLabel("ѡ����Ϸ��ʼͼ��");
		btn1 = new JButton("ͼ��1");
		btn2 = new JButton("ͼ��2");
		btn3 = new JButton("ͼ��3");
		btnExit = new JButton("�˳�");
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
		//����������ɫΪ��ɫ	
		gr.setColor(Color.BLACK);
		updateMap(gr);
        btn1.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						life.InitLife1();
						running = false;
						btnStart.setText("��ʼ��Ϸ");}
        		});
        btn2.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						life.InitLife2();
						running = false;
						btnStart.setText("��ʼ��Ϸ");}
        		});
        btn3.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						life.InitLife3();
						running = false;
						btnStart.setText("��ʼ��Ϸ");}
        		});
        btnStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				btnStart.setText("��һ��");
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
	//��������updateMap()
	//�������ܣ�������һʱ����Ϸ��ͼ
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
					//ϸ��������
					g.setColor(Color.WHITE);
					g.fillRect(x, y, 20, 20);
				}
				else
				{
					//ϸ���ǻ��
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
