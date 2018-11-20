package levandowski.sdash.deliveritchallenges.business.model;

/**
 * @author Gustavo Levandowski
 */
public class Sets {

    public String firstPosition;
    public String secondPosition;
    public String highValue;

    public Sets(String firstPosition, String secondPosition, String highValue) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.highValue = highValue;
    }

    @Override
    public String toString() {
        return  ("[" + firstPosition + "," + secondPosition + "]. Máxima dos conjuntos: " + highValue);
    }
}
