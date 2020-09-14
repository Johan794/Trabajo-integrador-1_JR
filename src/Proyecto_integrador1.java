import java.util.Scanner;
public class Proyecto_integrador1{
	
	public static final int BLACK_WORK=1300000;
	public static final int WHITE_WORK= 2600000;
	public static final int PAINTING= 980000;
	
	public static void main(String []args){
		Scanner sc= new Scanner(System.in);
		int quantity;
		int materials_list[];
		int quantity_materials[];
		
		System.out.println("Please type the amount of materials needed in the construction");
         quantity= sc.nextInt();		
	     materials_list= new int[quantity];
		 quantity_materials= new int[quantity];
		
		 System.out.println("Please type the materials needed in the construction");
		for(int i=0; i<materials_list.length; i++){
			System.out.println("Please type the material # "+(i+1) );
			    materials_list[i]= sc.nextInt();
		}
		
		
	   System.out.println("Please type the amount of materials needed in the construction");                      
		for(int j=0; j<quantity_materials.length; j++){
		      System.out.println("Please type the amount of the material # "+ (j+1) );
			    quantity_materials[j]= sc.nextInt();
		
		}
	
	
		
		
		
		
		
		
		
	
	}
	





















}