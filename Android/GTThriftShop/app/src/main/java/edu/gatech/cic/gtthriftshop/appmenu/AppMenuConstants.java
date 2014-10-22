package edu.gatech.cic.gtthriftshop.appmenu;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cic.gtthriftshop.R;

/**
 * Created by anandsainath on 10/22/14.
 */
public class AppMenuConstants {
    public static enum Menu {
        // Main Menu items..
        BUY("Buy", "buy"), SELL("Sell/My Store", "sell"), LOST("Lost Something?", "lost"),
            FOUND("Found Something?","found");
        public String tag, value;

        private Menu(String tag, String value) {
            this.tag = tag;
            this.value = value;
        }
    };

    public static List<MenuListItem> AppMainMenuTrade, AppMainMenuLostNFound;

    static{
        AppMainMenuTrade = new ArrayList<MenuListItem>(2);
        AppMainMenuLostNFound = new ArrayList<MenuListItem>(2);

        AppMainMenuTrade.add(new MenuListItem(R.drawable.ic_action_basket, Menu.BUY.tag, Menu.BUY.value, false, MenuListItem.MenuName.APP_MENU.getValue()));
        AppMainMenuTrade.add(new MenuListItem(R.drawable.ic_action_basket, Menu.SELL.tag, Menu.SELL.value, false, MenuListItem.MenuName.APP_MENU.getValue()));

        AppMainMenuLostNFound.add(new MenuListItem(R.drawable.ic_action_basket, Menu.LOST.tag, Menu.LOST.value, false, MenuListItem.MenuName.APP_MENU.getValue()));
        AppMainMenuLostNFound.add(new MenuListItem(R.drawable.ic_action_basket, Menu.FOUND.tag, Menu.FOUND.value, false, MenuListItem.MenuName.APP_MENU.getValue()));
    }
}
