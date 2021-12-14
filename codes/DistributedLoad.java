import java.util.Scanner;     // we have imported Scanner from the liberary 
public class DistributedLoad {          // we have taken the class DistributedLoad
	
	public static void main(String[] args) {
		
	              
		
		Scanner sc  = new Scanner(System.in);     // it takes on the input  
		
		
		System.out.println("Enter the total distance from A to B:");
		double L = sc.nextDouble();           // the value for the total distance between A and B is stored in L .
		
		System.out.println("Enter Total number of sections between A and B:");
		int sections = sc.nextInt();          // the value of the total number of sections is stored in sections.
		
		System.out.println("CHOOSE FROM THE BELOW :\nLoad type 1:Uniformly distributed load:\n"       // we need to select from these given 3 
				           + "Load type 2:Triangilar load - left to right\nLoad type 3:Triangul"      // options 
				           + "ar load -right to left\n");
		
		
		
		double x1 = 0,x2 =0 ,y1=0,y2=0,z1=0,z2=0;    // we have assigned few values to zero
		
		
		int i;
		
		for (i = 1;i<=sections;i++) {  // it increments for 1  till the selection value which we have entered 
			
			System.out.println("Choose the  load type of the section(1,2,3) :");
			int choice = sc.nextInt();
			
			System.out.println("Enter the load action on the section :");
			double W = sc.nextInt();
			
			System.out.println("Enter the distance from the point 'A' :");
			double Ldistance = sc.nextDouble();
			
			System.out.println("Enter the length of section : ");
			double Cdistance = sc.nextDouble();
			
			
			
		
			if (choice == 1) 
			{
				double C = Cdistance/2;           // centroid of the section
				double Area = Cdistance*W;        // Area  = centroid X Load 
				double A2 = Area*(C + Ldistance); // Momentum caused by the force acting on the section at point 'A' .
			    x1 = x1+Area;                     // stores the value of Area 
				x2 = x2+A2;                       // stores the value of momentum 
				
		    }
			
			else if(choice == 2)
			    {
				double C = 0.666*Cdistance;         // centroid of the section
				double Area = 0.5*Cdistance*W;      // Area  = centroid X Load 
				double B2 = Area*(C + Ldistance);   // Momentum caused by the force acting on the section at point 'A' .
				y1 = y1+Area;                       // stores the value of Area 
				y2 = y2+B2;                          // stores the value of momentum 
				 
				}
			
		
				
			else if(choice == 3) { 
			double C = 0.333*Cdistance;               // centroid of the section
			double Area = 0.5*Cdistance*W;            // Area  = centroid X Load 
			double D2 = Area*(C + Ldistance);         // Momentum caused by the force acting on the section at point 'A' .
			z1 = z1+Area;                             // stores the value of Area 
			z2 = z2 + D2;                              // stores the value of momentum 
		
	 }
		
		
			
			}
		
		
		double B = (x2+y2+z2)/L;             // momentum equation about point A
		System.out.println("The reaction force at B is:" + Math.ceil(B));
		
		double A = (x1+y1+z1)-B;            // At equ. condition for the beam 
		System.out.println("The reaction force at A is:" + Math.ceil(A));
	
	}

}
