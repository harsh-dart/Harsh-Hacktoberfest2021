class arrayexampleloopsum
{
                                   public static void main(String args[])
                                    {
                                     int ar[]= {10,12,13,14,16};
                                        int sum=0;
                                  
                                   //for each loop
                             for (int var : ar)
                              {
                           System.out.println(var);
                             sum=sum + var;
              
                                   }   
System.out.println("total : "+sum);

                                     }
}