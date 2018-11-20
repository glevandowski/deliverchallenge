package levandowski.sdash.deliveritchallenges.ui.managesets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import levandowski.sdash.deliveritchallenges.R;
import levandowski.sdash.deliveritchallenges.business.model.Sets;

public class ResultSetsDialog  extends Dialog {
    //region Propriedades
    private Button buttonClose;
    private TextView textDialogs;
    private Sets sets;
    //endregion

    //region LifeCycle
    public ResultSetsDialog(@NonNull Context context, Sets sets) {
        super(context);
        this.sets = sets;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_result);
        setCancelable(false);
        this.findViews();
        this.actionEvents();
    }

    //endregion

    //region Referências/Eventos
    private void findViews(){
        buttonClose =  findViewById(R.id.button_close_about_dialog);
        textDialogs = findViewById(R.id.text_result);
    }

    private void actionEvents(){
        textDialogs.setText(sets.toString());
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    //endregion
}


