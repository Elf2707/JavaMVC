/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalcUtils;

/**
 *
 * @author Elf
 */
public enum Operations{
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");
    
    
    Operations( String stringValue){
       this.stringValue = stringValue;
    }
    private final String stringValue;

    public String getStringValue() {
        return stringValue;
    }
}
