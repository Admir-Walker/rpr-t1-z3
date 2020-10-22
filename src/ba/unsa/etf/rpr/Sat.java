package ba.unsa.etf.rpr;

public class Sat {
    private int sati, minute, sekunde;

    public Sat(int sati, int minute, int sekunde) {
        Postavi(sati, minute, sekunde);
    }

    public void Postavi(int sati, int minute, int sekunde) {
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }

    public void Sljedeci() {
        this.sekunde = this.sekunde + 1;
        if (this.sekunde == 60) {
            this.sekunde = 0;
            this.minute = this.minute + 1;
        }
        if(this.minute == 60){
            this.minute = 0;
            this.sati = this.sati + 1;
        }
        if(this.sati == 24){
            this.sati = 0;
        }
    }
    public void Prethodni() {
        this.sekunde = this.sekunde - 1;
        if (this.sekunde == -1) {
            this.sekunde = 59;
            this.minute = this.minute - 1;
        }
        if(this.minute == -1){
            this.minute = 59;
            this.sati = this.sati - 1;
        }
        if(this.sati == -1){
            this.sati = 23;
        }
    }
    public void PomjeriZa(int pomak){
        if(pomak > 0){
            for(int i = 0; i < pomak; i++) Sljedeci();
        }
        else for(int i = 0; i < -pomak; i++) Prethodni();
    }

    public final int DajMinute() {
        return minute;
    }

    public final int DajSate(){
        return sati;
    }

    public final int DajSekunde(){
        return sekunde;
    }
    public final void Ispisi(){
        System.out.println(DajSate()+":"+DajMinute()+":"+DajSekunde());
    }

    public static void main(String[] args) {
        Sat s = new Sat(15,30,45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
        s.Postavi(0,0,0);
        s.Ispisi();
    }
}
