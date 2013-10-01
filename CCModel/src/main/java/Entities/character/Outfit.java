/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chingo
 */
@Entity
@Table(name = "outfit")
public class Outfit {
    @Id
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    @Column(name = "name")
    private String name;
    public String getName(){ return name; }
    public void setName(String name) { this.name = name; }
    
    @Column(name = "altsgroup")
    private AltOutfitGroup altoutfits;
}
