import java.util.Random;
public class Potions extends Weapon implements NewOwner{
    protected Random PotionGenerator;
    protected Wizard owner; // Wizard object that has potions equipped
    public int poisonTurns; // turns left of poison
    public int magica;  // amount of magica
    public int poisonDamage; //amount of poison damage

    /**
     * Constructor
     * 
     * initilizes owner and magica based on the owner's magica .
     * @param n name of axe
     * @param o wizard that has the sword equiped
     */
    public Potions(String n, Wizard o)
    {
        super(n);
        PotionGenerator = new Random();
        this.owner = o;
        magica = this.owner.getMagica();
        poisonDamage = magica/2-2;
    }
    /**
     * gives the potions a new owner. 
     * Needed when new Wizard object is created
     */
    @Override
    public void newOwner(Wizard newOwn){
        this.owner = newOwn;
    }
    /**
     * gets the owner of the potions
     * @return
     */
    public Wizard gerOwner(){
        return owner;
    }
    /**
     * Sets a radom number to potion between 0 and 2. selects on of the Wizards 3 potions based on this random number
     * if it is a damage potion it does damage equal to the wizard's magica plus and poison damage it might have left over
     * if it is a healing potion it heals equal to the wizard's magica 
     * if it is poison it adds 3 turns to the poison counter which does magica/3 damage each turn that the counter is more then 0
     * @return returns the total damage
     */
    @Override
    public int damage(){
        int Potion = PotionGenerator.nextInt(3);
        if(Potion==0){
            System.out.println("The Wizard is using a damage potion!");
            
            if(poisonTurns>0){
                poisonTurns--;
                System.out.println("The Wizard deals "+ magica+" damage with a damage potion");
                System.out.println("The Wizard deals "+poisonDamage+" Damage with poison");
                return magica + poisonDamage;
            }
            System.out.println("The Wizard deals "+ magica+" damage with a damage potion");
            
            return magica;
        }
        if(Potion==1){
            System.out.println("The Wizard is using a healing potion!");
            owner.heal(magica);
            
            if(poisonTurns>0){
                poisonTurns--;
                System.out.println("The Wizard heals "+magica+" health with a healing potion");
                System.out.println("The Wizard deals "+poisonDamage+" Damage with poison");
                return poisonDamage;
            }
            System.out.println("The Wizard heals "+magica+" health with a healing potion");
            return 0;

        }
        if(Potion==2){
            System.out.println("The Wizard is using a poison potion!");
            System.out.println("The Wizard deals "+poisonDamage+" damage with a poison potion!");
            poisonTurns=3;
            poisonTurns--;
            return poisonDamage;
        }
        return 0;
        


    }
    @Override
    public String toString()
    {
        String weaponInfo = name+"(Potions)";
        return weaponInfo;
    }
}
