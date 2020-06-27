package Model;

import java.util.ArrayList;
import java.util.List;

import Model.buildings.Building;
import Model.buildings.Hospital;
import Model.buildings.House;
import Model.buildings.Lottery;
import Model.buildings.News;
import Model.buildings.Origin;
import Model.buildings.Park;
import Model.buildings.Point;
import Model.buildings.Prison;
import Model.buildings.Shop_;

/**
 * ȫ�ַ�����Ϣ
 * 
 * @author Ruining
 * 
 */
public class BuildingModel extends Tick implements Port{
  /**
   * ��������
   */
	private List<Building> buildings =null;
	
	private LandModel land=null;
	
	public BuildingModel(LandModel land)
	{
		this.land=land;
	}
	
	/**
	 * ��ʼ������
	 */
	private void initBuilding()
	{
		//��ʼ������
		buildings= new ArrayList <Building>();
		//��Ӧ��ͼ���뷿��
		
		int [][] temp=this.land.getLand();
		for(int i=0;i<temp.length;i++)
		{
			for(int j=0;j<temp[i].length;j++)
			{
				switch(temp[i][j])
				{
				case LandModel.SPACE:
				Building tempBuidling = new House(i, j);
				// ���ÿյص�����Ϊ���Թ����
				tempBuidling.setPurchasability(true);
				buildings.add(tempBuidling);
				break;
			case LandModel.HOSPITAL:// ҽԺ
				buildings.add(new Hospital(i, j));
				//����ȫͼҽԺ��
				LandModel.hospital = new java.awt.Point(j * 60,i * 60);
//				System.out.println(LandModel.hospital );
				break;
			case LandModel.LOTTERY:
				buildings.add(new Lottery(i, j));
				break;
			case LandModel.NEWS:
				buildings.add(new News(i, j));
				break;
			case LandModel.ORIGIN:
				buildings.add(new Origin(i, j));
				break;
			case LandModel.PARK:
				buildings.add(new Park(i, j));
				break;
			case LandModel.PIONT_10:
				buildings.add(new Point(i, j, 10));
				break;
			case LandModel.PIONT_30:
				buildings.add(new Point(i, j, 30));
				break;
			case LandModel.PIONT_50:
				buildings.add(new Point(i, j, 50));
				break;
			case LandModel.SHOP:
				buildings.add(new Shop(i, j));
				break;
			case LandModel.PRISON:// ����
				buildings.add(new Prison(i, j));
				//����ȫͼ������
				LandModel.prison = new java.awt.Point(j * 60, i * 60);
//				System.out.println(LandModel.prison );
				break;
			default:
				break;
			    }
			  }
			}
		
		
		}
		
	/**
	 * ��÷����б�
	 */
	public List<Building> getBuilding()
	{
		return buildings;
	}
	/**
	 * ��õ�ǰλ�÷���
	 */
	
	public Building getBuilding(int x,int y)
	{
		for(Building temp: this.buildings)
		{
			if(temp.getPosX()==x && temp.getPosY()==y)
				return temp;
		}
		return null;
	}
	/**
	 * 
	 * ��ʼ��Ϸ����
	 * 
	 */
	public void startGameInit (){
		// ��ʼ������
		initBuilding();
	}

	@Override
	public void updata(long tick) {
		this.nowTick = tick;
		
	}
	
	
	
}