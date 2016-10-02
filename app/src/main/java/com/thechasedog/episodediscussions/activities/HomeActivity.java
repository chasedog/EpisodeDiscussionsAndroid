package com.thechasedog.episodediscussions.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.thechasedog.episodediscussions.R;
import com.thechasedog.episodediscussions.Util.Device;
import com.thechasedog.episodediscussions.models.Episode;
import com.thechasedog.episodediscussions.models.Season;
import com.thechasedog.episodediscussions.models.Subreddit;
import com.thechasedog.episodediscussions.services.DiscussionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AsyncResponse<Subreddit>, SubredditChooseFragment.NoticeDialogListener, EpisodeFragment.OnListFragmentInteractionListener<Episode> {
    EpisodeFragment episodeFragment;
    private final List<Episode> mEpisodes = new ArrayList<>();
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSubredditChooser();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mMenu = navigationView.getMenu();
        mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, "Southpark");
        mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, "Shameless");
        mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, "BrooklynNineNine");
        mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, "IASIP");
        mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, "HTGAWM");
        mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, "lastmanonearthtv");
        navigationView.setNavigationItemSelectedListener(this);

        if (findViewById(R.id.fragment_container) != null) {
            episodeFragment = new EpisodeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, episodeFragment).commit();
        }
    }

    private void GetDataForSubreddit(String subreddit) {
        new MyAsyncTask<String, Void, Subreddit>(this) {
            @Override
            protected Subreddit doInBackground(String... params) {
                Subreddit subreddit = null;

                try {
                    subreddit = DiscussionService.getSubreddit(params[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return subreddit;
            }
        }.execute(subreddit);
    }

    public void showSubredditChooser() {
        new SubredditChooseFragment().show(getSupportFragmentManager(), "subreddit");
    }

    @Override
    public void processFinish(Subreddit result) {
        mEpisodes.clear();
        for (Season season : result.seasons) {
            for (Episode episode : season.Episodes) {
//                Log.d("HomeActivity.Episode", episode.getTitle() + ", " + episode.URL);
                mEpisodes.add(episode);
            }
        }
        episodeFragment.refreshData();
        setTitle("/r/" + result.getName());
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
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String subreddit = item.getTitle().toString();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        GetDataForSubreddit(subreddit);

        return true;
    }

    @Override
    public void onDialogPositiveClick(SubredditChooserResponse response) {
        GetDataForSubreddit(response.subreddit);

        if (response.saveToDrawer) {
            mMenu.add(R.id.subreddits, Menu.FLAG_APPEND_TO_GROUP, Menu.NONE, response.subreddit);
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

    @Override
    public void onClick(Episode item) {
        Intent intent = getIntentForURL(item.getURL());
        startActivity(intent);
    }

    @Override
    public List<Episode> getData() {
        return mEpisodes;
    }

    private Intent getIntentForURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        addFlagsForMultiWindowDevices(intent);
        return intent;
    }

    private void addFlagsForMultiWindowDevices(Intent intent) {
        if (Device.hasNougatOrGreater()) {
            intent.addFlags(getFlagsIfInMultiwindow());
        }
    }

    @TargetApi(24)
    private int getFlagsIfInMultiwindow() {
        if (isInMultiWindowMode()) {
            return FLAG_ACTIVITY_LAUNCH_ADJACENT | FLAG_ACTIVITY_NEW_TASK;
        }
        return 0;
    }
}
