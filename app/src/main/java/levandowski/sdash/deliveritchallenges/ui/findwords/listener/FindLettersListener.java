package levandowski.sdash.deliveritchallenges.ui.findwords.listener;

import levandowski.sdash.deliveritchallenges.business.model.Letters;

/*
  Aplicando pattern MVP
 */
public interface FindLettersListener {

    Letters returnLettersRepeated(String value);
}
