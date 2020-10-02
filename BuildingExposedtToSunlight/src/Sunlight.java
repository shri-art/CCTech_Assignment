
public class Sunlight {

	    static class Point  
	    { 
	        double x; 
	        double y; 
	  
	        public Point(double x, double y) 
	        { 
	            this.x = x; 
	            this.y = y; 
	        } 
	        public double getX()
	        {
	        	return x;
	        }
	        public double getY()
	        {
	        	return y;
	        }
	    };
	    
	    static double findFisrstBuildingLength(Point building[],int n,Point s) {
	    	
	    	//System.out.println(building);
	    	int k=building.length;
	    	//System.out.println(k);
	    	double m=building.length;
	    	Point[] arr=new Point[k];
	    	double h1;
	    	int chk=0;
	    	for(int i=0;i<k;i++)
	    	{
	    		arr[i]=building[i];
	    		h1=arr[i].y; 
	    		if(s.y<h1)		//s.y should be greater than all the building of y axis
	    		{
	    			chk=1;
	    			break;
	    		}
	    	}
	    	double dist=0;
	    	Point b1[]=new Point[4];
	    	Point b2[]=new Point[4];
	    	int count=0;
	    	if(chk==0 && m==4)
	    	{									 //if only one building is there   
		    		for(int i=0;i<2;i++)
		    		{	    		
		    			dist=dist+(Math.sqrt(Math.pow(arr[i+1].x-arr[i].x,2)+Math.pow(arr[i+1].y-arr[i].y,2)));	
		    		}	
	    	}	
	    	else if(m==8) {      //if more than 4 coordinates is there that means more than one buildings
	    		for(int i=0;i<2;i++)
	    		{
	    			if(i==0) {
		    			for(int j=0;j<4;j++)
		    			{
		    				b1[j]=arr[j];		    				
		    				count++;
		    			}
	    			}
	    			if(i==1)
	    			{
	    				for(int j=0;j<4;j++)
	    				{
	    					b2[j]=arr[count];
	    					count++;
	    				}
	    			}
	    		}
	    
	    		//Now we have to calculate height of the buildings
	    		double heightOfFirstBuilding=0;
	    		double heightOfSecondBuilding=0;
	    		double topSurfaceOfFirstBuilding=0;
	    		double topSurfaceOfSecondtBuilding=0;
	    		for(int i=0;i<2;i++)
	    		{	    		
	    			heightOfFirstBuilding=heightOfFirstBuilding+(Math.sqrt(Math.pow(b1[i+1].y-b1[i].y,2)));	 
	    			heightOfSecondBuilding=heightOfSecondBuilding+(Math.sqrt(Math.pow(b2[i+1].y-b2[i].y,2)));	
	    			topSurfaceOfFirstBuilding=topSurfaceOfFirstBuilding+(Math.sqrt(Math.pow(b1[i+1].x-b1[i].x,2)));	 
	    			topSurfaceOfSecondtBuilding=topSurfaceOfSecondtBuilding+(Math.sqrt(Math.pow(b2[i+1].x-b2[i].x,2)));	 

	    		}	
	    	 		
	    		double heightDiffOfBuildings=heightOfFirstBuilding-heightOfSecondBuilding;
	    		
	    		double angle=0.866;
	    		
	    		dist=heightDiffOfBuildings+heightOfSecondBuilding+topSurfaceOfFirstBuilding+topSurfaceOfSecondtBuilding+angle;   		
	 	    	}
	    	return dist;
	    }
	    
	    
	
	public static void main(String[] args) throws Exception{
		
		Point building[]= {new Point(4,0),new Point(4,-5),new Point(7,-5),new Point(7,0)};
		int b=building.length;
		
		int n=b/4;  //Total no of buildings....
		Point s=new Point(1,1);
		//1)find length of first building
		System.out.println("Expected Result From Given Input :");
		System.out.println(findFisrstBuildingLength(building,n,s));
		
		
		Point building1[]= {new Point(4,0),new Point(4,-5),new Point(7,-5),new Point(7,0),new Point(0.4,-2),new Point(0.4,-5),new Point(2.5,-5),new Point(2.5,-2)};
		//System.out.println(building1.length);
		b=building1.length;
		n=b/4;
		s=new Point(-3.5,1);
		System.out.println(findFisrstBuildingLength(building1,n,s));

	}

}
