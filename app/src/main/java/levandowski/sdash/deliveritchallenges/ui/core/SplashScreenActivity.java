package levandowski.sdash.deliveritchallenges.ui.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import levandowski.sdash.deliveritchallenges.R;

/***
 * @author Gustavo Levandowski
 */
public class SplashScreenActivity extends Activity {

    //region Propriedades
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
    //endregion
}


