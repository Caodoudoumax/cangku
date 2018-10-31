
public class control {
	private GameFrame gf;
	public control()
	{
		gf=new GameFrame();
	}
	
	public static void main(String args[])
	{
		control con = new control();
		con.gf.initGUI();
	}


}
