package levandowski.sdash.deliveritchallenges.ui.findwords;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import levandowski.sdash.deliveritchallenges.R;
import levandowski.sdash.deliveritchallenges.business.model.Letters;
import levandowski.sdash.deliveritchallenges.ui.findwords.listener.FindLettersListener;
import levandowski.sdash.deliveritchallenges.util.ValidateForm;

public class FindLetters extends Fragment {

    private TextInputEditText editWords;
    private TextInputLayout layoutWords;
    private Button btnVerify;
    private FindLettersListener findLettersListener;
    private Activity activity;
    private ValidateForm validateForm;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_letters, container, false);
        this.findViews(view);
        this.instance();
        btnVerify.setOnClickListener(onClick);
        return view;
    }

    private void findViews(View view) {
        editWords = view.findViewById(R.id.edit_text_words);
        layoutWords = view.findViewById(R.id.layou_words);
        btnVerify = view.findViewById(R.id.btn_words);
    }

    private void instance() {
        findLettersListener = new FindLettersPresenter();
        activity = getActivity();
        validateForm = new ValidateForm(getActivity());
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!validateForm.validateField(editWords,layoutWords,getString(R.string.message_field_error))) return;

            showDialog(findLettersListener.
                    returnLettersRepeated(editWords.getText().toString()));

        }
    };

    private void showDialog(Letters letters) {
        ResultWordsDialog resultWordsDialog = new ResultWordsDialog(activity,letters);
        resultWordsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        resultWordsDialog.show();
    }
}
