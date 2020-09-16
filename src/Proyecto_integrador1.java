import java.util.Scanner;
/**


*/
public class Proyecto_integrador1{
	public static Scanner sc = new Scanner(System.in);
	public static final int BLACK_WORK=1300000;
	public static final int WHITE_WORK= 2600000;
	public static final int PAINTING= 980000;
	
	public static void main(String []args){
	
		int quantity; //it will help us to determinate the quantity of materials typed for the user
		String materials_list[]; //here the list of materials will be saved
		double quantity_materials[];// here the quantity of materials will be saved 
		Work kind[];
		
		System.out.println("Please type the amount of materials needed in the construction");
         quantity= sc.nextInt();		
	     materials_list= new String[quantity];
		 quantity_materials= new double[quantity];
		 kind= new Work[quantity];
		//in the next cycle the user will type the amount and kind of the materials
		sc.nextLine();
		for(int i=0; i<materials_list.length; i++){
			System.out.println("Please type the material # "+(i+1) );
			    materials_list[i]= sc.nextLine();
		
		      System.out.println("Please type the amount of the material # "+ (i+1) );
			    quantity_materials[i]= sc.nextDouble();
		
		                             
	
		}
		
		kind=kindofwork(materials_list,quantity);
	   

		
	}
	
	public static Work[] kindofwork(String []array, int quantity){
		Work []kind= new Work[quantity];
		for(int i=0; i<array.length; i++){
		System.out.println("Now, please type 1 if  "+array[i]+" will be used in Black work");
		System.out.println("or, please type 2 if "+array[i]+ "will be used in White work");
		int election= sc.nextInt();
		switch(election){
			case 1: kind[i] = Work.OBRA_NEGRA;
			
			case 2: kind[i]= Work.OBRA_BLANCA;
		}
	  }
		return kind;
	}
	
	
	

    



















}