
package pos;


public abstract class  Staff {
    public Staff (String Username, String Password)
            {
                if (Password.length()<8)
                    System.out.println("Password Must be More than 8 Digits");            
            } 
    public Staff()
    {
        
    }
}
