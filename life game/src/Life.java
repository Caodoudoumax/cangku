public class Life{
	private int[][] cell = new int[30][30];	//cell�����ʾ��һʱ��ϸ����״̬��0:������1:���
	private boolean[][] IsLife = new boolean [30][30];//IsLife�����ʾ���ʱ��ϸ���Ƿ��true����false��������
	
	public Life()
	{
		//��ʼ�����顣��Ϊ��ϸ��
		for(int i=0; i<30; i++)
			for(int j=0; j<30; j++)
			{
				cell[i][j]=0;
				IsLife[i][j]=false;
			}
	}
	public void clearLife()
	{
		for(int i=0; i<30; i++)
			for(int j=0; j<30; j++)
			{
				cell[i][j]=0;
				IsLife[i][j]=false;
			}
	}
	public void InitLife1()
	{
		//ͼ��1
		clearLife();
		for(int i=7; i<12; i++)
			for(int j=7; j<12; j++)
			{
				cell[i][j]=1;
				IsLife[i][j]=true;
			}
	}
	public void InitLife2()
	{
		//ͼ��2
		clearLife();
		cell[4][4]=1;cell[4][5]=1;cell[4][6]=1;cell[4][7]=1;cell[4][8]=1;cell[4][9]=1;
		             cell[5][5]=1;cell[5][6]=1;cell[5][7]=1;cell[5][8]=1;
		             cell[6][5]=1;                          cell[6][8]=1;
		             cell[7][5]=1;cell[7][6]=1;cell[7][7]=1;cell[7][8]=1;
		cell[8][4]=1;cell[8][5]=1;cell[8][6]=1;cell[8][7]=1;cell[8][8]=1;cell[8][9]=1;
		for(int i=0; i<30; i++)
			for(int j=0; j<30; j++)
			{
				if(cell[i][j]==1)
					IsLife[i][j]=true;
			}
		
	}
	
	public void InitLife3()
	{
		//ͼ��3
		clearLife();
		cell[5][5]=1;																   cell[5][11]=1;
					 cell[6][6]=1;										 cell[6][10]=1;
					 			  cell[7][7]=1;				cell[7][9]=1;
					 			  			   cell[8][8]=1;
					 			  cell[9][7]=1;			   				cell[9][9]=1;
					 cell[10][6]=1;			  			   				 			 cell[10][10]=1;
		cell[11][5]=1;			 			  			   				 			 				cell[11][11]=1;
		
		
		for(int i=0; i<30; i++)
			for(int j=0; j<30; j++)
			{
				if(cell[i][j]==1)
					IsLife[i][j]=true;
			}
		
	}
	//��������getCell()
	//�������ܣ���ȡcell������[i][j]λ���ϵ�ֵ
	public int getCell(int i, int j)
	{
		return cell[i][j];
	}
	//������:getLife()
	//�������ܣ���ȡIsLife������[i][j]�ϵ�ֵ
	public boolean getLife(int i, int j)
	{
		return IsLife[i][j];
	}
	//��������updateLife()
	//�������ܣ�����һʱ��ϸ��״̬
	public void updateLife()
	{
		for(int i=0; i<30; i++)
			for(int j=0; j<30; j++)
			{
				switch(cell[i][j])
				{
				case 0:IsLife[i][j]=false;break;
				case 1:IsLife[i][j]=true; break;
				}
			}
	}

	//��������nextCell()
	//�������ܣ�����ϸ����һʱ�̵�״̬
	public void nextCell(int sum,int i,int j)
	{
		if(sum<2||sum>3) cell[i][j]=0;//����
		if(sum==3) cell[i][j]=1;//���
	}
	
	//��������life
	//�������ܣ����㵱ǰϸ����Χ�Ļ�ϸ����
	public int live(int i,int j,boolean map[][])
	{
		int sum=0;
		//���Ͻ�
		try{
		if(map[i-1][j-1]) sum++;	
		//���Ϸ�
		if(map[i-1][j])  sum++;
		//���Ͻ�
		if(map[i-1][j+1] ) sum++;
		//���
		if(map[i][j-1] ) sum++;
		//�ұ�
		if(map[i][j+1] ) sum++;
		//���½�
		if(map[i+1][j-1] ) sum++;
		//�·�
		if(map[i+1][j] ) sum++;
		//���½�
		if(map[i+1][j+1] ) sum++;
		}catch (ArrayIndexOutOfBoundsException e)
		{		
		}
		
		return sum;
	}
	//��������nextMap
	//�������ܣ�������һʱ����Ϸ��ͼ�ϵ�ϸ��״̬
	public void nextMap()
	{
		//������Ϸ��ͼ���˽���һʱ�̵ĸ���ϸ��״̬
		for(int i=0; i<30; i++)
		{
			for(int j=0; j<30; j++)	
			{
				int sum=0;
				//����ϸ������
				sum=live(i,j,IsLife);
				//�жϸ�ϸ����һʱ���Ƿ���
				nextCell(sum,i,j);
				//System.out.print(cell[i][j]+" "+IsLife[i][j]);
			}
		//System.out.println();
		}
	}
}

