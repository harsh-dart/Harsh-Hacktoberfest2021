import java.util.*;
public class Hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<Character, Integer>  hm = new HashMap<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int oldfrequency = hm.get(ch);
                int newfrequency = oldfrequency + 1;
                hm.put(ch, newfrequency);
            }
            else {
                hm.put(ch, 1);
            }
        }

        char mfc = str.charAt(0);
        for(Character key : hm.keySet()){
            if( hm.get(key) > hm.get(mfc)){
                mfc = key;
            }
        }
        System.out.println(mfc);
    }
}
