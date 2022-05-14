import java.util.concurrent.Phaser;

class Singer implements Runnable{

    String[][] lyrics;
    Phaser phaser;
    String name;

    Singer(Phaser p, String n, String[][] lyrics){
        this.phaser = p;
        this.name = n;
        this.lyrics = lyrics;
        phaser.register();
    }
    public void run(){
        for (String[] lyric : lyrics) {
            if (lyric[0].contains(name)) {
                System.out.println(name + ": " + lyric[1]);
            }
            phaser.arriveAndAwaitAdvance();
        }

        phaser.arriveAndDeregister();
    }
}