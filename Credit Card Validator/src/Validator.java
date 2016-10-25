import java.util.Scanner;
import java.io.*;
public class Validator
	{
		static long digit;
		static long dig1;
		static long dig2;
		static long new2;
		static int counter;
		static long ccNum=0;
		public static void main(String[] args) throws IOException
			{
				Scanner file = new Scanner(new File("creditCardNumbers.txt"));
				for (int i=0;i<100;i++)
					{
						ccNum = file.nextLong();
						validate();
					}
				System.out.println("There are "+counter+" possible valid CC numbers");
			}
		public static void validate()
		{
			new2=0;
			for (int i=0;i<16;i++)
				{
					if (i%2==1)
						{
							digit=ccNum%10*2;
							if (digit>9)
								{
									dig1=digit%10;
									digit=digit/10;
									dig2=digit%10;
									new2=new2+dig1+dig2;
									ccNum=ccNum/10;
								}
							else
								{
									new2=new2+digit;
									ccNum=ccNum/10;
								}
						}
					else
						{
							new2=new2+ccNum%10;
							ccNum=ccNum/10;
						}
				}
			if (new2%10==0)
				{
					System.out.println("could be");
					counter++;
				}
			else
				{
					System.out.println("no");
				}
		}
	}
