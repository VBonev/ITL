package com.league.interactive.itl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.Tournament;
import com.league.interactive.itl.screens.messages.MessagesFragment;
import com.league.interactive.itl.screens.tournaments.TournamentsFragment;
import com.league.interactive.itl.screens.tournaments.details.TournamentDetailsActivity;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        OnListItemInteractionListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tournaments");
        setSupportActionBar(toolbar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            changeFragment(TournamentsFragment.newInstance());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_Home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_head_to_head:
                    return true;
                case R.id.navigation_messages:
                    changeFragment(MessagesFragment.newInstance());
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }

            return false;
        }

    };

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_Home) {
            fragment = TournamentsFragment.newInstance();
            toolbar.setTitle("Home");
        } else if (id == R.id.nav_tournaments) {
            toolbar.setTitle("Tournaments");
        } else if (id == R.id.nav_ranking) {
            toolbar.setTitle("Ranking");
        } else if (id == R.id.nav_challenges) {
            toolbar.setTitle("Free Games");
        } else if (id == R.id.nav_my_profile) {
            toolbar.setTitle("News");
        } else if (id == R.id.nav_messages) {
            toolbar.setTitle("Home");
        }

        changeFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    @Override
    public void onListFragmentInteraction(Object object) {
        Intent tournamentIntent = new Intent(this, TournamentDetailsActivity.class);
        tournamentIntent.putExtra(Tournament.TOURNAMENT_NAME, ((Tournament) object).name);
        startActivity(tournamentIntent);
    }
}
