/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TranPhuong
 */
public class DIEM {
    int x,y;
    public DIEM()
    {
        x=0;
        y=0;
    }
    public void DIEM(int a,int b)
    {
        x = a;
        y = b;
    }
    
    public double khoangCach(DIEM d)
    {
        return Math.sqrt((d.x-this.x)*(d.x-this.x)+(d.y-this.y)*(d.y-this.y));
    }
    
}
