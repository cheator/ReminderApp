package devcheat.ru.myapplication.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by cheat on 30.08.2016.
 */
public abstract class AbstractFragment extends Fragment {
    protected Context context ;
    protected View view;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setContext(Context context) {
        this.context = context;
    }
}
