package devcheat.ru.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devcheat.ru.myapplication.R;

/**
 * Created by cheat on 30.08.2016.
 */
public class TaskFragment extends AbstractFragment {
    private static final int LAYOUT  = R.layout.fragment_example;


    public static TaskFragment getInstance (Context cnt){
        Bundle args = new Bundle();
        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        fragment.setContext(cnt);
        fragment.setTitle(fragment.context.getString(R.string.TabHistory));
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);
        return view;
    }

}
