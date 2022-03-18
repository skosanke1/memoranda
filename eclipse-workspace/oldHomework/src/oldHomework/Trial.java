package oldHomework;
import java.util.ArrayList;

public class Trial {
public static void main(String[] args) { 
}
	public void insertName(ArrayList<String> pList, String pName)
	{
		for (int i=0; i<pList.size(); i++)
		{
			//Sort alphabetically
			if (pName < pList(i))
			{
			pList.add(i,pName);
			//End
			}			
		}
	}
	public void arrayListRemove(ArrayList<Integer> pList, int pValue) {
	for (int i=0; i<pList.size(); i++)
	{
		if (pList.get(i) == pValue)
			pList.remove(i);
	}
	
}
	
}
