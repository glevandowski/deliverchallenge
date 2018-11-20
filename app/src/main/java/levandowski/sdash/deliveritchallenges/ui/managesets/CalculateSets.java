package levandowski.sdash.deliveritchallenges.ui.managesets;

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
import levandowski.sdash.deliveritchallenges.business.model.Sets;
import levandowski.sdash.deliveritchallenges.ui.managesets.listener.CalculateSetsListener;
import levandowski.sdash.deliveritchallenges.util.ValidateForm;

public class CalculateSets extends Fragment  {

    private TextInputEditText editSets;
    private TextInputLayout layoutSets;
    private Button btnVerify;
    private CalculateSetsListener calculateSetsListener;
    private Activity activity;
    private ValidateForm validateForm;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate_sets, container, false);
        this.findViews(view);
        this.instances();
        btnVerify.setOnClickListener(onClick);
        return view;
    }

    private void findViews(View view) {
        editSets = view.findViewById(R.id.edit_text_sets);
        layoutSets = view.findViewById(R.id.layou_sets);
        btnVerify = view.findViewById(R.id.btn_sets);
    }

    private void instances() {
        calculateSetsListener = new CalculateSetsPresenter();
        activity = getActivity();
        validateForm = new ValidateForm(getActivity());
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateForm.validateNumberDecimal(editSets, layoutSets, getString(R.string.message_field_error))) return;

               showDialog(calculateSetsListener.
                       returnsHighvalue(editSets.getText().toString()));
            }
        };

    private void showDialog(Sets sets) {
        ResultSetsDialog resultSetsDialog = new ResultSetsDialog(activity, sets);
        resultSetsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        resultSetsDialog.show();
    }
}
