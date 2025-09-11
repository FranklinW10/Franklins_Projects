// Franklin Wohnoutka
import java.util.Random;

public class Barbarian extends Character
{
    protected int Toughness;
    protected Random BlockGenerator;

    /**
     * Constructer 
     * Creates a new barbarian adding the new variable "Toughness"
     * Creates a block randomizer
     * 
     * @param n
     * @param h
     * @param T
     */
    public Barbarian(String n, int h, int T)
    {
        super(n,h);
        Toughness = T;
        BlockGenerator = new Random();
    }

    /**
     * Uses Toughness as the upper bound for the random amount of damage to block
     * Subtracts the block amount from the damage taken by the barbarian 
     * Makes sure the barbarin cant gain health from this blocking
     * Prints out how much damage was blocked
     */
    @Override
    public void dealDamage(int amount)
    {
        int blockAmount = BlockGenerator.nextInt(Toughness+1);
        if(amount < 0)
        {
            System.out.println("Sorry, you can't do negative damage!");
        }

        if(amount-blockAmount >= 0)
        {
            health -= amount-blockAmount;
        }
        else
        {
            health-=0;
        }
        System.out.println("The Barbarian blocks "+blockAmount+" damage!");

        if(blockAmount == Toughness ){
            rage();
        }
    }

    /**
     * If the barbarian gets a random block amount that is equal to its Toughness it becomes raged
     * It just heals 1 so that it isnt too overpowerd
     */
    public void rage()
    {
        System.out.println("The barbarian is now Raged!");
        heal(1);

    }
    @Override
    public String toString()
    {
        String characterInfo = name+" [health:"+health+","+"weapon:"+equippedWeapon+"]";
        return characterInfo;
    }
    



    
}
