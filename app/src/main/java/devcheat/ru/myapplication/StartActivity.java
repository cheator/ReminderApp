package devcheat.ru.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import devcheat.ru.myapplication.adapter.TabPagerFragmenAdapter;

public class StartActivity extends AppCompatActivity {
    private static final int MAINLAYOT = R.layout.activity_start;
    private NavigationView nv;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager ;
    private ActionBarDrawerToggle toggle;
    private FloatingActionButton flBtn;
    private CoordinatorLayout cor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(MAINLAYOT);


        intiFloatingBtn();
        intiToolBar();
        intinavigationView();

        initTabs();
    }

    private void intiFloatingBtn() {
        cor = (CoordinatorLayout) findViewById(R.id.CoordinatorID);
        flBtn = (FloatingActionButton) findViewById(R.id.floatingBtn);
        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(cor ,"Hi!",Snackbar.LENGTH_SHORT ).show();
            }
        });

    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        TabPagerFragmenAdapter adapter = new TabPagerFragmenAdapter(getSupportFragmentManager() , this);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void intiToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.toolbar_menu);
    }

    private void intinavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
          toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        nv =(NavigationView) findViewById(R.id.navigation);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch(item.getItemId()){
                    case R.id.menu_notification:
                        setNitificationTab();
                        break;

                }
                return false;
            }
        });


    }
    private void setNitificationTab() {
        viewPager.setCurrentItem(Constants.TAB_TWO);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
}
