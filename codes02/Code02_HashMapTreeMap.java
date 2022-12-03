import java.util.HashMap;

public class Code02_HashMapTreeMap {

    //K,V表
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("lisi","I am lisi");
        System.out.println(map.containsKey("lisi"));
        System.out.println(map.containsKey("li"));
        System.out.println(map.get("lisi"));
        map.put("lisi","He is lisi");
        System.out.println(map.get("lisi"));

    }
}
