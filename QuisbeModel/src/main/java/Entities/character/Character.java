/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.character;

import Entities.model.CCModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chingo
 */
@Entity
@Table(name = "character")
public class Character implements Serializable {
    @Id
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    @Column(name = "name")
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    @OneToMany(mappedBy = "character")
    private List<CCModel> outfits;
    public List<CCModel> getOutfits() { return outfits; }
    public void setOutfits(List<CCModel> outfits) { this.outfits = outfits; }
    
}
