package devcheat.ru.myapplication.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import devcheat.ru.myapplication.Constants;
import devcheat.ru.myapplication.fragments.AbstractFragment;
import devcheat.ru.myapplication.fragments.HistoryFragment;
import devcheat.ru.myapplication.fragments.TaskFragment;
import devcheat.ru.myapplication.fragments.ToDoFragment;

public class TabsFragmenAdapter extends FragmentPagerAdapter {

    private Map <Integer , AbstractFragment> tabs;
    private Context context;

    public TabsFragmenAdapter(FragmentManager fm, Context ct) {
        super(fm);
        this.context = ct;
        InitMap(ct);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void InitMap(Context ct) {
        tabs = new HashMap<>();
        tabs.put(Constants.TAB_ONE, ToDoFragment.getInstance(ct));
        tabs.put(Constants.TAB_TWO, HistoryFragment.getInstance(ct));
        tabs.put(Constants.TAB_THREE, TaskFragment.getInstance(ct));
    }
}
