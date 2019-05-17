//Name: MD.Mamunuz Zaman Sarker
//ID: 15-29817-2
//Section: G

import java.util.Scanner;

class Contact
{
	private String ContactName;
	String ContactNumber[]= new String[10];
	private int ContactNumberListArrayLength=0;
	private String ContactGender;
	private String ContactMail;
	private String ContactDateOfBirth;
	static Contact ContactList[]= new Contact[1000];
	static int j=0;
	
	Contact()
	{
		ContactName="";
		ContactNumber[ContactNumberListArrayLength]="";
		ContactGender="";
		ContactMail="";
		ContactDateOfBirth="";
	}
	
	Contact(String cN,String cNum,String cG,String cM,String cDOB)
	{
		ContactName=cN;
		ContactNumber[ContactNumberListArrayLength]=cNum;
		ContactNumberListArrayLength++;
		ContactGender=cG;
		ContactMail=cM;
		ContactDateOfBirth=cDOB;
		j++;
		//System.out.println("\t\n[[ New Contact Added Successfully :) ]]\n");
	}

	void addContact(String cN,String cNum,String cG,String cM,String cDOB,Contact con)
	{
		ContactName=cN;
		ContactNumber[ContactNumberListArrayLength]=cNum;
		ContactNumberListArrayLength++;
		ContactGender=cG;
		ContactMail=cM;
		ContactDateOfBirth=cDOB;
		ContactList[j]=con;
		j++;
		//System.out.println("\t\n[[ New Contact Added Successfully :) ]]\n");
	}

	static void sortContactList()
	{
		/*char sCC='\0';
		Contact sCN=null;

		for(int i=0;i<j;i++)
		{
			if(ContactList[i+1]!=null)
			{
				if(ContactList[i].ContactName.charAt(0)<ContactList[i+1].ContactName.charAt(0))
				{
					sCC=ContactList[i].ContactName.charAt(0);
					sCN=ContactList[i];
				}
				else if(ContactList[i].ContactName.charAt(0)>ContactList[i+1].ContactName.charAt(0))
				{
					ContactList[i]=ContactList[i+1];
					ContactList[i+1]=sCN;
					sCN=ContactList[i];
					sCC=ContactList[i].ContactName.charAt(0);
				}
			}

			/*if((ContactList[i].ContactName.charAt(0)<ContactList[i+1].ContactName.charAt(0))&&(ContactList[i+1]!=null))
			{
				sCC=ContactList[i].ContactName.charAt(0);
				sCN=ContactList[i];
			}
			else if((ContactList[i].ContactName.charAt(0)>ContactList[i+1].ContactName.charAt(0))&&(ContactList[i+1]!=null))
			{
				ContactList[i]=ContactList[i+1];
				ContactList[i+1]=sCN;
				sCN=ContactList[i];
				sCC=ContactList[i].ContactName.charAt(0);

			}
		}*/
	}

	static void deleteContact(int cLN)
	{
		if((cLN==0)&&(j==1))
		{
			ContactList[cLN]=null;
			j--;
		}
		else
		{
			for(int i=cLN;i<j;i++)
			{
				ContactList[i]=ContactList[i+1];
			}
			j--;
			ContactList[j]=null;
		}
		//System.out.println("\n\t\tContact has been deleted Successfully!");
	}
	
	void addNewNumber(String cNum)
	{
		int a=this.ContactNumberListArrayLength;
		this.ContactNumber[a]=cNum;
		a++;
		this.ContactNumberListArrayLength=a;
		//System.out.println("\n\t[[ New Number added Successfully for the Person :) ]]\n");
	}

	void updateOldNumber(String cNum, int cNL)
	{
		this.ContactNumber[cNL]=cNum;
		//System.out.println("\n\t[[ Number Updated Successfully for the Person :) ]]\n");
	}

	void deleteOldNumber(int cNum)
	{
		int a=this.ContactNumberListArrayLength;
		if((cNum==0)&&(a==1))
		{
			System.out.println("\nUnable to delete the Contact Number!!! :(\n\n\tAfter all its mendatory to atleast have one phone number for a Contact! ");
		}
		else
		{
			for(int i=cNum;i<a;i++)
			{

				this.ContactNumber[i]=this.ContactNumber[i+1];
			}
			a--;
			this.ContactNumber[a]=null;
			this.ContactNumberListArrayLength=a;
			System.out.println("\n\t[[ Old Number of that Person deleted Successfully :) ]]\n");
		}
		
	}
	
