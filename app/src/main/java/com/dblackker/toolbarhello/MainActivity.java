package com.dblackker.toolbarhello;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.dblackker.toolbarhello.FakeData.HARRY_POTTER;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) protected DrawerLayout drawer;
    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.nav_view) protected NavigationView navigationView;

    protected ImageView profile;
    protected TextView name;
    protected TextView email;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0); // 0-index header
        profile = (ImageView) headerLayout.findViewById(R.id.profileImageView);
        name = (TextView) headerLayout.findViewById(R.id.nameTextView);
        email = (TextView) headerLayout.findViewById(R.id.emailTextView);

        bind(HARRY_POTTER);
    }

    private void bind(User user) {
        Picasso.with(this)
                .load(user.getProfileImageUrl())
                .centerCrop()
                .fit()
                .error(R.drawable.ic_menu_camera);
        name.setText(user.getName());
        email.setText(user.getEmail());
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

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.home) {
            drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        String fragmentTag;

        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_camera:
                fragment = ImportFragment.newInstance();
                fragmentTag = ImportFragment.FRAGMENT_TAG;
                break;
            case R.id.nav_slideshow:
                fragment = SlideshowFragment.newInstance();
                fragmentTag = SlideshowFragment.FRAGMENT_TAG;
                break;
            case R.id.nav_manage:
                fragment = ToolsFragment.newInstance();
                fragmentTag = ToolsFragment.FRAGMENT_TAG;
                break;
            default:
                fragment = GalleryFragment.newInstance();
                fragmentTag = GalleryFragment.FRAGMENT_TAG;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(fragmentTag);
        transaction.replace(R.id.main_content, fragment, fragmentTag);
        transaction.commit();

        item.setChecked(true);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
