import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class TestMain {

	public static void main(String[] args) {
		TestMain tm = new TestMain();
		//tm.byteTest();
		//tm.xiaHuaXian();
		tm.switchTest("two");
		
		
	}
	
	public void getSystem(){
		Map<String,String> map = System.getenv();
		Set<Entry<String,String>> set = map.entrySet();
		Iterator<Entry<String,String>> it = set.iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			String key = entry.getKey();
			String value= entry.getValue();
			System.out.println(key +"= " + value);
		}
		
	}
	
	/**
	 * ����������ʾ����
	 */
	public void byteTest(){
		int a = 0b001000;
		int b = 0b001000;
		System.out.println(a + b);
	}
	
	/**
	 * �������������Գ����»���
	 */
	public void xiaHuaXian(){
	    int a = 10_00;  
	    byte c = 0b0001_1000;
	    System.out.println(a + c);
	}
	
	/**
	 * switch ���������ַ���
	 */
	public void switchTest(String str){
		switch(str){
			case "one":
				System.out.println("ONE");
				break;
			case "two":
				System.out.println("TWO");
				break;
		}
	}
	
	/**
	 * ����һ������ʵ��������Ҫ����ϸ˵�����ͣ�ֻ����<>,���������Զ�����ƥ��
	 */
	
	public void fanXing(){
		//Map<String,List<String>> map = new HashMap<String,List<String>>();
		Map<String,List<String>> map = new HashMap<>();
		
		//final List<Integer> piDigits = [ 1,2,3,4,5,8 ]; 
		
	}
	
    public static <T> void addToList (List<T> listArg, T... elements) {  
    	List l = new ArrayList<Number>();  
        List<String> ls = l;       // unchecked warning  
        l.add(0, new Integer(42)); // another unchecked warning  
        String s = ls.get(0);
    	
    	
        for (T x : elements) {  
          listArg.add(x);  
        }  
      }  
    
    static String readFirstLineFromFile(String path) {  
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {  
          return br.readLine();  
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
      }  

}
