package levandowski.sdash.deliveritchallenges.ui.findwords;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import levandowski.sdash.deliveritchallenges.R;
import levandowski.sdash.deliveritchallenges.business.model.Letters;

public class ResultWordsDialog  extends Dialog{
        //region Propriedades
        private Button buttonClose;
        private TextView textDialogs;
        private Letters letters;
        //endregion

        //region LifeCycle
        public ResultWordsDialog(@NonNull Context context, Letters letters) {
            super(context);
            this.letters = letters;
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
            textDialogs.setText(letters.toString());
            buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
        //endregion
    }

