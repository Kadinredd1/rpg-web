package com.senecafoundation.CharacterTypes;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.senecafoundation.DataHandler.IDataHandler;

@Entity
@Table(name = "character")
public class ShadowElf extends Character 
{
    //Variables
    private int destructionBonus;
    private int alterationBonus;

    //Encapsulation
    public int getDestructionBonus()
    {
        return this.destructionBonus;
    }
    public void setDestructionBonus(int newDestructionBonus)
    {
        this.destructionBonus = newDestructionBonus;
    }

    public int getAlterationBonus()
    {
        return this.alterationBonus;
    }
    public void setAlterationBonus(int newAlterationBonus)
    {
        this.alterationBonus = newAlterationBonus;
    }

    //Constructor
    public ShadowElf(String name, int age, String sex, int destruction, int alteration, IDataHandler dataHandler)
    {
        super(name, age, sex, dataHandler, 30, 80, 80);
        this.destructionBonus = destruction;
        this.alterationBonus = alteration;
    }

    //Method
    public String PlayerDetails() //override
    {
        return  (this.getName() + " Destruction: " + destructionBonus + " Alteration: " + alterationBonus);
    }

    public String toString() 
    {
        return super.toString() + "," + this.getDestructionBonus() + "," + this.getAlterationBonus();
    }
}