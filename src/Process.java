import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Process {

	private String process_name;
	private String process_resources_name;
	private int process_resources_allocation_value;
	private int process_resources_maxi_value;
	private int process_resources_available_value;
	private int process_resources_need_value;
	private int process_resources_need_value_calculation;
	BufferedReader  bf=new BufferedReader(new InputStreamReader(System.in));
	
	
	public Process(String name,int count){
		process_name=name+count;

	}
	

	public void input_process_name()throws IOException{
		System.out.println("Process Name:- ");
		process_name=bf.readLine();
	}
	
	public void input_process_resource_name()throws IOException{
		System.out.println(get_process_name()+" Process"+" Resources Name:- ");
		process_resources_name=bf.readLine();
	}
	
	public void input_process_resources_allocation_value()throws IOException{
		System.out.println(get_process_name()+" Process '"+get_process_resources_name()+"' Resources"+" Allocation Value:- ");
		process_resources_allocation_value=Integer.parseInt(bf.readLine());
	}
	
	public void input_process_resources_maxi_value()throws IOException{
		System.out.println(get_process_name()+" Process '"+get_process_resources_name()+"' Resources"+" Maximum value:- ");
		process_resources_maxi_value=Integer.parseInt(bf.readLine());
	}
	
	public void input_process_resource_available_value()throws IOException{
		System.out.println(get_process_name()+" Process '"+get_process_resources_name()+"' Resources"+" Available value:- ");
		process_resources_available_value=Integer.parseInt(bf.readLine());
	}
	
	public void input_process_resource_need_value() throws IOException{
		System.out.println(get_process_name()+" Process '"+get_process_resources_name()+"' Resources"+" Need Value:- ");
		process_resources_need_value=Integer.parseInt(bf.readLine());
	}
	
	
	//set method.......................................
	public void set_process_name(String name){
		process_name=name;
	}
	
	public void set_process_resources_name(String name){
		process_resources_name=name;
	}
	
	public void set_process_resources_allocation_value(int value){
		process_resources_allocation_value=value;
	}
	
	public void set_process_resources_maxi_value(int value){
		process_resources_maxi_value=value;
	}
	
	public void set_process_resources_available_value(int available_value){
		process_resources_available_value=available_value;
	}
	
	public void set_process_resources_need_value(int value){
		process_resources_need_value=value;
	}
	
	//get method................................

	public String get_process_name(){
		return process_name;
	}
	
	public String get_process_resources_name(){
		return process_resources_name;
	}
	
	public int get_process_resources_allocation_value(){
		return process_resources_allocation_value;
	}
	
	public int get_process_resources_maxi_value(){
		return process_resources_maxi_value;
	}
	
	public int get_process_resources_available_value(){
		return process_resources_available_value;
	}
	
	public int get_process_resources_need_value(){
		return process_resources_need_value;
	}
	
	public int get_process_resources_need_value_calculation(){
		return process_resources_need_value_calculation;
	}
	
	//print method...............................
	
	public void print_process_name(){
		System.out.print(process_name);
	}
	
	public void print_process_resources_name(){
		System.out.print(process_resources_name);
	}
	
	public void print_process_resources_allocation_value(){
		System.out.print(+process_resources_allocation_value);
	}
	
	public void print_process_resources_maxi_value(){
		System.out.print(+process_resources_maxi_value);
	}
	
	public void print_process_resources_available_value(){
		System.out.print(+process_resources_available_value);
	}
	
	public void print_process_resources_need_value(){
		System.out.print(+process_resources_need_value);
	}

	//Other method.........................
	
	public void process_resources_need_value_calculation(){
		
		process_resources_need_value_calculation=get_process_resources_maxi_value()-get_process_resources_allocation_value();
	}
	
	

}
