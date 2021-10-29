public class arraylist {
  public static void main(string[] args){
    
    ArrayList<ArrayList<Integer>>list = new ArrayList<>();
    
    for(int i=0; i<3; i++){
      list.add(new ArrayList<>());
    }
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        list.get(i).add(in.nextInt());
      }
    }
    System.out.println(list);
  }
}
