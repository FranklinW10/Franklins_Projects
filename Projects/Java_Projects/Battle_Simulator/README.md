# Project 2 – Hero vs. Monsters Battle Simulation

## Overview
This project is a text-based battle simulation game where the user plays as a hero and fights through three levels of monsters. Each hero class has unique abilities, stats, and weapon options. The goal is to defeat all three monsters and win the game.

---

## How It Works
1. **Character Selection**  
   - Choose from: **Elf**, **Wizard**, or **Barbarian**.  
   - Each hero has unique stats, weapons, and a special ability.

2. **Weapon Selection**  
   - Choose a weapon based on the hero selected.  
   - Example: Wizards can select either a wand or potions.

3. **Battle Simulation**  
   - Battles are turn-based.  
   - Each round, both the hero and the monster attack once.  
   - Press **Enter** to move between rounds.  
   - A battle ends when either the hero or monster’s health reaches zero.

4. **Upgrades**  
   - After winning a battle, the hero can upgrade one stat.  
   - After upgrades, the hero proceeds to the next level.  

5. **Game End Conditions**  
   - **Win**: Defeat all three monsters to see a *“Congratulations, you won!”* message.  
   - **Lose**: If defeated, a *“Game Over”* message appears, and you may choose to play again.  

---

## Features
- **500+ lines of code** and **7+ files** (requirement exceeded).  
- **Inheritance-based design** for characters and weapons.  
- **Two interfaces implemented**, laying the foundation for future character expansion.  
- **Robust error handling**: all user input wrapped in `try-catch` blocks.  
- **JUnit testing** for key mechanics (damage, poison duration, abilities).  
- **JavaDoc comments** for all methods.  

---

## Object-Oriented Programming Principles

### Encapsulation
- Related methods and fields grouped into classes.  
- Used for all **character** and **weapon** classes.  
- Potential improvement: split the battle driver further (e.g., a dedicated upgrade handler).  

### Messaging
- Objects communicate by calling methods on each other.  
- Example: damage is calculated by one object and applied to another.  
- Improvement: in upgrades, instead of creating new objects, setter methods (e.g., `setHealth`) could update stats directly.  

### Data Hiding
- Proper use of `private`, `protected`, and `public` access modifiers.  
- Sensitive fields kept hidden to ensure safe access.  

### Inheritance
- All characters inherit from a base **Character** class.  
- All weapons inherit from a base **Weapon** class.  
- Prevents code duplication and improves organization.  

### Polymorphism
- Implemented through method overriding (e.g., `dealDamage`).  
- Allows different attack/damage behaviors for each character.  
- Future improvement: expand polymorphism to reduce reliance on `if` statements.  

---

## Reflection
This project demonstrates all major OOP principles: encapsulation, messaging, data hiding, inheritance, and polymorphism.  

With more time, improvements could include:  
- Breaking the driver into smaller, more specialized classes.  
- More polymorphism to simplify logic.  
- Expanding interfaces to add new heroes/abilities.  

Overall, the project is robust, well-structured, and fulfills all assignment requirements.  

---
