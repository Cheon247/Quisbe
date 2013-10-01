/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Chingo
 */

public abstract class Item {
    @Id
    private Long id;
    public Long getId(){ return this.id; }
    public void setId(Long id){ this.id = id; }
    
    @Column(name = "name")
    private String name;
    public String getName(){ return this.name; }
    public void SetName(String name) { this.name = name; } 
}
