package style.ru.schoolapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

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

//                    case R.id.ic_house:
//                        Intent mainIntent = new Intent(context, MainActivity.class);
//                        context.startActivity(mainIntent);
//                        break;
//
//                    case R.id.ic_search:
//                        Intent searchIntent = new Intent(context, SearchActivity.class);
//                        context.startActivity(searchIntent);
//                        break;
//
//                    case R.id.ic_circle:
//                        Intent shareIntent = new Intent(context, ShareActivity.class);
//                        context.startActivity(shareIntent);
//                        break;
//
//                    case R.id.ic_alert:
//                        Intent likesIntent = new Intent(context, LikesActivity.class);
//                        context.startActivity(likesIntent);
//                        break;
//
//                    case R.id.ic_android:
//                        Intent profileIntent = new Intent(context, ProfileActivity.class);
//                        context.startActivity(profileIntent);
//                        break;
                }

                return false;
            }
        });
    }
}
