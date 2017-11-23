
public class Algorithms {
	
	private int value;
	private int available_value_calculation;
	private int excuted_count=0,dead_value=0;
	
	public void check(Process[][] process, int i, int rn){
		for(int j=0;j<rn;j++){
			if(process[i][j].get_process_resources_need_value()<=process[i][j].get_process_resources_available_value() && process[i][j].get_process_resources_need_value()>-1){
				
				value=1;

			}
			else{
				value=0;
				break;
			}
			
		}
	}

	public int get_check(){
		return value;
	}
	
	public int get_excuted_count(){
		return excuted_count;
	}
	
	public int get_dead_value(){
		return dead_value;
	}
	
	public void print_excuted_count(){
		System.out.println("Count === "+excuted_count);
	}
	
	public void algorithms_action(Process[][] process,int i,int j,int rn,int pn){
		
		if(get_check()==1){
			process[i][j].print_process_name();
			System.out.print("-->");
			excuted_count++;
			for(int k=0;k<rn;k++){
				
				available_value_calculation=process[i][k].get_process_resources_available_value()+process[i][k].get_process_resources_allocation_value();
				dead_value=0;
				
				for(int l=0;l<pn;l++){
					process[l][k].set_process_resources_available_value(available_value_calculation);
				}
				process[i][k].set_process_resources_need_value(-1);
			}

			
		}
		else{
			dead_value++;

		}

	}


}
