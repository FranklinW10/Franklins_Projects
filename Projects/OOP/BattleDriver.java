import java.util.InputMismatchException;
import java.util.Scanner;
public class BattleDriver 
{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        System.err.println("You have started your adventure!");
        System.out.println("In this game you will battle 3 different monsters. Good Luck!");
        System.out.println("Press enter to move on to character selection...");
        startGame();

    }
    /**
     * This method stats the same by allowing the user to choose their character or see more information about the characters 
     * It calls the characterSelection method to get input from the user
     * Then calls coresponding character creation method
     */
    public static void startGame(){
        scan.nextLine();
        String Choice = characterSelection();
        try{
        if("B".equals(Choice)){
            String Name = nameSelection();
            Barbarian1(Name);
        }
        else if("W".equals(Choice)){
            String Name = nameSelection();
            Wizard1(Name);
        }
        else if("E".equals(Choice)){
            String Name = nameSelection();
            Elf1(Name);
        }
        else if("I".equals(Choice)){
            CharacterInfo();
            startGame();
        
        }
        else{
            throw new InputMismatchException();
        }
        }
        catch(InputMismatchException e ){
            System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
            System.out.println("Please press enter to continue...");
            startGame();
            
        }



    }
    /**
     * Returns the Users choice of charater
     * @return
     */
    public static String characterSelection(){
        
        System.out.println("Please Select Your Character:");
        System.out.println("Press B for Barbarian");
        System.out.println("Press W for Wizard");
        System.out.println("Press E for Elf");
        System.out.println("Press I for more info about each Character");
        String Choice = scan.nextLine();
        return Choice;
        
    }
    /**
     * Returns the Users character name choice 
     * @return
     */
    public static String nameSelection(){
        
        System.out.println("Please Input the name of your Character:");
        String Choice = scan.nextLine();
        return Choice;
    }
    /** 
     * Prints of info about each character depending on what the user wants to learn about. 
    */
    public static void CharacterInfo(){
        
            System.out.println("Would you like to learn more about the Barbarian, Wizard, or Elf?");
            System.out.println("Press B for Barbarian");
            System.out.println("Press W for Wizard");
            System.out.println("Press E for Elf");
            String Choice2 = scan.nextLine();
            try{
            if("B".equals(Choice2)){
                System.out.println("The barbarian is a tough healthy character. Barbarians have a chance to block some of the incoming damage from the enemy on every blow.");
                System.out.println("Depending on their toughness rating barbarians have a highe chance of blocking more damage.");
                System.out.println("With a perfect block the barbarian becomes raged and heals one health!");
            }
            else if("E".equals(Choice2)){
                System.out.println("Elfs are very nimble and are able to compleatly dodge attcks if they are lucky enough.");
                System.out.println("Depending on the elfs nimblenss rating they will have a higher chance of dodging the attack.");
                System.out.println("With 2 successfull dodges in a row the elf becomes powered up and is able to attack twice in a row!");
            }
            else if("W".equals(Choice2)){
                System.out.println("Wizards are able to create magic and have a change to burn their enemy regardless of the wepon they choose");
                System.out.println("With Higher Magica Wizards have a higher chance of burning enemys");

            }
            else{
                throw new InputMismatchException();
            }
            }
            catch(InputMismatchException e ){
                System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
                System.out.println("Please press enter to continue...");
                scan.nextLine();
                CharacterInfo();
            }
            System.out.println("Would you like to learn about another character?(Y/N)");
            String Choice3 = scan.nextLine();
            
            if("Y".equals(Choice3)){
                CharacterInfo();
            }

    }
    /**
     * Each character in this game has a different choice of weapons. These 3 methods give info on each characters weapons depending on which one they chose.
     * The name of the character is passed through the method to keep track of it because it calls the original Character creation method after the user is done looking at information.
     * @param n
     */
    public static void BarbarianWeaponInfo(String n){
        
        System.out.println("The Barbarian can either use an Axe or a Sword");
        System.out.println("Sword: The Sword is a very reliable wepon that will almost always deal about 4-5 damage");
        System.out.println("Axe: The axe has a higher chance then the sword to deal a lot of damage but also has a higer chance to not deal much damage at all. Can deal between 0-8 damage.");
        System.out.println("Press enter to go back...");
        scan.nextLine();
        
        Barbarian1(n);
    }
    public static void WizardWeaponInfo(String n){
        
        System.out.println("The Wizard can either use Potions of a Wand");
        System.out.println("Potions: The Potions have a random chance of either healing the wizard, dealing damage to the enemey or poisoning the enemy");
        System.out.println("The amount of damage or healing the potion does is based on the Wizard's magica");
        System.out.println("Wand:The wand has a base damage of 3 and then adds a radom amount of damage between 0-3 to it.");
        System.out.println("The Wand also has a special ability Arcane Blast which deals 10 damage to the enemy every 5 turns when it is fully charged!");
        System.out.println("Wand:");
        System.out.println("Press enter to go back...");
        scan.nextLine();
        
        Wizard1(n);

    }
    public static void ElfWeaponInfo(String n){
        
        System.out.println("The Elf can either use a Staff or a Sword");
        System.out.println("Sword: The Sword is a very reliable wepon that will almost always deal about 4-5 damage");
        System.out.println("Staff: The Staff has a base damage between 0-2 but it has the chance to summon the Elf's spirit animal");
        System.out.println("The Elf's spirit animal will stay for 2 turns and deals between 0-12 damage, added on to the Elf's staff damage");
        System.out.println("Press enter to go back...");
        scan.nextLine();
        
        Elf1(n);

    }
    /**
     * Creates the barbarian character using base stats and the name the user input. 
     * It then asks the user which weapon they would like to use and equips the character with that weapon
     * It then calls the battler function passing the Character object and the level 1 to it. 
     * @param n
     */
    public static void Barbarian1(String n){
        String name = n;
        
        System.out.println("You Have Selected Barbarian!");
        Barbarian hero = new Barbarian(n, 39, 5);
        System.out.println("As a Barbarian you have the choice between an Axe and a Sword for your weapon");
        System.out.println("Press A for Axe");
        System.out.println("Press S for Sword");
        System.out.println("Press I for more info about each Weapon");
        String Choice = scan.nextLine();
        try{
        if ("A".equals(Choice)){
            System.out.println("What would you like the name of your weapon to be:");
            String wName = scan.nextLine();
            Axe axe = new Axe(wName);
            hero.equipWeapon(axe);
            System.out.println("You have Selected the Axe");
            
            Battler(hero,1);
        }
        else if("S".equals(Choice)){
            System.out.println("What would you like the name of your weapon to be:");
            String wName = scan.nextLine();
            Sword sword = new Sword(wName);
            hero.equipWeapon(sword);
            System.out.println("You have Selected the Sword");
            
            Battler(hero,1);
        }
        else if("I".equals(Choice)){
            BarbarianWeaponInfo(name);
            
        }
        else{
            throw new InputMismatchException();
        }
        }
        catch(InputMismatchException e ){
            System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
            System.out.println("Please press enter to continue...");
            scan.nextLine();
            Barbarian1(name);
    }


    }
    /**
     * Similar to barbarian but with wizard weapons and wizard base stats. 
     * @param n
     */
    public static void Wizard1(String n){
        String name =n;
        
        System.out.println("You Have Selected Wizard!");
        Wizard hero = new Wizard(n, 40, 8);
        System.out.println("As a Wizard you have the choice between a Wand and Potions for your wepon");
        System.out.println("Press W for Wand");
        System.out.println("Press P for Potions");
        System.out.println("Press I for more info about each Weapon");
        String Choice = scan.nextLine();
        try{
        if ("W".equals(Choice)){
            System.out.println("What would you like the name of your weapon to be:");
            String wName = scan.nextLine();
            Wand wand = new Wand(wName);
            hero.equipWeapon(wand);
            System.out.println("You have Selected the Wand");
            
            Battler(hero,1);
        }
        else if("P".equals(Choice)){
            System.out.println("What would you like the name of your weapon to be:");
            String wName = scan.nextLine();
            Potions potions = new Potions(wName, hero);
            hero.equipWeapon(potions);
            System.out.println("You have Selected the Potions");
            
            Battler(hero, 1);
        }
        else if("I".equals(Choice)){
            
            WizardWeaponInfo(name);
            
        }
        else{
            throw new InputMismatchException();
        }
        }
        catch(InputMismatchException e ){
            System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
            System.out.println("Please press enter to continue...");
            scan.nextLine();
            Wizard1(name);
    }

    }
    /**
     * Similar to barbarian but with elf weapons and base stats.
     * @param n
     */
    public static void Elf1(String n){
        String name = n;
        
        System.out.println("You Have Selected Elf!");
        Elf hero = new Elf(n, 39, 10);
        System.out.println("As an Elf you have the choice between a Staff and a Sword for your weapon");
        System.out.println("Press T for Staff");
        System.out.println("Press S for Sword");
        System.out.println("Press I for more info about each Weapon");
        String Choice = scan.nextLine();
        try{
        if ("T".equals(Choice)){
            System.out.println("What would you like the name of your weapon to be:");
            String wName = scan.nextLine();
            Staff staff = new Staff(wName);
            hero.equipWeapon(staff);
            System.out.println("You have Selected the Staff");
            
            Battler(hero, 1);
        }
        else if("S".equals(Choice)){
            System.out.println("What would you like the name of your weapon to be:");
            String wName = scan.nextLine();
            Sword sword = new Sword(wName);
            hero.equipWeapon(sword);
            System.out.println("You have Selected the Sword");
            
            Battler(hero, 1);
        }
        else if("I".equals(Choice)){
            
            ElfWeaponInfo(name);
        }
        else{
            throw new InputMismatchException();
        }
        }
        catch(InputMismatchException e ){
            System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
            System.out.println("Please press enter to continue...");
            scan.nextLine();
            Elf1(name);
    }
    }

    /**
     * The battler first creates the moster the hero will be figting based on the level. 
     * It then loops through the fighting code until either the monster or hero is below 0 health. 
     * If the moster won it prints out the game is over 
     * If the hero won it calls the upgrades method which will change the level to 2 or 3. 
     * If the level already equals 3 it will say the hero has won and the game is over 
     * @param hero
     * @param n
     */
    public static void Battler(Character hero, int n){
        int level = n;
        Character monster = null; //initializes the value of the Character object
        if(level==1){
            monster = new Character("Gang of bandits",50); // creates monster
            Sword sword =new Sword("Doubble Daggers");
            monster.equipWeapon(sword);
        }
        if(level==2){
            monster = new Character("Evil Knight",60);
            MagicHealingSword sword =new MagicHealingSword("Acid Death",monster);
            monster.equipWeapon(sword);
        }
        if(level==3){
            Barbarian Bmonster = new Barbarian("Ashveil the great",50,6); // creates barbarian monster
            GiantAxe GiantAxe =new GiantAxe("Hero Killer");
            Bmonster.equipWeapon(GiantAxe);
            monster = Bmonster; //sets the barbarian moster equal to monster
        }
        System.out.println("You are ready to Fight");
        System.out.println("Battle!!!!");
        System.out.println(hero+" vs. "+monster);


        
        scan.nextLine();
        while(hero.isAlive() && monster.isAlive())
        {
            if(hero instanceof Wizard){  //Wizard Character has an ability so if the hero is a wizard this code is run
                Wizard wizard = (Wizard) hero;
                int burnAmount = wizard.getBurnAmmount();
                int heroAttack = hero.attack()+burnAmount;//adds burn amount to hero attack
                monster.dealDamage(heroAttack);
                if(hero.getWeapon() instanceof SpecialAbility){ //the only weapon that has a special ability is the wizard so this is why this is in this if statment. If the weapon implements special ability this code will be run
                    int dam = ((SpecialAbility) hero.getWeapon()).useSpecial();
                    monster.dealDamage(dam); //deals the damage to the weapon that is returned by the use special method
                }
            }else{
            int heroAttack = hero.attack();
            monster.dealDamage(heroAttack); //if hero is not a wizard attacks monster as usual
            }
            

            if (hero instanceof Elf) { //Elf Character has an abiliy so if the hero is an elf this code is run
                Elf elf = (Elf) hero;
                if(elf.findDodge() == false){ //checks to see if the elf dodged the attack if it has not it takes damage as usual
                    int monsterAttack = monster.attack();
                    hero.dealDamage(monsterAttack);
                }
                if (elf.getdA()) {  // finds out if elf has extra attack. if it does it deals extra damage to the monster
                    int extraAttack = elf.attack(); 
                    monster.dealDamage(extraAttack-1);
                }
            }else{
            int monsterAttack = monster.attack();
            hero.dealDamage(monsterAttack); //if the hero is not an elf it gets attacked as usual
            }
            System.out.println(hero.getName()+" Has "+hero.getHealth()+" Health Left.");
            System.out.println(monster.getName()+" Has "+monster.getHealth()+" Health Left.");

            System.out.println("Press Enter to continue");
            scan.nextLine();

        }
        
        //at the end of each round(after both fighters have attacked) this code is run to check if each is alive
        //if the hero is dead game is over
        if(!hero.isAlive())
        {
            System.out.println("Our hero "+hero+" fought valiantly but died in battle against "+monster);
            System.out.println("You made it to level " + level);
            System.out.println("Game Over");

            boolean valid = false;
            while(!valid){

            try{
            System.out.println("Would you like to play again?(Y/N)");
            String Choice = scan.nextLine();
            if("Y".equals(Choice)){
                valid =true;
                startGame();
            }
            else if("N".equals(Choice)){
                System.out.println("Thanks For Playing!");
                valid =true;
                
            }
            else{
                throw new InputMismatchException();
            }
            }
            catch(InputMismatchException e ){
                System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
                System.out.println("Please press enter to continue...");
                scan.nextLine();
        }
    }
            

        }
        //if monster is dead either the hero won or they move onto the next level depending on which level it is curently
        if(!monster.isAlive())
        {
            
            System.out.println("The evil "+monster+" was slain by the hero "+hero);
            int newLevel = level+1;
            
            if(level<3){
                System.out.println("");
                System.out.println("You have moved on to level " +newLevel);
                System.out.println("Press enter to continue...");
                scan.nextLine();
                
                if(level==1){
                    
                    Upgrades1(hero); //calls the level one upgrades level if the level is euqal to 1
                }
                if(level==2){
                    
                    Upgrades2(hero);//calls the level two upgrades level if the level is euqal to 2
                }
                

            }
            else{

                System.out.println("Congratulations you have beat the game!");
                
            }
        }


    }
    /**
     * Gives the user the option to upgrade one of 2 stats depending on which character they are using. 
     * Uses hero as a paramater so it can keep the original weapon and name that was given to them. 
     * @param hero
     */
    public static void Upgrades1(Character hero){
        
        String n = hero.getName();
        System.out.println("Before the next battle it's time for some upgrades!");
        //checks to see which type of character the hero is. each one has different upgrade choices
        if(hero instanceof Wizard){
            System.out.println("As a Wizard you can choose to either upgrade your magica or you health.(Note: Each stat can only be upgraded once)");
            System.out.println("Press M to upgrade Magica");
            System.out.println("Press H to upgrade health");
            String choice = scan.nextLine();
            Weapon w= hero.getWeapon();
            try{
            if("H".equals(choice)){
                Wizard hero1 = new Wizard(n, 50, 8); //creates a new Wizard with the original name and upgrades stats
                hero1.equipWeapon(w); //gives the new wizard the original weapon it had
                if(w instanceof NewOwner){
                    ((NewOwner) w).newOwner(hero1);
                }
                System.out.println("Your health will be upgraded to 50 press enter to go back into battle...");
                scan.nextLine();
                
                Battler(hero1,2); //calls battler but this time passing level 2 to it. 

            }
            else if("M".equals(choice)){
                Wizard hero1 = new Wizard(n, 40, 10);
                hero1.equipWeapon(w);
                if(w instanceof NewOwner){
                    ((NewOwner) w).newOwner(hero1);  //give the weapon the owner of the new Wizard that was just created. Otherwise health potions would be healing the wrong char
                }
                System.out.println("Your magica will be upgraded to 10 press enter to go back into battle...");
                scan.nextLine();
             
                Battler(hero1,2);
            }
            else{
                throw new InputMismatchException();
            }
            }
            catch(InputMismatchException e ){
                System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
                System.out.println("Please press enter to continue...");
                scan.nextLine();
                Upgrades1(hero);
        }
        }
        if(hero instanceof Barbarian){
            System.out.println("As a Barbarian  you can choose to either upgrade your Toughness or you upgrade to the magic sword.(Note: Each stat can only be upgraded once)");
            System.out.println("Press T to upgrade Toughness");
            System.out.println("Press M to upgrade to Magic Sword");
            String choice = scan.nextLine();
            Weapon w= hero.getWeapon();
            try{
            if("T".equals(choice)){
                Barbarian hero1 = new Barbarian(n, 39, 7);
                hero1.equipWeapon(w);
                System.out.println("Your toughness will be upgraded to 7 press enter to go back into battle...");
                scan.nextLine();
          
                Battler(hero1,2);
            }
            //the barbarian has the option to upgrade it's weapon instead of its stats. in this case it is given a new magic healing sword which they get to name
            else if("M".equals(choice)){
                System.out.println("What would you like the name of your weapon to be:"); 
                String wName = scan.nextLine();
                MagicHealingSword magicHealingSword = new MagicHealingSword(wName,hero);
                hero.equipWeapon(magicHealingSword);
                System.out.println("You have equipped a new Magic Healing Sword press enter to go back into battle...");
                scan.nextLine();
                
                Battler(hero,2);
            }     
            else{
                throw new InputMismatchException();
            }
            }
            catch(InputMismatchException e ){
                System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
                System.out.println("Please press enter to continue...");
                scan.nextLine();
                Upgrades1(hero);
        }
        }
        if(hero instanceof Elf){
            System.out.println("As an Elf you can choose to either upgrade your nimblness or you health.(Note: Each stat can only be upgraded once)");
            System.out.println("Press N to upgrade nimblness");
            System.out.println("Press H to upgrade health");
            String choice = scan.nextLine();
            Weapon w= hero.getWeapon();
            try{
            if("H".equals(choice)){
                Elf hero1 = new Elf(n, 49, 10);
                hero1.equipWeapon(w);
                System.out.println("Your health will be upgraded to 49 press enter to go back into battle...");
                scan.nextLine();
                
                Battler(hero1,2);
            }
            else if("N".equals(choice)){
                Elf hero1 = new Elf(n, 39, 12);
                hero1.equipWeapon(w);
                System.out.println("Your nimblness will be upgraded to 12 press enter to go back into battle...");
                scan.nextLine();
                
                Battler(hero1,2);
            }
            else{
                throw new InputMismatchException();
            }
            }
            catch(InputMismatchException e ){
                System.out.println("Please enter one of the specified options.(Note: this is case sensitive everything should be capitalized)");
                System.out.println("Please press enter to continue...");
                scan.nextLine();
                Upgrades1(hero);
        }

        }


    }
    /**
     * This is similar to upgrades1 but this happens after level 2 and deosnt give the user options
     * This method simply maxes out the character giving them both of the upgrades they could have had in the upgrades 1 method. 
     * @param hero
     */
    public static void Upgrades2(Character hero){
        
        String n = hero.getName();
        System.out.println("Before the next battle it's time for the final upgrades! Your Character will now become maxed out!");
        Weapon w= hero.getWeapon();
        if(hero instanceof Wizard){
            Wizard hero1 = new Wizard(n, 50, 10); //creates a new wizard with both stats increased
            System.out.println("Your Wizard now has 50 health and 10 magica!");
            hero1.equipWeapon(w);
            if(w instanceof NewOwner){
                ((NewOwner) w).newOwner(hero1);
            }
            System.out.println("Press enter when you are ready to go to the final level!...");
            scan.nextLine();
            
            Battler(hero1,3);
        }
        if(hero instanceof Elf){
            Elf hero1 = new Elf(n, 49, 12);
            System.out.println("Your Elf now has 49 health and 12 nimblness!");
            hero1.equipWeapon(w);
            System.out.println("Press enter when you are ready to go to the final level!...");
            scan.nextLine();
            
            Battler(hero1,3);
        }
        if(hero instanceof Barbarian){
            Barbarian hero1 = new Barbarian(n, 39, 7);
            System.out.println("You get a new Magic Healing Sword!");
            System.out.println("What would you like the name of your Magic Healing Sword to be:");
            String wName = scan.nextLine();
            MagicHealingSword magicHealingSword = new MagicHealingSword(wName,hero);
            System.out.println("Your Barbarian now has 7 toughness and has the magic sword equipped!");
            hero1.equipWeapon(magicHealingSword);
            System.out.println("Press enter when you are ready to go to the final level!...");
            scan.nextLine();
            
            Battler(hero1,3);
        }
        scan.close();
        

    }
    
}