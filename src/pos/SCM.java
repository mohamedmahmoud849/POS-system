
package pos;
public class SCM extends Staff implements log{
  public SCM()
    {
        
    }
   private final String Username="scm";
   private final String Passwod="12345678";

 
   @Override
   public boolean login(String Username, String Password)
   {
       return (Username.equals("scm")&&Password.equals("12345678"));
   }
}
