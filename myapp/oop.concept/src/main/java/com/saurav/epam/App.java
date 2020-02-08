package com.saurav.epam;


import java.util.Scanner;

interface Gift
{
	void Display_remaning();
	void Display_given();
	void Modify(int input);
	void Total_weight();
	void Add_variety();
	void Show_variety();
}

class Gift_Box
{
	protected int Total_weight(int Variety, int Quantity, int[] arr)
	{
		int weight;
		weight = arr[Variety-1] * Quantity;
		return weight;
	}
	protected int[] Add_variety(int len)
	{	
		int Weight[];
		Weight = new int[len];
		Scanner read = new Scanner(System.in);
		for(int i=0; i<len; i++)
		{
			System.out.println("Enter weight of " + (i+1) + " variety: ");
			Weight[i] = read.nextInt();
		}
		read.close();
		return Weight;
	}
}

class Chocolate extends Gift_Box implements Gift
{
	private	int Total_chocolate, Given_chocolate, Chocolate_Weight[];

	public void Display_remaning()
	{
		int remaning;
		remaning = Total_chocolate - Given_chocolate;
		System.out.println("Total number chocolate remaning are: " + remaning);
	}
	public void Display_given()
	{
		System.out.println("Total number chocolate given are: " + this.Given_chocolate);
	}
	public void Modify(int input)
	{
		this.Given_chocolate = input;
	}
	public Chocolate()
	{	
		Total_chocolate = 100;
		Given_chocolate = 0;
		Chocolate_Weight = null;
	}
	public Chocolate(int input)
	{	
		Total_chocolate = input;
		Given_chocolate = 0;
		Chocolate_Weight = null;
	}
	public void Add_variety()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("How many variety? ");
		int variety = read.nextInt();
		Chocolate_Weight = new int[variety];
		Chocolate_Weight = Add_variety(variety);
		read.close();
	}
	public void Total_weight()
	{
		int Input_variety, Input_quantity, Weight;
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the variety of chocolate: ");
		Input_variety = read.nextInt();
		System.out.println("Enter the quantity of chocolates: ");
		Input_quantity = read.nextInt();
		Weight = Total_weight(Input_variety, Input_quantity, Chocolate_Weight);
		System.out.println("Total weight of the gift box is " + Weight);
		read.close();
	}
	public void Show_variety()
	{	
		int len;
		System.out.println("List of varieties");
		len = Chocolate_Weight.length;
		for(int i=0; i<len; i++)
		{
			System.out.println("Variety: " + (i+1) + "Weight: " + Chocolate_Weight[i]);
		}
	}
	public void Sort() 
	{  
        int n;
        n = Chocolate_Weight.length;  
        for (int j = 1; j < n; j++)
        {  
            int key = Chocolate_Weight[j];  
            int i = j-1;  
            while ( (i > -1) && ( Chocolate_Weight[i] > key ) )
            {  
            	Chocolate_Weight[i+1] = Chocolate_Weight[i];  
                i--;  
            }  
            Chocolate_Weight[i+1] = key;  
        }
	}
}

class Sweets extends Gift_Box implements Gift
{
	private int Total_sweets, Given_sweets, Sweets_weight[];
	@Override
	public void Display_remaning() 
	{
		int remaning;
		remaning = Total_sweets - Given_sweets;
		System.out.println("Total number sweets remaning are: " + remaning);
	}
	@Override
	public void Display_given() 
	{
		System.out.println("Total number sweets given are: " + Given_sweets);	
	}
	@Override
	public void Modify(int input) 
	{
		Given_sweets = input;
	}
	@Override
	public void Add_variety()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("How many variety? ");
		int variety = read.nextInt();
		Sweets_weight = new int[variety];
		Sweets_weight = Add_variety(variety);
		read.close();
	}
	@Override
	public void Total_weight()
	{
		int Input_variety, Input_quantity, Weight;
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the variety of chocolate: ");
		Input_variety = read.nextInt();
		System.out.println("Enter the quantity of chocolates: ");
		Input_quantity = read.nextInt();
		Weight = Total_weight(Input_variety, Input_quantity, Sweets_weight);
		System.out.println("Total weight of the gift box is " + Weight);
		read.close();
	}
	@Override
	public void Show_variety()
	{	
		int len;
		System.out.println("List of varieties");
		len = Sweets_weight.length;
		for(int i=0; i<len; i++)
		{
			System.out.println("Variety: " + (i+1) + "Weight: " + Sweets_weight[i]);
		}
	}
	public Sweets()
	{
		Total_sweets = 100;
		Given_sweets = 0; 
		Sweets_weight = null;
	}
	public Sweets(int input)
	{
		Total_sweets = input;
		Given_sweets = 0; 
		Sweets_weight = null;
	}
}

public class App 
{
    public static void main( String[] args )
    {
    	Scanner in = new Scanner(System.in);
		int choice, Total_chocolate, Total_sweets;
		System.out.println("Enter total amount of chocolate present: ");
		Total_chocolate = in.nextInt();
		System.out.println("Enter total amount of sweets present: ");
		Total_sweets = in.nextInt();
		do
		{
		System.out.println("Press 1 for chocolate\n Press 2 for sweets\n Press 3 for Exit\n ");
		choice = in.nextInt();
		switch(choice)
			{
				case 1 :
						do
						{
						Scanner scan = new Scanner(System.in);
						System.out.println("Press 1 to display remaing chocolates \n press 2 to display total chocolates given\n Press 3 to add number of chocolates given\n Press 4 to add variety of chocolate pesent(based on weight)\n Press 5 to show the variety of chocolates present(based on based)\n Press 6 for Total weight of the gift(only chocolates) \n Press 7 for sort variety(base on weight) \n Press 8 to Exit\n");	
						choice = scan.nextInt();
						Chocolate object = new Chocolate(Total_chocolate);
							switch(choice)
							{
							case 1: object.Display_remaning();
									break;
							case 2: object.Display_given();
									break;
							case 3: Scanner read = new Scanner(System.in);
									System.out.println("Enter the number of chocolates given: ");
									int add = read.nextInt();
									object.Modify(add);
									read.close();
									break;
							case 4: object.Add_variety();
									break;
							case 5: object.Show_variety();
									break;
							case 6: object.Total_weight();
									break;
							case 7: object.Sort();
									break;
							case 8: System.out.println("Exit");
									break;
							default: System.out.println("invalid input");
							}
						scan.close();
						//System.out.println(System.in.available());
						System.out.println("Ntohing");
						}while(choice!=8);
						break;
				case 2: do
						{
						System.out.println("Press 1 to display remaing sweets \n Press 2 to display total sweets given\n Press 3 to add number of sweets given\n Press 4 to add variety of chocolate pesent(based on weight) \n Press 5 to show the variety of chocolates present(based on based) \n Press 6 for Total weight of the gift(only sweets) \n Press 7 to Exit \n");
						choice = in.nextInt();
						Sweets newsweets = new Sweets(Total_sweets);
							switch(choice)
							{
							case 1: newsweets.Display_remaning();
									break;
							case 2: newsweets.Display_given();
									break;
							case 3: System.out.println("Enter the number of sweets given: ");
									int add = in.nextInt();
									newsweets.Modify(add);
									break;
							case 4: newsweets.Add_variety();
									break;
							case 5: newsweets.Show_variety();
									break;
							case 6: newsweets.Total_weight();
									break;
							case 7: System.out.println("Exit");
									break;
							default: System.out.println("invalid input");
							}
						}while(choice!=7);
						break;
				
				}
		}while(choice!=3);
		in.close();
    }
}
