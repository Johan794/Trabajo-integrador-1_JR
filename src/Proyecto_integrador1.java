import java.util.Scanner;
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
	    int total_topay[]= new int[3];
		int home_center[];
		int downtown_store[];
		int neighborhood_store[];
		String black_work[];
		String white_work[];
		String painting[];
		
		System.out.println("Please type the amount of materials needed in the construction");
         quantity= sc.nextInt();		
	     materials_list= new String[quantity];
		 quantity_materials= new double[quantity];
		 home_center= new int[quantity];
		 downtown_store= new int[quantity];
	     neighborhood_store= new int[quantity];
		 kind= new Work[quantity];
		 black_work= new String[quantity];
	     white_work= new String[quantity];
         painting=	new String[quantity];
		
		//in the next cycle the user will type the amount and kind of the materials
		for(int i=0; i<materials_list.length; i++){
			sc.nextLine();
			System.out.println("Please type the material # "+(i+1) );
			    materials_list[i]= sc.nextLine();
		
		      System.out.println("Please type how much do you need of:  "+materials_list[i] );
			    quantity_materials[i]= sc.nextDouble(); 
		                      }
		
		  kind=kindofwork(materials_list,quantity);
		
		for(int n=0; n<materials_list.length; n++){
			System.out.println("please type the price of "+materials_list[n]+" in Home center");
			home_center[n]= sc.nextInt();
			
			System.out.println("please type the price of "+materials_list[n]+" in the downtown store");
			downtown_store[n]= sc.nextInt();
		
			System.out.println("please type the price of "+materials_list[n]+"  in the neighborhood store");
			neighborhood_store[n]= sc.nextInt();
		
		}
		
		total_topay=howmuctopayin(kind,home_center,downtown_store,neighborhood_store,quantity_materials);
	    System.out.println("The price of the construction if you decide to buy in Home center is "+total_topay[0]+" plus workforce");
		System.out.println("The price of the construction if you decide to buy in Downtown Store is "+total_topay[1]+" plus workforce");
		System.out.println("The price of the construction if you decide to buy in the neigborhood store is "+total_topay[2]+" plus workforce");
		System.out.println();
		bestplace_tobuy(home_center, downtown_store, neighborhood_store, quantity, materials_list,quantity_materials,kind);
		type_ofuse(kind,materials_list);	
		
		
		
		
		
		
		
	}
	
	/**
	* Method: kindofwork:<br>
	* This method helps to clasficate the use that will be given to the list of materials <br>
	* <b> pre: </b> It requires that the list of materials is not empty and the varibale quantity must be diferent of 0 <br>
	* <b> pos: </b> The method will give an array of objects which will have the kind of work that has been asigned by the user <br>
	* @param array,  the list of materias
	* @param quantity, the size of the material's list
	* @return kind ,It is an array of objects 
	*/
	public static Work[] kindofwork(String []array, int quantity){
		Work []kind= new Work[quantity];
		for(int i=0; i<array.length; i++){
		System.out.println("Now, please type 1 if  "+array[i]+" will be used in Black work");
		System.out.println("or please type 2 if "+array[i]+ " will be used in White work");
		System.out.println("or type 3 if "+array[i]+" will be used for paiting");
		int election= sc.nextInt();
		switch(election){
			case 1: kind[i] = Work.OBRA_NEGRA;
				break;
			
			case 2: kind[i]= Work.OBRA_BLANCA;
				break;
				
			case 3: kind[i]= Work.PINTURA;
				break;
		}
	  }
		return kind;
	}
	
	/**
	* Method: howmuchtopay <br>
	* This method calculates how much must the user pay for the work if he decides to buy the materials at and espesific store <br>
	* <b> pre: </b> the enumeration should have been assigned before. <br>
	* <b> pos: </b> The method will give the complete price of the construction for each store, like he would buy at one of those stores <br>
	* @param work, the array with the kind of work 
	* @param  home_center, the array with the prices of Home center
	* @param downtown_store, the array with the prices of the downtown store
	* @param neighborhood_store, the array with the prices of the Neighborhood store
	* @param  materials, the array that contains the amount of materias
	* @return total_topay, it is an array of integers it includes the price of hand working
	*/
	public static int[] howmuctopayin(Work[] work, int []home_center, int []downtown_store, int []neighborhood_store, double[] materials){
		int pay_homecenter=0;
		int pay_downtownstore=0;
		int pay_neigborhoodstore=0;
		boolean black_work=false;
		boolean white_work=false;
		boolean painting_work=false;
		
	    int total_topay[]= new int[3];
		 
		for(int j=0; j<home_center.length; j++){
			pay_homecenter+= home_center[j]*materials[j];		
		    pay_downtownstore+=downtown_store[j]*materials[j];
            pay_neigborhoodstore+=neighborhood_store[j]*materials[j];	
		
		}
		
		for(int k=0; k<home_center.length; k++){
			if(work[k]==Work.OBRA_NEGRA){   black_work=true; }
			if(work[k]== Work.OBRA_BLANCA){  white_work=true;   }
			if(work[k]== Work.PINTURA){  painting_work=true;  }
		}
		if(((black_work && white_work) && painting_work)==true){
				pay_homecenter+=(BLACK_WORK+WHITE_WORK+PAINTING);
				pay_downtownstore+=(BLACK_WORK+WHITE_WORK+PAINTING);
				pay_neigborhoodstore+=(BLACK_WORK+WHITE_WORK+PAINTING);
			
				}else if((black_work && white_work)==true){
				        pay_homecenter+=(BLACK_WORK+WHITE_WORK);
				        pay_downtownstore+=(BLACK_WORK+WHITE_WORK);
				        pay_neigborhoodstore+=(BLACK_WORK+WHITE_WORK);
			
			    }else if((black_work && painting_work)==true){
				        pay_homecenter+=(BLACK_WORK+PAINTING);
				        pay_downtownstore+=(BLACK_WORK+PAINTING);
				        pay_neigborhoodstore+=(BLACK_WORK+PAINTING);
			
			    }else if((white_work && painting_work)==true){
				         pay_homecenter+=(WHITE_WORK+PAINTING);
				         pay_downtownstore+=(WHITE_WORK+PAINTING);
				         pay_neigborhoodstore+=(WHITE_WORK+PAINTING);
			      
			        }
		
		
		total_topay[0]=pay_homecenter;
		total_topay[1]=pay_downtownstore;
		total_topay[2]=pay_neigborhoodstore;

		return total_topay;
	
	
	
	
	}
	/**
	* Method: bestplace_tobuy <br>
	* this method will show the best place to buy each material of the list, and will caulcute the budget if the user decides to show those suggestions it includes delivery <br> 
	* <b> pre: </b> the user must indicate the location for the delivery<br>
   	* <b> post: </b> the method will show the places with the lower prices of each material and a better budget in that case, it includes delivery and workforce<br>
	* @param home_center the prices of the materials in Home Center
	* @param dowtown_store the prices of the materials in the downtown store.
	* @param neigborhood_store the prices of the materials in the neigborhood store.
	* @param quantity the size of the list of materials to save the best prices in another list
	* @param array  it contains the list of materials
	* @param materials  the amound of materials
	* @param kind the type of of use for each material
	* @return 
	*/
	public static void bestplace_tobuy(int []home_center, int []downtown_store, int []neighborhood_store, int quantity, String array[], double []materials, Work kind[]){
		int the_best_buy;
		int final_bestbudget=0;
		String buy="";
		String best_election[]= new String[quantity];
		int best_budget[]= new int[quantity];
		int var;
		boolean black_work=false;
		boolean white_work=false;
		boolean painting_work=false;
		Location delivery=null;
		for(int i=0; i<best_election.length; i++){
			the_best_buy=home_center[i];
			if((the_best_buy>=downtown_store[i])&&(the_best_buy>=neighborhood_store[i])){
				the_best_buy=downtown_store[i];
				buy="Down town Store";
			    if(the_best_buy>=neighborhood_store[i]){
				    the_best_buy=neighborhood_store[i];
					buy="Neighborhood Store";
				      }
			}else if(the_best_buy>=downtown_store[i]){
	                   the_best_buy=neighborhood_store[i];			
				       buy="Down town Store";
			          
			  }else if(the_best_buy>=neighborhood_store[i]){
                       the_best_buy=neighborhood_store[i];			
			           buy="Neighborhood Store";
			                 }else{ buy="Home Center";
								    the_best_buy=home_center[i];
			                          }
		      best_election[i]=buy;
			  best_budget[i]=the_best_buy;
		}	
	 for(int j=0; j<best_election.length; j++){
		 System.out.println("The best place to buy "+array[j]+" is "+best_election[j]);
		 final_bestbudget+=(best_budget[j]*materials[j]); 
	 }
		
        for(int k=0; k<best_election.length; k++){
			if(kind[k]==Work.OBRA_NEGRA){   black_work=true; }
			if(kind[k]== Work.OBRA_BLANCA){  white_work=true;   }
			if(kind[k]== Work.PINTURA){  painting_work=true;  }
		}
		if(((black_work && white_work) && painting_work)==true){
				final_bestbudget+=(BLACK_WORK+WHITE_WORK+PAINTING);
				
				}else if((black_work && white_work)==true){
				        final_bestbudget+=(BLACK_WORK+WHITE_WORK);
				       
			
			    }else if((black_work && painting_work)==true){
				        final_bestbudget+=(BLACK_WORK+PAINTING);
				        
			
			    }else if((white_work && painting_work)==true){
				         final_bestbudget+=(WHITE_WORK+PAINTING);
			        }
		
		System.out.println("So the price of the construction would be "+final_bestbudget+" whitout delivery");
		 System.out.println("Where is the building zone?\n 1: North \n 2: DownTown \n 3: South ");
          var=sc.nextInt();
		  switch(var){
			  case 1: delivery= Location.NORTE;
				  break;
			  case 2: delivery= Location.CENTRO;
				  break;
			  case 3: delivery= Location.SUR;
				  
		  }
		if(delivery==Location.NORTE){
			if(final_bestbudget<80000){
				final_bestbudget+=120000;
			}else if(final_bestbudget<300000){
				final_bestbudget+=28000;
			}else if(final_bestbudget>=300000){
				final_bestbudget+=0;
				var=0;
			}
		}else if(delivery== Location.CENTRO){
			if(final_bestbudget<80000){
				final_bestbudget+=50000;
			}else if(final_bestbudget<300000){
				final_bestbudget+=0;
				var=0;
			}else if(final_bestbudget>=300000){
				final_bestbudget+=0;
				var=0;
			}
		}else if(delivery == Location.SUR){
			if(final_bestbudget<80000){
				final_bestbudget+=120000;
			}else if(final_bestbudget<300000){
				final_bestbudget+=55000;
			}else if(final_bestbudget>=300000){
				final_bestbudget+=0;
				var=0;
			}
		}
		if(var==0){
           System.out.println("In that case the price of the construction would be "+final_bestbudget+" delivery free");
		}else{
		   System.out.println("In that case the price of the construction would be "+final_bestbudget+" plus delivery");
		}
		
		
		
		
		
		
	}
	
	/**
	* Method: type_ofuse <br>
	*  this method will show all the materials sorted by type of use. <br> 
	* <b> pre: </b>  the enumeration should have been assigned before. <br>
   	* <b> post:</b> the method will show the places with the lower prices of each material and a better budget in that case.<br>
	* @param kind ,this contains the enumaration of the type of work. 
	* @param materials_list this contains the list of materials. 
	* @return 
	*/
	
	public static void type_ofuse(Work kind[], String materials_list[]){
		int election_work;
		String final_response;
		sc.nextLine();
		System.out.println();
		System.out.print("Would you like to see a list of the materials sorted by the type of work? type yes or no:");
		final_response=sc.nextLine();
		while(final_response.equals("yes")){
			
		System.out.println("Please type 1 if you want to see the list of materias for Black Work");
		System.out.println("Please type 2 if you want to see the list of materias for white work");
		System.out.println("Please type 3 if you want to see the list of materials for painting");
		 election_work=sc.nextInt();
		
	    switch(election_work){
			case 1: 
				   for(int i=0; i<materials_list.length; i++){
						 if(kind[i]==Work.OBRA_NEGRA){
                               System.out.println(materials_list[i]);						 
						         }
					        }
				
				       break;
			case 2:
				  for(int i=0; i<materials_list.length; i++){
						     if(kind[i]==Work.OBRA_BLANCA){
                                  	System.out.println(materials_list[i]);						 
							         }
					        }
				
			
				      break;
			case 3:
				  for(int i=0; i<materials_list.length; i++){
						     if(kind[i]==Work.PINTURA){
                              System.out.println(materials_list[i]);						 
							      }
					        }
				        break;
		   }
		sc.nextLine();
		System.out.print("Would you like to see another list of materials sorted by the type of work? type yes or no:");
		
		final_response= sc.nextLine();
		
		}
	   System.out.println("Thanks for using the program, good luck in your construction!");
		
		
	}		
}

