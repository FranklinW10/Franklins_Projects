public class Character 
{
    protected String name; //The character's name
    protected int health;  //the amount of health the character has
    protected Weapon equippedWeapon; //the weapon the character is using
    protected boolean dodge;




    /**
     * Constructorf
     * 
     * A new character will be created with a default "Fists" weapon
     * 
     * @param n the character's name
     * @param h an integer, the character's starting health
     */
    public Character(String n, int h)
    {
        name = n;
        health = h;
        equippedWeapon = new Weapon("Fists");
    }

    public String getName(){
        return name;
    }

    /**
     * A method for determining if the character is alive; that is, if its
     * health is above 0
     * 
     * @return a boolean, whether the character has an health left or not
     */
    public boolean isAlive()
    {
        return health > 0;
    }
    public Weapon getWeapon(){
        return equippedWeapon;
    }

    /**
     * This method should be called to deal damage to this character's health
     * 
     * @param amount an integer amount of damage to subtract from the character's health
     */
    public void dealDamage(int amount)
    {
        if(amount >= 0)
        {
            health -= amount;
        }
        else
        {
            System.out.println("Sorry, you can't do negative damage!");
        }
    }

    /**
     * This method should be called to heal (add onto) the character's health
     * 
     * @param healAmount an integer amount of damage to add from the character's health
     */
    public void heal(int healAmount)
    {
        if(healAmount >= 0)
        {
            health += healAmount;
        }
        else
        {
            System.out.println("Sorry, you can't heal a negative amount!");
        }
    }

    /**
     * Set the weapon being used by the character
     * 
     * @param w the weapon to equip for the character
     */
    public void equipWeapon(Weapon w)
    {
        equippedWeapon = w;
    }


    public int getHealth(){
        return health;
    }


    /**
     * Determine the amount of damage this character will deal to the opponent
     * when attacking
     * 
     * @return an integer, the amount of damage to deal to the opponent
     */
    public int attack()
    {
        return equippedWeapon.damage();
    }

    public String toString()
    {
        String characterInfo = name+" [health:"+health+","+"weapon:"+equippedWeapon+"]";
        return characterInfo;
    }
}