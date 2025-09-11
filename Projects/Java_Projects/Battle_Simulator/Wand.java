import java.util.Random;
public class Wand extends Weapon implements SpecialAbility {
    protected Random DamageGenerator; 
    public int SpecialAbilityTurns = 0; //amount of charge the special ability has
    /**
     * Constructor
     * 
     * @param n name of weapon
     */
    public Wand(String n)
    {
        super(n);
        DamageGenerator = new Random();
    }
    /**
     * Does a base 3 damage and adds on a radom number from 0-3
     * @return returns the 2 damages added together
     */
    @Override
    public int damage(){
        int damageBase =3;
        int damageaditional = DamageGenerator.nextInt(4);
        int damageTotal = damageBase+damageaditional;
        System.out.println("The Wizard deals "+damageTotal+" damage with it's wand!");
        return damageTotal;
    }
    /**
     * uses the implemented useSpecial() interfece. when it is called it adds one to the special ability turns, then if the special ability turns is equal to 5 it trigers the special ability
     * the special ability deals a one time 10 damage to the enemy, then the SpecialAbilityTurns is reset. 
     */
    @Override
    public int useSpecial(){
        SpecialAbilityTurns++;
        if(SpecialAbilityTurns >4){
            System.out.println("Wizard Uses its special ability arcane blast!");
            SpecialAbilityTurns = 0;
            int SpecialAbilityDamage = 10;
            System.out.println("Wizard Deals "+SpecialAbilityDamage+ " with it's special ability");
            return SpecialAbilityDamage;
            
        }
        else{
            System.out.println("Wizard is still charging arcane blast.");
            return 0;
        }
        
    }
    /**
     * for unit tests
     * @param n
     */
    public void setSpecialTurns(int n){
        this.SpecialAbilityTurns = n;
    }

    @Override
    public String toString()
    {
        String weaponInfo = name+"(Wand)";
        return weaponInfo;
    }
}
    

