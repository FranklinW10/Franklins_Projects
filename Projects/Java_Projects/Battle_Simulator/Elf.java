import java.util.Random;

public class Elf extends Character {
    protected int Nimblenus;
    protected Random NimbleGenorator;
    boolean dA = false; // double attack activation status
    int doubbleAttack = 0; // double attack activation tracker
    /**
     * Constructer
     * 
     * @param n name
     * @param h health
     * @param T initilized Nublenus
     */
    public Elf(String n, int h, int T)
    {
        super(n,h);
        Nimblenus = T;
        NimbleGenorator = new Random();
    }
    /**
     * Checks to see if the elf doged the attack. if the nimbleamount is over 7 the elf dodges the attack and it addes one to double attack
     * if doubble attack equals 2, the elf dodged 2 attacks in a row, it sets da to true. In the battle driver class when this value is true the elf gets an extra attack. 
     * @return
     */
    public boolean findDodge(){
        dA = false;
        int nimbleAmount = NimbleGenorator.nextInt(Nimblenus);
        if(nimbleAmount>7){
            System.out.println("The Elf Dodged the Attack");
            doubbleAttack++;
            if(doubbleAttack==2){
                System.out.println("The Elf gets a Doubble Attack!");
                dA = true;
                doubbleAttack = 0;
            }
            return true;
        }else{
            doubbleAttack = 0;
            return false;
        }
    }
    /** 
     * Deals damage to elf normally
    */
    @Override
    public void dealDamage(int amount)
    {

        if(amount >= 0)
        {
            health -= amount;
            doubbleAttack = 0;
        }
        else
        {
            System.out.println("Sorry, you can't do negative damage!");
            doubbleAttack = 0;
        }
    }

    

    /**
     * retuns boolean value of da
     * @return
     */
    public boolean getdA(){
        return dA;
    }

    @Override
    public String toString()
    {
        String characterInfo = name+" [health:"+health+","+"weapon:"+equippedWeapon+"]";
        return characterInfo;
    }

    
}
