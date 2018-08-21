package style.ru.schoolapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import style.ru.schoolapp.UI.BottomNavigationActivity.AccountActivity;
import style.ru.schoolapp.UI.BottomNavigationActivity.NotificationsActivity;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

        bottomNavigationViewEx.setIconSize(28, 28);
        bottomNavigationViewEx.setIconsMarginTop(18);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navHomework:
                        Intent mainIntent = new Intent(context, MainActivity.class);
                        context.startActivity(mainIntent);
                        break;

                    case R.id.navTimetable:
//                        Intent timetableIntent = new Intent(context, SearchActivity.class);
//                        context.startActivity(timetableIntentIntent);
                        break;

                    case R.id.navNotifications:
                        Intent notificationsIntent = new Intent(context, NotificationsActivity.class);
                        context.startActivity(notificationsIntent);
                        break;

                    case R.id.navAccount:
                        Intent myAccountIntent = new Intent(context, AccountActivity.class);
                        context.startActivity(myAccountIntent);
                        break;
                }
                return false;
            }
        });
    }
}
