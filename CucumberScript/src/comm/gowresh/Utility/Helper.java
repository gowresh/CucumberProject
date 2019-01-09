package comm.gowresh.Utility;

public class Helper {

	 public static String getOnlySessionCount(String tempWindowValue) {
		 
	
		 String[] input = tempWindowValue.split(":");
		 
		 String take = input[1];
		 
		 String session = "";
		 
		 for(int i = 0; i <take.length(); i++) {
			 if(take.charAt(i) == ' ')
				 break;
			 else
				 session = session + take.charAt(i);
		 }
		 
		 return session;
	 }
}
