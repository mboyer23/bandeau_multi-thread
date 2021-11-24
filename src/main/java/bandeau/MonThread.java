package bandeau;

import java.util.List;

public class MonThread extends Thread{
    private Bandeau bandeau;
    private List<ScenarioElement> Elements;

    public MonThread(Bandeau bandeau, List<ScenarioElement> Elements) {
        this.bandeau = bandeau;
        this.Elements = Elements;
    }

    @Override
    public void run() {
        synchronized(bandeau){
            for (ScenarioElement element : Elements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(bandeau);
                }
            }
        }
    }
}