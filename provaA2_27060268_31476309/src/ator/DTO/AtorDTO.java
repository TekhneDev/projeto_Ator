/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ator.DTO;

/**
 *
 * @author carla && taui
 */
public class AtorDTO {
    private long atorID;
    // string minusculo nao aceita valores nulos, ja o String maiusculo aceita 
    private String atorNome;
    private int atorIdade;

    public long getAtorID() {
        return atorID;
    }

    public void setAtorID(long atorID) {
        this.atorID = atorID;
    }

    public String getAtorNome() {
        return atorNome;
    }

    public void setAtorNome(String atorNome) {
        this.atorNome = atorNome;
    }

    public int getAtorIdade() {
        return atorIdade;
    }

    public void setAtorIdade(int atorIdade) {
        this.atorIdade = atorIdade;
    }
    
    
   
}
