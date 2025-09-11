import java.util.Random;

public class Wizard extends Character {
    protected int Magica; // wizards magic level
    protected Random MagicaGenorator; //random number generater
    public int burnAmount = 0; // amount of damage the wizards burn does
    public boolean burned = false; // wizards burn ability active
    public int a = 0; //just for printing purpouses. this is the burn amount next turn
    /**
     * Constructor 
     * 
     * @param n 
     * @param h health of wizard
     * @param T magica of wizard
     */
    public Wizard(String n, int h, int T)
    {
        super(n,h);
        Magica = T;
        MagicaGenorator = new Random();
    }
    /**
     * initalized value for firecharge 
     * if firecharge is more then the amount of damage that is being done to the wizard the wizard burns the enemy. 
     * the burn amount is set equal to the wizards magica level. 
     * the burn amount is added on to the wizards attack damage. 
     * the burn amount decreaces by 2 each turn.
     */
    @Override
    public void dealDamage(int amount)
    {
        int Firecharge = MagicaGenorator.nextInt(Magica)/2;
        if(Firecharge >amount){
            System.out.println("The Wizard has burrned the enemy!");
            burnAmount = Magica;
            a= burnAmount-2;
            System.out.println("The Wizard will deal "+a+" Extra burn damage to the enemy next turn");
        }
        else if(burnAmount>1){
            a = burnAmount-2;
            System.out.println("The enemy is still burnt. the wizard will deal "+ a + " Extra burn damage to the enemy next turn");
        }
        if(amount >= 0)
        {
            health -= amount;
        }
        else
        {
            System.out.println("Sorry, you can't do negative damage!");
        }
        if(burnAmount>0){
            burnAmount--;//decreaces 2 from burn amount
            burnAmount--;
        }
    }
    /**
     * Gets the burn amount so that it can be refrenced in the battle driver
     * @return
     */
    public int getBurnAmmount(){
        return burnAmount;
    }
    /**
     * Gets the magica amount so that it can be refrenced in the battle driver
     * @return
     */
    public int getMagica(){
        return Magica;
    }

    @Override
    public String toString()
    {
        String characterInfo = name+" [health:"+health+","+"weapon:"+equippedWeapon+"]";
        return characterInfo;
    }

}

