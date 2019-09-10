package com.priactice.algorithm.checkHome;


import java.util.List;

class point{
    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
public class MaxPoint {

    private boolean check(point a,point b){

        boolean x=true,y=true,z=true;
        if(b.getX()==0){
            x=(a.getY()*b.getZ()==a.getZ()*b.getY()?true:false);
        }

        if (b.getY()==0){
            y=(a.getX()*b.getZ()==a.getZ()*b.getX()?true:false);
        }

        if(b.getZ()==0){
            z=(a.getX()*b.getY()==a.getY()*b.getX()?true:false);
        }


        return x&z&y;
    }
    public void findMaxPoint(List<point> pionts){
        point direction[][]=new point[pionts.size()][pionts.size()];
        for (int i=0;i<pionts.size();i++){
            point p=pionts.get(i);
            for (int j=0;j<pionts.size();j++){
              point p2=pionts.get(j);
              double x=p2.getX()-p.getX();
              double y=p2.getY()-p.getY();
              double z=p2.getZ()-p.getZ();
              point point=new point();
              point.setX(x);
              point.setY(y);
              point.setZ(z);
              direction[i][j]=point;
            }
        }

        int max=0;
        for(int i=1;i<pionts.size();i++){
            for(int j=0;j<pionts.size();j++){
                int tmp=0;
                if(j!=i){
                    point p1=direction[i][j];
                    for(int k=0;k<pionts.size();k++){
                        if(i!=k&&k!=j){
                            point p2=direction[i][k];
                            if(p1.getX()==0&&p1.getY()==0&&p1.getZ()==0){
                                tmp=tmp+1;
                            }else {
                                int x=0;
                                int y=0;
                                int z=0;
                                if(p2.getX()*p2.getY()*p2.getZ()==0){
                                    if(check(p1,p2)){tmp=tmp+1;}
                                }else if((p2.getX()/p1.getX()==p2.getY()/p1.getY())&&(p2.getX()/p1.getX()==p2.getZ()/p1.getZ())){
                                    tmp=tmp+1;
                                }
                            }
                        }
                    }
                    max=(max<tmp?tmp:max);
                }
            }
        }

    }

    public  static void main(){


    }
}
