package levandowski.sdash.deliveritchallenges.ui.about;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import levandowski.sdash.deliveritchallenges.R;

/***
 * Criando customDialog
 * @author Gustavo Levandowski
 */
public class AboutDialog extends Dialog {

    //region Propriedades
    private Button buttonClose;
    //endregion

    //region LifeCycle
    public AboutDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_about);
        setCancelable(false);

        this.findViews();
        this.actionEvents();
    }
    //endregion

    //region Referências/Eventos

    private void findViews(){
        buttonClose = findViewById(R.id.button_close_about_dialog);
    }

    private void actionEvents(){
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    //endregion
}