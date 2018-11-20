package levandowski.sdash.deliveritchallenges.ui.managesets.listener;

import levandowski.sdash.deliveritchallenges.business.model.Sets;

/*
  Aplicando pattern MVP
 */
public interface CalculateSetsListener {

    Sets returnsHighvalue(String value);
}
