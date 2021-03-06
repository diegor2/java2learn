package pt.c06patterns.factory.s04.crab;

import pt.c06patterns.factory.s04.interfaces.Aquatic;
import pt.c06patterns.factory.s04.interfaces.AquaticType;

public class Crab implements Aquatic
{
    /*
       o o
       | |  
     /-----\
     |     |
     \-----/
     / / \ \
     */
    
    private AquaticType type;
    
    public Crab(AquaticType type) {
       this.type = type;
    }
   
    public String aquaticImage()
    {
       String image =
               "  o o\n" +
               "  | |\n" +  
               "/-----\\\n" +
               "|     |\n" +
               "\\-----/\n" +
               "/ / \\ \\\n";
       
       if (type == AquaticType.SWEET)
         image = 
                   "  * *\n" +
                   "  | |\n" +  
                   "/-----\\\n" +
                   "|     |\n" +
                   "\\-----/\n" +
                   "/ / \\ \\\n";
       
       return image;
    }
}