	void ShowInfo()
	{
		System.out.println("\nContact Infromation : ");
		System.out.println("\n\tContact Name : "+this.ContactName);
		System.out.println("\tContact Number : ");
		int b=this.ContactNumberListArrayLength;
		for(int c=0;c<b;c++)
		{
			System.out.println("\t\t"+(c+1)+". "+this.ContactNumber[c]);
		}
		System.out.println("\tContact Gender : "+this.ContactGender);
		System.out.println("\tContact Mail : "+this.ContactMail);
		System.out.println("\tContact Date of Birth : "+this.ContactDateOfBirth);
		
	}
	
	static void TotalContacts()
	{
		System.out.println("\n\tAll Contacts : ");
		if(j==0)
		{
			System.out.println("\n\t\tNo Contacts Available........ :/ \n\n\t\t\tPlease Add One...... :) ");
		}
		else
		{	
			for(int d=0;d<j;d++)
			{
				System.out.println("\t\t\t"+(d+1)+". "+ContactList[d].ContactName);
			}
		}
		System.out.println("---------------------------------------------");	
	}

	static void SearchContact(String src)               
	{																	// SEARCH
		int f=0;
		for(int e=0;e<j;e++)
		{
			String MatchContactNameWithUserInput="";
			String MatchContactEmailWithUserInput="";
			String MatchFromContactNumberArrayList="";

			int LengthOfCurrentObjectContactName=ContactList[e].ContactName.length();
			int LengthOfCurrentObjectContactMail=ContactList[e].ContactMail.length();
			int LengthOfUserInputString=src.length();
			int LengthOfContactNumberForCurrentIndex;
			int LengthOfContactNumberArrayListForCurrentObject=ContactList[e].ContactNumberListArrayLength;

			if(LengthOfUserInputString<=LengthOfCurrentObjectContactName)              // Search by Contact Name by Matching User Iput String as well as length!
			{
				for(int i=0;i<LengthOfUserInputString;i++)
				{
					MatchContactNameWithUserInput+=ContactList[e].ContactName.charAt(i);
				}
			}
			else if(LengthOfUserInputString<=LengthOfCurrentObjectContactMail)               // Search by Contact Mail by Matching User Iput String as well as length!
			{
				for(int i=0;i<LengthOfUserInputString;i++)
				{
					MatchContactEmailWithUserInput+=ContactList[e].ContactMail.charAt(i);
				}
			}

			if(src.equals(MatchContactNameWithUserInput))                       // Confirmation & Show output of Matching information by Name!
			{
				f=1;
				System.out.println("\n\t\t[[ Match Found by Name :) ]]");
				ContactList[e].ShowInfo();
			}
			else if(src.equals(MatchContactEmailWithUserInput))					// Confirmation & Show output of Matching information by Email!
			{
				f=1;
				System.out.println("\n\t\t[[ Match Found by Email :) ]]");
				ContactList[e].ShowInfo();
			}

			for(int i=0;i<LengthOfContactNumberArrayListForCurrentObject;i++)      // Search by Contact Number from Contact Index by Matching User Iput String as well as length!
			{
				String StoreContactNumberFromCurrentIndex="";
				LengthOfContactNumberForCurrentIndex=ContactList[e].ContactNumber[i].length();

				if(LengthOfUserInputString<=LengthOfContactNumberForCurrentIndex)
				{
					StoreContactNumberFromCurrentIndex=ContactList[e].ContactNumber[i];
					for(int k=0;k<LengthOfUserInputString;k++)
					{
						MatchFromContactNumberArrayList+=StoreContactNumberFromCurrentIndex.charAt(k);
					}
				}

				if(src.equals(MatchFromContactNumberArrayList))     // Confirmation & Show output of Matching information by Number!
				{
					f=1;
					System.out.println("\n\t\t[[ Match Found by Number :) ]]");
					ContactList[e].ShowInfo();
				}
				MatchFromContactNumberArrayList="";

			}

		}
		if(f==0)                             //Incase match not found!
		{
			System.out.println("\n\t\t[[ Match Not Found! :( ]]");
		}
	}

