
package pos;
public class Manager extends Staff implements log {

 
    public Manager()
    {
        
    }
   private final String Username="Admin";
   private final String Passwod="12345678";

 
   @Override
   public boolean login(String Username, String Password)
   {
       return (Username.equals("Admin")&&Password.equals("12345678"));
   }
}
