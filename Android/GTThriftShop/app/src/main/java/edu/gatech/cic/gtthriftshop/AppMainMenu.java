package edu.gatech.cic.gtthriftshop;


import android.os.Bundle;

import edu.gatech.cic.gtthriftshop.appmenu.*;

public class AppMainMenu extends edu.gatech.cic.gtthriftshop.appmenu.MenuListFragment {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MenuListItemAdapter adapter = new MenuListItemAdapter(getActivity().getApplicationContext());

        adapter.add(new MenuListItem(MenuListItemAdapter.HEADER, "Trade"));
		for (MenuListItem item : AppMenuConstants.AppMainMenuTrade) {
			adapter.add(item);
		}

        adapter.add(new MenuListItem(MenuListItemAdapter.HEADER, "Lost & Found"));
        for (MenuListItem item : AppMenuConstants.AppMainMenuLostNFound) {
            adapter.add(item);
        }
		setListAdapter(adapter);
	}

}