	static void Menu()
	{
		System.out.println("\n\t\t................................[[ CONTACT MENU ]]...........................\n");
		System.out.println("\t\t\t1. See All Contacts");
		System.out.println("\t\t\t2. See Details Information of a Contact");
		System.out.println("\t\t\t3. Add New Contacts");
		System.out.println("\t\t\t4. Add New Number for Old Contacts");
		System.out.println("\t\t\t5. Update Exsisting Contact Information");
		System.out.println("\t\t\t6. Update Exsisting Contact Phone Number");
		System.out.println("\t\t\t7. Search Contact");
		System.out.println("\t\t\t8. Delete Contact");
		System.out.println("\t\t\t9. Delete a Number from Old Contact");
		System.out.println("\t\t\t0. Exit Program");
		System.out.println("\n\t\t\t/// Enter any of those List number to perform a task ////\n");
		System.out.println("\t------------------------------------------------------------------------------------------------");

		Scanner Scan=new Scanner(System.in);
		int UserInput=Scan.nextInt();

		if(UserInput==1)                              // See All Contacts
		{
			TotalContacts();
			Menu();
		}
		else if(UserInput==2)                        // See Details Information of a Contact
		{
			TotalContacts();
			System.out.println("Select the list NO. from ALL Contacts to view details Information....... ");
			int IndexNO=Scan.nextInt();
			IndexNO--;
			ContactList[IndexNO].ShowInfo();
			Menu();
		}
		else if(UserInput==3)                   // Add New Contacts
		{
			int nmF=0;
			int numF=0;
			int cNmI=0;
			int cNumI=0;
			int emlF=0;
			int cnfrm=0;

			String cN="";
			String cNum="";
			String cG="";
			String cM="";
			String cDOB="";
			System.out.println("\nPerson Name ?");
			cN=Scan.next();
			for(int i=0;i<j;i++)
			{
				if(cN.equals(ContactList[i].ContactName))
				{
					nmF=1;
					cNmI=i;
				}	
			}
			if(nmF==1)
			{
				System.out.println("\nA Contact with same person name already exists..... Do you still want to continue?\n\t\t1. Yes\n\t\t2. No");
				cnfrm=Scan.nextInt();
				if(cnfrm==1)
				{
					nmF=0;
				}
				else if(cnfrm==2)
				{
					Menu();
				}
			}
			
			if(nmF==0)
			{
				System.out.println("\nPerson Phone Number ?");
				cNum=Scan.next();
				for(int i=0;i<j;i++)
				{
					for(int k=0;k<ContactList[i].ContactNumberListArrayLength;k++)
					{
						if(cNum.equals(ContactList[i].ContactNumber[k]))
						{
							numF=1;
							cNumI=i;
						}
					}
				}
				if((numF==1)&&(cNmI!=cNumI))
				{
					System.out.println("\nA Contact with same phone number for different person already exists..... You can't set same Phone Number for two different Person! Go, delete the previous one 1st!");
					Menu();
				}
				else if((numF==1)&&(cNmI==cNumI))
				{
					System.out.println("\nYou are trying to add a Phone number which already exists! Go to Contact list and see yourself! ");
					Menu();
				}
				else if(numF==0)
				{
					System.out.println("\nPerson Gender ?\n\t\t1. Male\n\t\t2. Female");
					int cGN=Scan.nextInt();
					if(cGN==1)
					{
						cG="Male";
					}
					else if(cGN==2)
					{
						cG="Female";
					}
					System.out.println("\nPerson Mail ID ?");
					cM=Scan.next();
					for(int i=0;i<j;i++)
					{
						if(cM.equals(ContactList[i].ContactMail))
						{
							emlF=1;
						}
					}
					if(emlF==1)
					{
						int emF=0;
						do
						{
							emF=0;
							System.out.println("\nA Contact with same Email ID for different person already exists..... You can't set same Email ID for two different Person! ");
							//Menu();
							System.out.println("\nPlease re enter Mail ID properly..........");
							cM=Scan.next();

							for(int i=0;i<j;i++)
							{
								if(cM.equals(ContactList[i].ContactMail))
								{
									emF=1;
								}
							}
									
						}while(emF==1);
					}
					System.out.println("\nPerson Date of Birth ?");
					cDOB=Scan.next();
					ContactList[j]=new Contact(cN,cNum,cG,cM,cDOB);
					sortContactList();
					System.out.println("\t\n[[ New Contact Added Successfully :) ]]\n");
					Menu();
				}
			}
		}
		else if(UserInput==4)                           // Add New Number for Old Contacts
		{
			TotalContacts();
			System.out.println("Select the list NO. from ALL Contacts to add new Number for that particular Person ");
			int IndexNO=Scan.nextInt();
			IndexNO--;
			System.out.println("\nNow enter new Number of that Person ");
			String cN=Scan.next();
			
			int cNumI=0;
			int numF=0;
			int cNmI=IndexNO;

			for(int i=0;i<j;i++)
			{
				for(int k=0;k<ContactList[i].ContactNumberListArrayLength;k++)
				{
					if(cN.equals(ContactList[i].ContactNumber[k]))
					{
						numF=1;
						cNumI=i;
					}
				}
			}
			if((numF==1)&&(cNmI!=cNumI))
			{
				System.out.println("\nA Contact with same phone number for different person already exists..... You can't set same Phone Number for two different Person! Go, delete the previous one 1st!");
				Menu();
			}
			else if((numF==1)&&(cNmI==cNumI))
			{
				System.out.println("\nYou are trying to add a Number which already exists! Go to Contact list and see yourself! ");
				Menu();
			}
			else if(numF==0)
			{
				ContactList[IndexNO].addNewNumber(cN);
				System.out.println("\n\t[[ New Number added Successfully for the Person :) ]]\n");
				Menu();
			}
		}
		else if(UserInput==5)                                  // Update Exsisting Contact Information
		{
			TotalContacts();
			System.out.println("Select the list NO. from ALL Contacts to Update the particular Person Information ");
			int IndexNO=Scan.nextInt();
			IndexNO--;
			String cN="";
			String cG="";
			String cM="";
			String cDOB="";

			int nmF=0;
			int numF=0;
			int cNmI=0;
			int cNumI=0;

			System.out.println("\nPerson Name ?");
			cN=Scan.next();
			for(int i=0;i<j;i++)
			{
				if(cN.equals(ContactList[i].ContactName))
				{
					nmF=1;
					cNmI=i;
				}	
			}
			if((nmF==1)&&(cNmI!=IndexNO))
			{
				System.out.println("\nA Contact with same person name already exists..... Do you still want to continue?\n\t\t1. Yes\n\t\t2. No");
				int cnfrm=Scan.nextInt();
				if(cnfrm==1)
				{
					nmF=0;
				}
				else if(cnfrm==2)
				{
					Menu();
				}
			}
			else if((nmF==1)&&(cNmI==IndexNO))
			{
				nmF=0;
				System.out.println("\nYou set the Contact Name as it is before! ");
			}

			if(nmF==0)
			{
				System.out.println("\nPerson Gender ?\n\t\t1. Male\n\t\t2. Female");
				int cGN=Scan.nextInt();
				if(cGN==1)
				{
					cG="Male";
				}
				else if(cGN==2)
				{
					cG="Female";
				}
				System.out.println("\nAlso want to update Email ID?\n\t\t1. Yes\n\t\t2. No");
				int cnfrm=Scan.nextInt();
				if(cnfrm==1)
				{
					int emlF=0;
					int emlFI=0;
					System.out.println("\nPerson Mail ID ?");
					cM=Scan.next();
					for(int i=0;i<j;i++)
					{
						if(cM.equals(ContactList[i].ContactMail))
						{
							emlF=1;
							emlFI=i;
						}
					}
					if((emlF==1)&&(emlFI!=IndexNO))
					{
						int emF=0;
						do
						{
							emF=0;
							System.out.println("\nA Contact with same Email ID for different person already exists..... You can't set same Email ID for two different Person! ");
							//Menu();
							System.out.println("\nPlease re enter Mail ID properly..........");
							cM=Scan.next();

							for(int i=0;i<j;i++)
							{
								if(cM.equals(ContactList[i].ContactMail))
								{
									emF=1;
									emlFI=i;
								}
							}
							if((emlF==1)&&(emlFI==IndexNO))
							{
								emF=0;
								System.out.println("\nThis Email ID already exists for the person! You don't need to update that! ");
							}
									
						}while(emF==1);
					}
					else if((emlF==1)&&(emlFI==IndexNO))
					{
						System.out.println("\nThis Email ID already exists for the person! You don't need to update that! ");
					}
				}
				else if(cnfrm==2)
				{
					cM=ContactList[IndexNO].ContactMail;
				}
				System.out.println("\nPerson Date of Birth ?");
				cDOB=Scan.next();
				ContactList[IndexNO].ContactName=cN;
				ContactList[IndexNO].ContactGender=cG;
				ContactList[IndexNO].ContactMail=cM;
				ContactList[IndexNO].ContactDateOfBirth=cDOB;
				System.out.println("\n\t\tInformation Updated Successfully for the Person :)");
				Menu();
			}
		}
		else if(UserInput==6)                              // Update Exsisting Contact Phone Number
		{
			int numF=0;
			int cNumI=0;
			//int cNmI=0;

			TotalContacts();
			System.out.println("Select the list NO. from ALL Contacts to Update Number for that particular Person ");
			int IndexNO=Scan.nextInt();
			IndexNO--;
			int cNmI=IndexNO;
			ContactList[IndexNO].ShowInfo();
			System.out.println("\nNow enter the ContactList NO. that you want to Update ");
			int uN=Scan.nextInt();
			uN--;
			System.out.println("\nNow enter the Updated Number ");
			String cNum=Scan.next();
			for(int i=0;i<j;i++)
			{
				for(int k=0;k<ContactList[i].ContactNumberListArrayLength;k++)
				{
					if(cNum.equals(ContactList[i].ContactNumber[k]))
					{
						numF=1;
						cNumI=i;
					}
				}
			}
			if((numF==1)&&(cNmI!=cNumI))
			{
				System.out.println("\nA Contact with same phone number for different person already exists..... You can't set same Phone Number for two different Person! Go, delete the previous one 1st!");
				Menu();
			}
			else if((numF==1)&&(cNmI==cNumI))
			{
				System.out.println("\nYou are trying to add a Phone number which already exists! Go to Contact list and see yourself! ");
				Menu();
			}

			if(numF==0)
			{
				ContactList[IndexNO].updateOldNumber(cNum,uN);
				System.out.println("\n\t[[ Number Updated Successfully for the Person :) ]]\n");
				Menu();
			}
		}
		else if(UserInput==7)                                    // Search Contact
		{
			System.out.println("Enter somethig to search from Contact.....  [[ EX. Name, Phone Number, Email ID. ]]");
			String us=Scan.next();
			SearchContact(us);
			Menu();
		}
		else if(UserInput==8)                                // Delete Contact
		{
			TotalContacts();
			System.out.println("Select the list NO. from ALL Contacts to Delete the Contact Information from Contact");
			int IndexNO=Scan.nextInt();
			IndexNO--;
			deleteContact(IndexNO);
			System.out.println("\n\t\tContact has been deleted Successfully!");
			Menu();
		}
		else if(UserInput==9)                                   // Delete a Number from Old Contact
		{
			TotalContacts();
			System.out.println("Select the list NO. from ALL Contacts to delete Old Number for that particular Person ");
			int IndexNO=Scan.nextInt();
			IndexNO--;
			ContactList[IndexNO].ShowInfo();
			System.out.println("\nNow enter Contact Number List NO. ");
			int Nn=Scan.nextInt();
			Nn--;
			ContactList[IndexNO].deleteOldNumber(Nn);
			Menu();
		}
		else if(UserInput==0)                   // Exit Program
		{
			System.out.println("\n\n\t\t\tProgram Closed!");
		}
		else if(UserInput>10)                                  // Tiny Exception Handing!
		{
			System.out.println("\n\n\t\t\tWRONG INPUT!!!!!!!!\n\t\t\tTry Again..............");
			Menu();
		}
	}
	
	public static void main(String []args)
	{
		Contact c1= new Contact();
		c1.addContact("Mzs","01744692979","Male","mzs.munna@gmail.com","28/1/1995",c1);
		//c1.ShowInfo();
		c1.addNewNumber("01759955254");
		//c1.ShowInfo();
		//TotalContacts();
		Contact c2= new Contact();
		c2.addContact("Hanif","01792916592","Male","hanif.honeybee@gmail.com","unknown",c2);
		//c2.ShowInfo();
		c2.addNewNumber("01972916592");
		//c2.ShowInfo();
		//TotalContacts();
		Contact c3= new Contact();
		c3.addContact("Tanbir","01951043548","Male","tanu.tanbir@gmail.com","unknown",c3);
		sortContactList();
		//c3.ShowInfo();
		c3.addNewNumber("01782101042");
		//TotalContacts();

		//SearchContact("Tan");
		//SearchContact("0174");
		//SearchContact("mzs.");
		//SearchContact("hanif.honeybee");
		//SearchContact("Mzs");
		Menu();
		
	}

}