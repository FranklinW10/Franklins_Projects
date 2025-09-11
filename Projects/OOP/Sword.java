public class Sword extends Weapon
{
    /**
     * Constructor 
     * 
     * @param n the name of the axe
     */
    public Sword(String n)
    {
        super(n);
    }

    /**
     * This sword deals damage twice, with each damage amount randomly
     * selected between 0 and 3. The two damage amounts are added together and returned.
     * 
     * @return the amount of damage dealt by the sword
     */
    @Override
    public int damage()
    {
        int firstDamage = DamageGenerator.nextInt(4);
        int secondDamage = DamageGenerator.nextInt(4);
        int totalDamage = firstDamage+secondDamage;
        System.out.println(name+"(Sword) deals "+totalDamage+" damage!");
        return totalDamage;
    }
    
    @Override
    public String toString()
    {
        String weaponInfo = name+"(Sword)";
        return weaponInfo;
    }
}