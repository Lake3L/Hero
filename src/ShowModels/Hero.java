package ShowModels;

import com.company.Const;

import java.awt.*;

public class Hero extends Model{

    public Hero(int x, int y) {
        super(x,y,"Images\\superman.png");
    }
    public void stepX(int x){
        x += this.getX();
        if(x >= Const.W)
            this.setX(0);
        if(x<0)
            this.setX(Const.W - Const.STEP);
    }

    public void stepY(int y){
        y += this.getY();
        if(y >= Const.H)
            this.stepY(0);
        if(y<0)
            this.setY(Const.H - Const.STEP);
    }
}