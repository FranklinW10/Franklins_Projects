import java.util.Random;

public class MagicHealingSword extends Sword
{
    protected Character owner;
    /**
     * Constructor
     * 
     * @param n
     * @param o passes ower of sword through
     */
    public MagicHealingSword(String n, Character o)
    {
        super(n);
        owner = o;
    }

    /**
     * deals damage like a normal sword but heals the owner a ranodm amount between 0 and 4
     * @return total damage
     */
    @Override
    public int damage()
    {
        int totalDamage = super.damage();
        Random r =new Random();
        int totalHeal = r.nextInt(5);
        owner.heal(totalHeal);
        return totalDamage;
    }

    @Override
    public String toString()
    {
        String weaponInfo = name+"(MagicHealingSword)";
        return weaponInfo;
    }
        
        
}
