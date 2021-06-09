/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class fibonacci {
    int num[] = new int[108];
    public fibonacci(){
        num[0] = 1;
        for (int i = 1; i < 108 ; i++){
            num[i] = 0;
        }
    }
    public fibonacci adđ(fibonacci fib1, fibonacci fib2) {
        int cf =  0; // co tran so phep cong sang bit 29
        int del = 0xFFFFFFF; // xoa bit tran thu 29
        fibonacci fib3 = new fibonacci();
        for(int i = 0; i < 108; i++){
            fib3.num[i] = fib1.num[i] + fib2.num[i] + cf;
            if ( (fib3.num[i] >> 28) == 1){
                cf = 1;
                fib3.num[i] = fib3.num[i] & del;
            }
            else    
                cf = 0;
        }
        return fib3;
    }
    public fibonacci assign(fibonacci fib1, fibonacci fib2){
        for (int i = 0; i < 108; i++){
            fib1.num[i] = fib2.num[i];
        }
        return fib1;
    }
    public StringBuilder Fib2String (fibonacci fib){
        StringBuilder sb = new StringBuilder();
        int index = 108;
        for (int i = 107; i >= 0; --i){
            if ( fib.num[i] != 0){
                index = i;
                break;
            }
        }
        for (int i = index; i >= 0 ; --i ){
             sb.append(dec2hex(fib.num[i]));
        }
        return sb;
    }
    public StringBuilder dec2hex (int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 6 ; i >= 0; i ++){
            sb.append(num2hex((num >> (i*4)) & 0x0000000F));
        }
        return sb;
    }
    public String num2hex (int num){
        String str = null;
        switch (num) {
        case 0:
            str = "0";
            break;
        case 1:
            str = "1";
            break;
        case 2:
            str = "2";
            break;
        case 3:
            str = "3";
            break;
        case 4:
            str = "4";
            break;
        case 5:
            str = "5";
            break;
        case 6:
            str = "6";
            break;
        case 7:
            str = "7";
            break;
        case 8:
            str = "8";
            break;
        case 9:
            str = "9";
            break;
        case 10:
            str = "A";
            break;
        case 11:
            str = "B";
            break;
        case 12:
            str = "C";
            break;
        case 13:
            str = "D";
            break;
        case 14:
            str = "E";
            break;
        case 15:
            str = "F";
            break;
        default:
            System.out.println("Not in 0:15");
        }    
        return str;
    }
    
}
