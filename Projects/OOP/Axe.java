public class Axe extends Weapon
{
    /**
     * Constructor 
     * 
     * @param n the name of the axe
     */
    public Axe(String n) 
    {
        super(n);
    }

    /**
     * This axe deals damage between 0 and 7, determined randomly
     * 
     * @return the amount of damage dealt by the axe
     */
    @Override
    public int damage()
    {
        int damageAmount = DamageGenerator.nextInt(8);
        System.out.println(name+"(Axe) deals "+damageAmount+" damage!");
        return damageAmount;
    }

    @Override
    public String toString()
    {
        String weaponInfo = name+"(Axe)";
        return weaponInfo;
    }
}