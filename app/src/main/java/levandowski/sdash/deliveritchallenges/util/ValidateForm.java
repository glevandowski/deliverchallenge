package levandowski.sdash.deliveritchallenges.util;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;

/***
 * Classe utilizada para validações de campo
 */
public class ValidateForm {

    private Activity activity;

    public ValidateForm(Activity activity) {
        this.activity = activity;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    // region validate field
    public boolean validateField(TextInputEditText editText, TextInputLayout textInputLayout,String message) {
        String field = editText.getText().toString().trim();
        if (field.isEmpty() || field.length() < 2) {
            textInputLayout.setError(message);
            requestFocus(editText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
    // endregion

    //region  Validate number decimal
    public boolean validateNumberDecimal(TextInputEditText editText, TextInputLayout textInputLayout,String message) {
        String field = editText.getText().toString().trim();
        if (field.isEmpty() || field.length() < 2 || !isNotValidateNumberDecimal(field)) {
            textInputLayout.setError(message);
            requestFocus(editText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private boolean isNotValidateNumberDecimal(String str) {
        String expression = "^[0-9,-]*$";
        return str.matches(expression);
    }
    //endregion

}
