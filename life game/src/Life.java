public class Life{
	private int[][] cell = new int[30][30];	//cell数组表示下一时刻细胞的状态。0:死亡，1:存活
	private boolean[][] IsLife = new boolean [30][30];//IsLife数组表示这个时刻细胞是否存活，true：存活，false：死亡。
	
	public Life()
	{
		//初始化数组。都为死细胞
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
		//图形1
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
		//图形2
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
		//图形3
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
	//函数名：getCell()
	//函数功能：获取cell数组在[i][j]位置上的值
	public int getCell(int i, int j)
	{
		return cell[i][j];
	}
	//函数名:getLife()
	//函数功能：获取IsLife数组在[i][j]上的值
	public boolean getLife(int i, int j)
	{
		return IsLife[i][j];
	}
	//函数名：updateLife()
	//函数功能：将下一时刻细胞状态
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

	//函数名：nextCell()
	//函数功能：更新细胞下一时刻的状态
	public void nextCell(int sum,int i,int j)
	{
		if(sum<2||sum>3) cell[i][j]=0;//死亡
		if(sum==3) cell[i][j]=1;//存活
	}
	
	//函数名：life
	//函数功能：计算当前细胞周围的活细胞数
	public int live(int i,int j,boolean map[][])
	{
		int sum=0;
		//左上角
		try{
		if(map[i-1][j-1]) sum++;	
		//正上方
		if(map[i-1][j])  sum++;
		//右上角
		if(map[i-1][j+1] ) sum++;
		//左边
		if(map[i][j-1] ) sum++;
		//右边
		if(map[i][j+1] ) sum++;
		//左下角
		if(map[i+1][j-1] ) sum++;
		//下方
		if(map[i+1][j] ) sum++;
		//右下角
		if(map[i+1][j+1] ) sum++;
		}catch (ArrayIndexOutOfBoundsException e)
		{		
		}
		
		return sum;
	}
	//函数名：nextMap
	//函数功能：更新下一时刻游戏地图上的细胞状态
	public void nextMap()
	{
		//遍历游戏地图，了解下一时刻的各个细胞状态
		for(int i=0; i<30; i++)
		{
			for(int j=0; j<30; j++)	
			{
				int sum=0;
				//计算细胞个数
				sum=live(i,j,IsLife);
				//判断该细胞下一时刻是否存活
				nextCell(sum,i,j);
				//System.out.print(cell[i][j]+" "+IsLife[i][j]);
			}
		//System.out.println();
		}
	}
}

