class arraycount2
{
                                   public static void main(String args[])
                                    {
                                     int ar[]= {10,12,13,14,16};
                                      int count=0;  
                                  
                                   //for each loop
                             for (int var : ar)
                              {
                           System.out.println(var);
                             //count++;
//count +=1;
count = count +1;
              
                                   }   
System.out.println("no of element : "+count);

                                     }
}