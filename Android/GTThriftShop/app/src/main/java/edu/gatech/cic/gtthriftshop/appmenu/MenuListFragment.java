package edu.gatech.cic.gtthriftshop.appmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;

import edu.gatech.cic.gtthriftshop.R;

/**
 * Created by anandsainath on 10/21/14.
 */
public class MenuListFragment extends SherlockListFragment implements AdapterView.OnItemClickListener{

    private Callbacks mCallbacks = _this;
    protected int mSelectedPosition = 1;

    public MenuListFragment() {
        setRetainInstance(true);
    }

    public interface Callbacks {
        public void menuClick(String value, String tag);

        public void subMenuClick(String value, String tag);
    }

    private static Callbacks _this = new Callbacks() {
        public void menuClick(String value, String tag) {
        }

        public void subMenuClick(String value, String tag) {

        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = _this;
    }

    protected void onItemClicked(MenuListItem item) {
        if (item.menuType == MenuListItem.MenuName.APP_MENU.getValue()) {
            mCallbacks.menuClick(item.value, item.tag);
        } else {
            mCallbacks.subMenuClick(item.value, item.tag);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView lView = getListView();
        if (lView != null) {
            lView.setOnItemClickListener(this);
            lView.setDivider(null);
            lView.setDividerHeight(0);
            lView.setBackgroundResource(R.color.swatch_10);
            lView.setCacheColorHint(Color.TRANSPARENT);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
