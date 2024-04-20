package it.epicode;

public class ElementoMultimediale {
    private String title;
    private int volume;
    private int duration;
    
 
    
    public ElementoMultimediale(String title) {
        this.title = title;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public int getDuration() {
        return duration;
    }

    public ElementoMultimediale(String title, int volume, int duration) {
        this.title = title;
        this.volume= volume;
        this.duration= duration;
    }

    public String getTitle() {
        return this.title;
    }

    public void show() {
    }

    public void play() {
    }
}

