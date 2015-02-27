package software2.appmovil;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.res.TypedArray;


import java.util.List;
import java.util.ArrayList;



import software2.appmovil.adapters.DrawerMenuAdapter;
import software2.appmovil.fragments.DestacadosFragment;
import software2.appmovil.fragments.PusheenFragment;
import software2.appmovil.models.DrawerMenuItem;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mLvDrawerMenu;
    private DrawerMenuAdapter mDrawerMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Agenda Cultural");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mLvDrawerMenu = (ListView) findViewById(R.id.list);

        List<DrawerMenuItem> menuItems = generateDrawerMenuItems();
        mDrawerMenuAdapter = new DrawerMenuAdapter(getApplicationContext(), menuItems);
        mLvDrawerMenu.setAdapter(mDrawerMenuAdapter);

        mLvDrawerMenu.setOnItemClickListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if(savedInstanceState == null){
            setFragment(0, PusheenFragment.class);


        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                setFragment(0, PusheenFragment.class);
                /*setTabsandPager();*/
                mToolbar.setTitle("Home");
                break;
            case 1:
                setFragment(1, DestacadosFragment.class);
                mToolbar.setTitle("Mi Perfil");
                break;
            case 2:
                setFragment(2, DestacadosFragment.class);
                mToolbar.setTitle("Eventos Destacados");
                break;
            case 3:
                mDrawerLayout.closeDrawer(mLvDrawerMenu);
                mLvDrawerMenu.invalidateViews();
                break;
            case 4:
                mDrawerLayout.closeDrawer(mLvDrawerMenu);
                mLvDrawerMenu.invalidateViews();
                break;
            case 5:
                mDrawerLayout.closeDrawer(mLvDrawerMenu);
                mLvDrawerMenu.invalidateViews();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mLvDrawerMenu)) {
            mDrawerLayout.closeDrawer(mLvDrawerMenu);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



  /*  public void setTabsandPager(){

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()));
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

    }*/


    public void setFragment(int position, Class<? extends Fragment> fragmentClass) {
        try {
            Fragment fragment = fragmentClass.newInstance();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment, fragmentClass.getSimpleName());
            fragmentTransaction.commit();

            mLvDrawerMenu.setItemChecked(position, true);
            mDrawerLayout.closeDrawer(mLvDrawerMenu);
            mLvDrawerMenu.invalidateViews();
        }
        catch (Exception ex){
            Log.e("setFragment", ex.getMessage());
        }
    }

    private List<DrawerMenuItem> generateDrawerMenuItems() {
        String[] itemsText = getResources().getStringArray(R.array.drawer_list);
        TypedArray itemsIcon = getResources().obtainTypedArray(R.array.nav_drawer_icons);
        List<DrawerMenuItem> result = new ArrayList<DrawerMenuItem>();
        for (int i = 0; i < itemsText.length; i++) {
            DrawerMenuItem item = new DrawerMenuItem();
            item.setmText(itemsText[i]);
            item.setmIcon(itemsIcon.getResourceId(i, -1));
            result.add(item);
        }
        return result;
    }

}


