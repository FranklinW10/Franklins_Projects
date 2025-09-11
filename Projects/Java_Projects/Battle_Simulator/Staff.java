import java.util.Random;

public class Staff extends Weapon{
    protected Random StaffGenerator; 
    boolean summond; //determines if spirit animal is summoned or not
    /**
     * Constructor
     * @param n name of staff
     */
    public Staff(String n)
    {
        super(n);
        StaffGenerator = new Random();
        
    }

    int summonTurns = 0;
    /**
     * checks to see if the staff summons the Elf's spirit animal. This happens if the random summon number is 6,7,8.
     * the summond animal stays for 2 turns and does between 0 and 11 damage added on the the staffs 0 and 2 damage. 
     * @return It then returns the total damage. 
     */
    @Override 
    public int damage(){
        if(summonTurns == 0){
            int summon = StaffGenerator.nextInt(9);
            if(summon>5){
                System.out.println("The Elf's Spirit Animal was Summond! It will be here for 2 turns!");
                summond = true;
                summonTurns += 2;
            }
        }
        int Damage = DamageGenerator.nextInt(3);
        if(summond){
            int AnimalDamage = DamageGenerator.nextInt(12);
            summonTurns--;
            if(summonTurns ==0){
                summond = false;
            }

            int totaldamage = Damage + AnimalDamage;
    
            System.out.println(name+"(Staff) deals "+Damage+" damage! The Spirit Animal deals "+AnimalDamage+ " damage! For a total of "+totaldamage+" Damage!" );
            return totaldamage;
        }else{
            System.out.println(name+"(Staff) deals "+Damage+" damage!");
            return Damage;
        }
    }
    /**
     * for unit tests
     * @param n
     */
    public void setSummonTurns(int n){
        this.summonTurns = n;
    }
    /**
     * for unit tests
     * @param n
     */
    public void setSummoned(boolean n){
        this.summond = n;
    }
    /**
     * for unit tests
     * @return
     */
    public int getSummonTurns(){
        return summonTurns;
    }
    @Override
    public String toString()
    {
        String weaponInfo = name+"(Staff)";
        return weaponInfo;
    }
    
}
