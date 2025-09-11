import static org.junit.Assert.*;
import org.junit.Test;

public class Project2Tester {
    
    //Making sure the getDA function works correctly
    @Test
    public void getDATest(){
        Elf e = new Elf("Franklin", 40, 10);
        assertEquals(e.getdA(), false);
    }
     
    //Makes sure char is healing correctly
    @Test
    public void testCharHeal(){
        Barbarian s = new Barbarian("Tommy", 40, 10 );
        s.heal(10);
        assertEquals(s.getHealth(), 50);
    }

    //makes sure char is taking damage correctly
    @Test
    public void TestCharDam(){
        Wizard w = new Wizard("Franklin", 40,10);
        w.dealDamage(5);
        assertEquals(w.getHealth(), 35);
    }

    //makes sure char is not being effected by negative damage
    @Test
    public void TestCharNegDam(){
        Wizard w = new Wizard("Franklin", 40,10);
        w.dealDamage(-20);
        assertEquals(w.getHealth(), 40);
    }
     // if special ability turns are at 5 special ability should return 10 damage
    @Test
    public void TestSpecialAbility(){
        Wand w = new Wand("wand");
        w.setSpecialTurns(5);   
        int result = w.useSpecial();
        assertEquals(result, 10);
    }
    // staff turns should go down by one for each turn animal is summonedXX$
    @Test
    public void TestSummonAbility(){
        Staff s = new Staff("Staff");
        s.setSummonTurns(3);  
        s.setSummoned(true);
        s.damage();
        assertEquals(s.getSummonTurns(), 2);
    }




}
