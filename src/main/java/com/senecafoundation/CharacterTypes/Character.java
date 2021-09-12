package com.senecafoundation.CharacterTypes;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.senecafoundation.DataHandler.IDataHandler;

@MappedSuperclass
public abstract class Character extends BaseStats implements ICharacter 
{
    //Variables
    private String name;
    private int age;
    private String sex;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Transient
    private IDataHandler dataHandler;
    
    //Encapsulation
    public IDataHandler getDataHandler() {
        return dataHandler;
    }
    public String getName()
    {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
  
    //Constructor
    public Character(String name, int age, String sex, IDataHandler dataHandler, int health, int mana, int stamina)
    {
        super(health, mana, stamina);
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.setId(UUID.randomUUID().toString());
        this.dataHandler = dataHandler; 
    }

    //Methods
    public String PlayerDetails() //virtual
    {
        return "Player Name: " + name +  " Player Age: " + age + " Sex: " + sex;
    }

    public String toString() 
    {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getName() + ","  + this.getAge() + "," + this.getSex();
    }  

}