import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankerAlgorithms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int process_number,resources_number;
		int i,j,k,l,count=0,excuted_count=0,break_value=0,dead_value=0;
			System.out.println("Enter The Process Number:- ");
			process_number=Integer.parseInt(bf.readLine());
			System.out.println("Enter The Resources Number:- ");
			resources_number=Integer.parseInt(bf.readLine());
		
		Process [][] process=new Process[process_number][resources_number];
		Algorithms [] algorithms=new Algorithms[resources_number+1];
		//Algorithms algorithm=new Algorithms();
		
		for(j=0;j<resources_number+1;j++){
			algorithms[j]=new Algorithms();
			//algorithms[j].check(process, i, rn);
		}
		
		
		for(i=0;i<process_number;i++){
			for(j=0;j<resources_number;j++){
				process[i][j]=new Process("P",i);
			}
		}
		
		for(i=0;i<process_number;i++){
			for(j=0;j<resources_number;j++){

				// Program will be take only one time Resources Name.......................
				if(i==0){
					process[i][j].input_process_resource_name();
				}
				else{
					process[i][j].set_process_resources_name(process[0][j].get_process_resources_name());
				}
			}
			
			System.out.println();
			
			for(j=0;j<resources_number;j++){
				
				process[i][j].input_process_resources_allocation_value();

			}
			
			System.out.println();
			
			for(j=0;j<resources_number;j++){
				
				process[i][j].input_process_resources_maxi_value();
				//process[i][j].input_process_resource_available_value();
				
			}
			
			System.out.println();
			
			for(j=0;j<resources_number;j++){
				// Program will be take only one time Resources Available Value.......................
				if(i==0){
					process[i][j].input_process_resource_available_value();
				}
				else{
					process[i][j].set_process_resources_available_value(process[0][j].get_process_resources_available_value());
				}
		//.......................................................................
			}
			System.out.println();
			System.out.println("%%%%Next Processs%%%%");
			System.out.println();
		}
		
		//Need Value.......................
		for(i=0;i<process_number;i++){
			for(j=0;j<resources_number;j++){
				process[i][j].process_resources_need_value_calculation();
				process[i][j].set_process_resources_need_value(process[i][j].get_process_resources_need_value_calculation());
				if(process[i][j].get_process_resources_need_value()<0){
					break_value=1;
					System.out.print("Dead Lock occur by Process ");
					process[i][j].print_process_name();
					break;
				}
			}
			
		}
		
		if(break_value!=1){ // if user set allocation value greater then max value for any process's resource then that process will be occur dead lock before show the chart
			
			System.out.println("Process"+ "\t Allocation"+"\t Maximum"+"\t Available"+"\t Need");
			
			for(i=0;i<1;i++){
				System.out.print("\t");
				for(j=0;j<4*resources_number;j++){              //4 means Allocation,Maximum,Available,Need 4 activity 

					if(count==4*resources_number){
						break;
					}
					else{
						count++;
						if(j==resources_number){
							System.out.print("\t\t");
							j=0;
							System.out.print(" ");
							process[i][j].print_process_resources_name();

						}
						else{
							
							System.out.print(" ");
							process[i][j].print_process_resources_name();

							
						}

					}

					
				}
				System.out.println();
			}
			
			
			
			
			for(i=0;i<process_number;i++){
				process[i][1].print_process_name();
				System.out.print("\t ");
				for(j=0;j<resources_number;j++){
					process[i][j].print_process_resources_allocation_value();
					System.out.print(" ");
					
				
				}
				
				System.out.print("\t\t ");
				
				for(j=0;j<resources_number;j++){
					
					process[i][j].print_process_resources_maxi_value();
					System.out.print(" ");
					
				}
				
				System.out.print("\t\t ");
				
				
				for(j=0;j<resources_number;j++){

						process[i][j].print_process_resources_available_value();
						System.out.print(" ");
				}
				
				
				System.out.print("\t\t ");
				
				
				for(j=0;j<resources_number;j++){

					process[i][j].print_process_resources_need_value();
					System.out.print(" ");
			}

				System.out.println();
			}
			
			System.out.println();
			System.out.println();
			
			for(i=0;i<process_number;i++){
				for(j=0;j<1;j++){
					algorithms[j].check(process, i, resources_number);
					algorithms[j].get_check();
					algorithms[j].algorithms_action(process,i,j,resources_number,process_number);
					dead_value=algorithms[j].get_dead_value();
					excuted_count =algorithms[j].get_excuted_count();
				}

				
				
				if(i==process_number-1){
					if(excuted_count !=process_number ){
						i=-1;
					}
					
					else if(dead_value==process_number+1){
						System.out.print("Dead Lock occur by Process ");
						process[i][j].print_process_name();
						
					}
					else{
						i=process_number;
					}
				}
				
				
			}
		}
	
	}

}
