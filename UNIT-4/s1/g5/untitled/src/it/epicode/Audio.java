package it.epicode;

public class Audio extends ElementoMultimediale {





    public Audio(String title, int duration, int volume) {
        super(title, volume, duration);




    }

    public void play(){
        for(int i= 0 ; i< this.getDuration(); i++){
            System.out.println(this.getTitle()+ " " + "!".repeat(Math.max(0,this.getVolume())));

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





}


