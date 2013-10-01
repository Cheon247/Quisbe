/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.character;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chingo
 */
@Entity
@Table(name = "altOutfitsGroup")
public class AltOutfitGroup {
    @Id
    private Long id;
    public Long getId() { return id; }
    public void setid(Long id){ this.id = id; }
    
    @Column(name = "outfits")
    private List<Outfit> outfits;
    public List<Outfit> getOutfits(){ return outfits; }
    public void setOutfits(List<Outfit> outfits) { this.outfits = outfits; }
  
}
