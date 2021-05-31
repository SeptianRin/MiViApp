package io.github.septianrin.miviapp.ui.home;


import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import io.github.septianrin.miviapp.R;
import io.github.septianrin.miviapp.model.MovieModel;
import io.github.septianrin.miviapp.model.TVShowModel;
import io.github.septianrin.miviapp.utils.DataDummy;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {

    private final ArrayList<MovieModel> movieModels= (ArrayList<MovieModel>) DataDummy.generateDummyMovies();
    private final ArrayList<TVShowModel> tvShowModels = (ArrayList<TVShowModel>) DataDummy.generateDummyTVShow();

    @Rule
    public ActivityScenarioRule activityScenarioRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void loadMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(movieModels.size()));
    }

    @Test
    public void loadTVShow(){
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition(tvShowModels.size()));
    }

    @Test
    public void loadDetailMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.text_title)).check(matches(withText(movieModels.get(0).getTitle())));
        onView(withId(R.id.text_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating)).check(matches(withText(movieModels.get(0).getRating()+"/10")));
        onView(withId(R.id.text_dura)).check(matches(isDisplayed()));
        onView(withId(R.id.text_dura)).check(matches(withText("Duration")));
        onView(withId(R.id.text_duration)).check(matches(withText(movieModels.get(0).getDuration())));
        onView(withId(R.id.text_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(movieModels.get(0).getSinopsis())));
    }

    @Test
    public void loadDetailTVShow(){
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.text_title)).check(matches(withText(tvShowModels.get(0).getTitle())));
        onView(withId(R.id.text_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating)).check(matches(withText(tvShowModels.get(0).getRating()+"/10")));
        onView(withId(R.id.text_dura)).check(matches(isDisplayed()));
        onView(withId(R.id.text_dura)).check(matches(withText("Episode")));
        onView(withId(R.id.text_duration)).check(matches(withText(tvShowModels.get(0).getEpisode())));
        onView(withId(R.id.text_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(tvShowModels.get(0).getSinopsis())));
    }



}