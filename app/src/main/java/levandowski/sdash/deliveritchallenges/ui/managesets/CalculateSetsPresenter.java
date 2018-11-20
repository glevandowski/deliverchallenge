package levandowski.sdash.deliveritchallenges.ui.managesets;

import android.util.Log;
import levandowski.sdash.deliveritchallenges.business.model.Sets;
import levandowski.sdash.deliveritchallenges.ui.managesets.listener.CalculateSetsListener;

public class CalculateSetsPresenter implements CalculateSetsListener {

    /*
    Essa função retorna a primeira posição, ultima posição e a soma maxima do conjunto,
     */
    @Override
    public Sets returnsHighvalue(String value) {
        int highValue = 0;
        int firstPosition = 0;
        int secondPosition = 0;
        int[] set = stringToArrayInteger(value);

        for (int x=0; x < set.length; x++){

            for (int y=x+1; y < set.length; y++) {

                int sum = 0;
                for (int aux=x; aux <= y; aux++) sum += set[aux];

                if (sum > highValue){
                    firstPosition= x;
                    secondPosition = y;
                    highValue = sum;
                }
            }
        }
        return new Sets(String.valueOf(firstPosition),String.valueOf(secondPosition),String.valueOf(highValue));
    }

    /**
     *  função responsável por converter a string em uma cadeira caracteres inteiros.
     */
    private int[] stringToArrayInteger(String value) {
        String[] integerStrings = value.split(",");

        int[] conjunto = new int[integerStrings.length];

        for (int i = 0; i < conjunto.length; i++){
            conjunto[i] = Integer.parseInt(integerStrings[i]);
        }
        return conjunto;
    }
}
