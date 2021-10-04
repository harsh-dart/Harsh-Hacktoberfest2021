import java.util.Scanner;

class Node
{
int rollno;
Node next;

}
public class linkedlistdemo    //singly list
{
     Node START;  
    linkedlistdemo()         //singly ;ist
    {
        START = null;
    }
    void addnode()
    {
       System.out.println("Enter your roll no");
        Scanner sc2 = new Scanner(System.in);
        int rn = sc2.nextInt();
        
        Node newnode = new Node();
        newnode.rollno=rn;
        newnode.next=null;
        if(START==null)
        {
        START=newnode;
        }
        else
        {
        
        Node current=START;
        while(current.next !=null)
        {
            current = current.next;
        }
        current.next=newnode;
        
        }
        
       System.out.println("Data inserted....");
        
        
        
    }
    void deletenodebegin()
    {
        if(START ==null)
        {
        System.out.println("list is empty");
        }
        else
        {
            
         System.out.println("Deleted  : "+START.rollno);
         START = START.next;
            
        }
    }
    void deletenodelast()
    {
    
                if(START ==null)
                 {
                   System.out.println("list empty");
    
                 }
                else
                 {
                  int flag=0;
                   Node current=START;
                   Node pre = current;
                   while(current.next != null)
                   {
                     pre = current;
                     current = current.next;
                   flag=1;
                    }
                if(flag ==0)
                   {
                     START =null;
                     }
                   pre.next=null;
                   System.out.println("DEleted element : "+current.rollno);
                 }
    }
    void traversenode()
    {
       if(START==null) 
       {
       System.out.println("List is empty");
       
       }
       else
       {
       Node current;
       for(current = START ;current!=null;current=current.next)
       {
           System.out.print(" "+current.rollno);
       }
       }
        
        
    }
    void searchnode()
    {
     if(START ==null)
     {
        System.out.println("list is empty");
     }
     else
     {
         System.out.println("Enter searching element");
         Scanner sc3= new Scanner(System.in);
         int sea = sc3.nextInt();
            
         int count = 0;
         Node current;
         for(current=START;current != null;current=current.next)
         {
            if(current.rollno == sea)
              {
                count ++;
                break;
              }
         }
         if(count>0)
         {
             System.out.println("found");
         }
            
         else
         {
              System.out.println("Not found");
         }       
           
     }
    }
 public static void main(String args[]) 
 {
  linkedlistdemo obj = new linkedlistdemo();
  while(true)
  {
         System.out.println("\nPress 1 for insert");
         System.out.println("Press 2 for deletebegin");
         System.out.println("Press 3 for traverse");
         System.out.println("Press 4 for search");
         System.out.println("Press 5 for exit");
          System.out.println("Press 6 for deletelastnode");
        
         System.out.println("Enter your choice");
         Scanner sc = new Scanner(System.in);
         int ch = sc.nextInt();
       
         switch(ch)
          {
              case 1:
                  obj.addnode();
                  break;
              case 2:
                  obj.deletenodebegin();
                  break;
              case 3:
                  obj.traversenode();
                  break;
              case 4:
                  obj.searchnode();
                  break;
              case 5:
                  System.exit(0);
              case 6:
                  obj.deletenodelast();
                  break;
              default:
                   System.out.println("wrong choice");
          }
  }
 }

   
}
