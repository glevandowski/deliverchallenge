package levandowski.sdash.deliveritchallenges.business.model;

/**
 * @author Gustavo Levandowski
 */
public class Letters {

    private String charLetter;
    private String numberRepeat;

    public Letters(String charLetter, String numberRepeat) {
        this.charLetter = charLetter;
        this.numberRepeat = numberRepeat;
    }

    @Override
    public String toString() {
        if(charLetter.isEmpty()){
            return  "Repete: "+ numberRepeat +" vezes";
        } else {
            return "A letra: " + charLetter + " repete: " + numberRepeat + " vez";
        }
    }
}
