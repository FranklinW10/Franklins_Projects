import java.util.Random;

public class Weapon
{
    protected String name;
    protected Random DamageGenerator;
    
    /**
     * Constructor
     * @param n
     */
    public Weapon(String n)
    {
        name = n;
        DamageGenerator = new Random();
    }
    /**
     * does damage between 0 and 1
     * @return damage
     */
    public int damage()
    {
        int damageAmount = DamageGenerator.nextInt(2);
        System.out.println(this+" deals "+damageAmount+" damage!");
        return damageAmount;
    }

    public String toString()
    {
        String weaponInfo = name+"(Weapon)";
        return weaponInfo;
    }

    public String getName(){
        return name;
    }
}