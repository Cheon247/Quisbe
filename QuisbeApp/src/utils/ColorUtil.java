/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;



/**
 *
 * @author Chingo
 */
public class ColorUtil {
    private String darkGrey = "-fx-background-color: linear-gradient(#666666, #888888)";
    private String lightGrey = "-fx-background-color: linear-gradient(#AAAAAA, #CCCCCC)";
    
    private String[] colors = {darkGrey, lightGrey};
    private int index = 0;
    public String pickNext(){
        index++;
        if(index < colors.length){
            return colors[index];
        } else {
            index = 0;
            return colors[0];
        }
    }
}
