package devcheat.ru.myapplication.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import devcheat.ru.myapplication.R;
import devcheat.ru.myapplication.fragments.ExampleFragment;

public class TabPagerFragmenAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabPagerFragmenAdapter(FragmentManager fm, Context ct) {
        super(fm);
        tabs = new String[]{
                ct.getResources().getString(R.string.TabOneName),
                ct.getResources().getString(R.string.TabTwoName),
                ct.getResources().getString(R.string.TabTreeName)
        };

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExampleFragment.getInstance();
            case 1:
                return ExampleFragment.getInstance();
            case 2:
                return ExampleFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
