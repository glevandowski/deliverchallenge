package levandowski.sdash.deliveritchallenges.ui.core;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import levandowski.sdash.deliveritchallenges.R;
import levandowski.sdash.deliveritchallenges.ui.about.AboutDialog;
import levandowski.sdash.deliveritchallenges.ui.findwords.FindLetters;
import levandowski.sdash.deliveritchallenges.ui.managesets.CalculateSets;
import levandowski.sdash.deliveritchallenges.ui.welcomescreen.Welcome;

/**
 * @author Gustavo Levandowski
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //region Navigation
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViews();
        setupNavigation();
        openFragment(new Welcome(), true);
    }

    private void findViews() {
        drawer =  findViewById(R.id.drawer_layout);
        toolbar =  findViewById(R.id.toolbar);
        navigationView =  findViewById(R.id.nav_view);
    }

    private void setupNavigation(){
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void openFragment(Fragment calledFragment,  boolean noAddToBackStack) {
        if(noAddToBackStack)
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, calledFragment).commitAllowingStateLoss();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, calledFragment).addToBackStack(calledFragment.getClass().getName()).commitAllowingStateLoss();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                fragment = new Welcome();
                break;
            case R.id.nav_sets:
                fragment = new CalculateSets();
                break;
            case R.id.nav_words:
                fragment = new FindLetters();
                break;
            case R.id.nav_about:
                showDialogAbout();
                break;
            case R.id.nav_exit:
                finish();
                break;
        }
        if(fragment != null)
        openFragment(fragment,false);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void showDialogAbout() {
        AboutDialog customDialog = new AboutDialog(this);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.show();
    }
}
