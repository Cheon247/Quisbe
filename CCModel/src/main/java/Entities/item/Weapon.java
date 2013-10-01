/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chingo
 */
public abstract class Weapon extends Item{
    @Id
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    @Column(name = "WeaponDamage")
    private Double weaponDamage;
    public Double getWeaponDamage(){ return this.weaponDamage; }
    public void setWeaponDamage(Double wd){ this.weaponDamage = wd; }
    
    @Column(name = "AttackSpeed")
    private Double attackSpeed;
    public Double getAttackSpeed() { return attackSpeed; }
    public void setAttackSpeed(Double atsp){this.attackSpeed = atsp;
    }
    
    
    
    
}
