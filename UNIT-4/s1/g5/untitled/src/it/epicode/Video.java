package it.epicode;

public class Video extends ElementoMultimediale {
private int luminosita;

    public Video(String title, int volume, int duration , int luminosita) {
        super(title, volume, duration);
        this.luminosita=luminosita;
    }



    public void play(){
        for(int i= 0 ; i< this.getDuration(); i++){System.out.println(this.getTitle() + " " + "!".repeat(Math.max(0, this.getVolume())) + " "  + "*".repeat(Math.max(0, this.luminosita)));


        }
    }

    public void alzaVolume(){
        if(getVolume()<10){
            setVolume(getVolume()+1);
        }
    }

    public void abbassaVolume(){
        if(getVolume()>0){
            setVolume(getVolume()-1);
        }
    }

    public void alzaLuminosita(){
        if(this.luminosita<10){
            luminosita=this.luminosita+1;
        }
    }

    public void abbassaLuminosita(){
        if(this.luminosita>0){
            luminosita=this.luminosita-1;
        }
    }



}
