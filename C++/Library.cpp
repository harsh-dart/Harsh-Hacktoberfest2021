#include<fstream.h>
#include<conio.h>
#include<stdio.h>
#include<process.h>
#include<string.h>
#include<iomanip.h>
class book
{
	char bno[6];
	char bname[50];
	char aname[20];
  public:
	void create_book()
	{
	cout<<"\nNEW BOOK ENTRY...\n";
	cout<<"\nEnter The book no.";
	cin>>bno;
	cout<<"\n\nEnter The Name of The Book ";
	gets(bname);
	cout<<"\n\nEnter The Author's Name ";
	gets(aname);
	cout<<"\n\n\nBook Created..";
    }
    void show_book()
    {
	cout<<"\nBook no. : "<<bno;
	cout<<"\nBook Name : ";
	puts(bname);
	cout<<"Author Name : ";
	puts(aname);
    }
    void modify_book()
    {
	cout<<"\nBook no. : "<<bno;
	cout<<"\nModify Book Name : ";
	gets(bname);
	cout<<"\nModify Author's Name of Book : ";
	gets(aname);
    }
   char* retbno()
    {
	return bno;
    }
 void report()
    {cout<<bno<<setw(30)<<bname<<setw(30)<<aname<<endl;}
};         //class ends here
class student
{
    char admno[6];
    char name[20];
    char stbno[6];
    int token;
public:
    void create_student()
    {
	clrscr();
	 cout<<"\nNEW STUDENT ENTRY...\n";
	cout<<"\nEnter The admission no. ";
	cin>>admno;
	cout<<"\n\nEnter The Name of The Student ";
	gets(name);
	token=0;
	stbno[0]='/0';
	cout<<"\n\nStudent Record Created..";
    }
    void show_student()
    {
	cout<<"\nAdmission no. : "<<admno;
	cout<<"\nStudent Name : ";
	puts(name);
	cout<<"\nNo of Book issued : "<<token;
	if(token==1)
	    cout<<"\nBook No "<<stbno;
    }
fstream fp,fp1;
book bk;
student st;
void write_book()
{
    char ch;
    fp.open("book.dat",ios::out|ios::app);
    do
    {
	clrscr();
	bk.create_book();
	fp.write((char*)&bk,sizeof(book));
	cout<<"\n\nDo you want to add more record..(y/n?)";
	cin>>ch;
    }while(ch=='y'||ch=='Y');
    fp.close();
}
void write_student()
{
    char ch;
    fp.open("student.dat",ios::out|ios::app);
    do
    {
	st.create_student();
	fp.write((char*)&st,sizeof(student));
	cout<<"\n\ndo you want to add more record..(y/n?)";
	cin>>ch;
    }while(ch=='y'||ch=='Y');
    fp.close();
}
void display_spb(char n[])
{
    cout<<"\nBOOK DETAILS\n";
    int flag=0;
    fp.open("book.dat",ios::in);
    while(fp.read((char*)&bk,sizeof(book)))
    {
	if(strcmpi(bk.retbno(),n)==0)
	{
	    bk.show_book();
	     flag=1;
	}
    }
    fp.close();
    if(flag==0)
	cout<<"\n\nBook does not exist";
              getch();
}
void display_sps(char n[])
{
    cout<<"\nSTUDENT DETAILS\n";
    int flag=0;
    fp.open("student.dat",ios::in);
    while(fp.read((char*)&st,sizeof(student)))
    {
	if((strcmpi(st.retadmno(),n)==0))
	{
	    st.show_student();
	    flag=1;
	}
    }
    fp.close();
    if(flag==0)
	    cout<<"\n\nStudent does not exist";
     	    getch();
}
void delete_student()
{
    char n[6];
    int flag=0;
    clrscr();
	cout<<"\n\n\n\tDELETE STUDENT...";
	cout<<"\n\nEnter The admission no. of the Student You Want To Delete : ";
	cin>>n;
	fp.open("student.dat",ios::in|ios::out);
	fstream fp2;
	fp2.open("Temp.dat",ios::out);
	fp.seekg(0,ios::beg);
	while(fp.read((char*)&st,sizeof(student)))
    {
	if(strcmpi(st.retadmno(),n)!=0)
		 fp2.write((char*)&st,sizeof(student));
	else
	       flag=1;
    }

    fp2.close();
	fp.close();
	remove("student.dat");
	rename("Temp.dat","student.dat");
	if(flag==1)
	     cout<<"\n\n\tRecord Deleted ..";
	else
	     cout<<"\n\nRecord not found";
	getch();
}
void book_issue()
{
    char sn[6],bn[6];
    int found=0,flag=0;
    clrscr();
    cout<<"\n\nBOOK ISSUE ...";
    cout<<"\n\n\tEnter The student's admission no.";
    cin>>sn;
    fp.open("student.dat",ios::in|ios::out);
	fp1.open("book.dat",ios::in|ios::out);
	while(fp.read((char*)&st,sizeof(student)) && found==0)
	   {
	if(strcmpi(st.retadmno(),sn)==0)
	{
	    found=1;
	    if(st.rettoken()==0)
	    {
		      cout<<"\n\n\tEnter the book no. ";
		cin>>bn;
		while(fp1.read((char*)&bk,sizeof(book))&& flag==0)
		{
		       if(strcmpi(bk.retbno(),bn)==0)
		    {
			bk.show_book();
			flag=1;
			st.addtoken();
			st.getstbno(bk.retbno());
			       int pos=-1*sizeof(st);
			fp.seekp(pos,ios::cur);
			fp.write((char*)&st,sizeof(student));
			cout<<"\n\n\t Book issued successfully\n\nPlease Note: Write current date in backside of book and submit within 15 days fine Rs. 1 for each day after 15 days period";
		    }
		    }
		  if(flag==0)
			cout<<"Book no does not exist";
	    }
		else
		  cout<<"You have not returned the last book ";

	}
    }
	  if(found==0)
	cout<<"Student record not exist...";
    getch();
      fp.close();
      fp1.close();
}
void book_deposit()
{
    char sn[6],bn[6];
    int found=0,flag=0,day,fine;
    clrscr();
    cout<<"\n\nBOOK DEPOSIT ...";
    cout<<"\n\n\tEnter The student's admission no.";
    cin>>sn;
    fp.open("student.dat",ios::in|ios::out);
    fp1.open("book.dat",ios::in|ios::out);
    while(fp.read((char*)&st,sizeof(student)) && found==0)
       {
	if(strcmpi(st.retadmno(),sn)==0)
	{
	    found=1;
	    if(st.rettoken()==1)
	    {
	    while(fp1.read((char*)&bk,sizeof(book))&& flag==0)
	    {
	       if(strcmpi(bk.retbno(),st.retstbno())==0)
	    {
		bk.show_book();
		flag=1;
		cout<<"\n\nBook deposited in no. of days";
		cin>>day;
		if(day>15)
		{
		   fine=(day-15)*1;
		   cout<<"\n\nFine has to deposited Rs. "<<fine;
		}
		    st.resettoken();
		    int pos=-1*sizeof(st);
		    fp.seekp(pos,ios::cur);
		    fp.write((char*)&st,sizeof(student));
		    cout<<"\n\n\t Book deposited successfully";
	    }
	    }
	  if(flag==0)
	    cout<<"Book no does not exist";
	      }
	 else
	    cout<<"No book is issued..please check!!";
	}
       }
      if(found==0)
    cout<<"Student record not exist...";
    getch();
  fp.close();
  fp1.close();
  }
void intro()
{
    clrscr();
    cout<<"\n\t*********** Library Management System ************"<<endl;
    cout<<"\n\nMADE BY : Fazil Khan \nRoll no.:22 \nand\nSuyash Karhale\nRoll no.:16\n";
    cout<<"\n\nCLASS   : CO3I ";
    getch();
}
void admin_menu()
{
    clrscr();
    int ch2;
    cout<<"\n\n\n\tADMINISTRATOR MENU";
    cout<<"\n\n\t1.CREATE STUDENT RECORD";
    cout<<"\n\n\t2.DISPLAY ALL STUDENTS RECORD";
    cout<<"\n\n\t5.DELETE STUDENT RECORD";
    cout<<"\n\n\t6.CREATE BOOK ";
    cout<<"\n\n\t11.BACK TO MAIN MENU";
    cout<<"\n\n\tPlease Enter Your Choice (1-7) ";
    cin>>ch2;
    switch(ch2)
    {
	    case 1: clrscr();
		write_student();break;
	    case 2: display_alls();break;
	    
  case 5: delete_student();break;
	case 6: clrscr();
	    write_book();break;
     case 11: return;
	      default:cout<<"\a";
       }
       admin_menu();
}
void main()
{
    char ch;
    intro();
    do
    {
	clrscr();
	cout<<"\n\n\n\tMAIN MENU";
	cout<<"\n\n\t01. BOOK ISSUE";
	cout<<"\n\n\t02. BOOK DEPOSIT";
	  cout<<"\n\n\t03. ADMINISTRATOR MENU";
	  cout<<"\n\n\t04. EXIT";
	  cout<<"\n\n\tPlease Select Your Option (1-4) ";
	  ch=getche();
	  switch(ch)
	  {
	    case '1':clrscr();
		 book_issue();
		    break;
	      case '2':book_deposit();
		     break;
	      case '3':admin_menu();
		 break;
	      case '4':exit(0);
	      default :cout<<"\a";
	}
	}while(ch!='4');
}
//***************************************************************
//                END OF PROJECT
//***************************************************************
