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
public class Calc {
    public static int calculation(int oper1, int oper2, Operations operation)
    {
        switch(operation){
          case ADD:
             return oper1+oper2;
          case SUB:
             return oper1-oper2;
          case MUL:
             return oper1*oper2;
          case DIV:
             return oper1/oper2;
          default:
             return 0;
        }
    }
}
