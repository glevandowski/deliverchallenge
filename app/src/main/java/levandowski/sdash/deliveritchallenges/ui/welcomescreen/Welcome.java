package levandowski.sdash.deliveritchallenges.ui.welcomescreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import levandowski.sdash.deliveritchallenges.R;
import levandowski.sdash.deliveritchallenges.ui.core.MainActivity;
import levandowski.sdash.deliveritchallenges.ui.findwords.FindLetters;
import levandowski.sdash.deliveritchallenges.ui.managesets.CalculateSets;

public class Welcome extends Fragment {

    private Button btnOpenSets,btnOpenWords;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_welcome, container, false);
        this.findViews(view);
        this.onClickActions();
        return  view;
    }
    private void findViews(View view) {
        btnOpenSets = view.findViewById(R.id.btn_calculate_sets);
        btnOpenWords = view.findViewById(R.id.btn_find_words);
    }

    private void onClickActions() {
        btnOpenSets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openFragment(new CalculateSets(), false);
            }
        });

        btnOpenWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openFragment(new FindLetters(), false);
            }
        });
    }
}
