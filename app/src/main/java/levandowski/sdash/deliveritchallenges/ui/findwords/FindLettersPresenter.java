package levandowski.sdash.deliveritchallenges.ui.findwords;

import levandowski.sdash.deliveritchallenges.business.model.Letters;
import levandowski.sdash.deliveritchallenges.ui.findwords.listener.FindLettersListener;

public class FindLettersPresenter implements FindLettersListener {

    @Override
    public Letters returnLettersRepeated(String value) {
        StringBuilder repeatedValue = new StringBuilder();

        for(int i = 1; i < value.length();i++) {

            char myChar = value.charAt(i);

            if(myChar == value.charAt(i-1))
                repeatedValue.append(myChar);

        }

        Letters letters = null;

        if(!repeatedValue.equals("")) {
            int numberRepeat = repeatedValue.length();
            letters = new Letters(String.valueOf(repeatedValue) , String.valueOf(numberRepeat));
            return letters;
        } else {
            letters = new Letters("N","0");
            return letters;
        }
    }
}
