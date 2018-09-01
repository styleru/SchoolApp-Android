package style.ru.schoolapp.mvp.UI.BottomNavigationFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import style.ru.schoolapp.R;
import style.ru.schoolapp.mvp.UI.Fragment.MyCoursesFragment;
import style.ru.schoolapp.mvp.UI.SectionsPageAdapter;

public class CoursesFragment extends Fragment {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        sectionsPageAdapter = new SectionsPageAdapter(getFragmentManager());
        viewPager = view.findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    public void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
        adapter.addFragment(new MyCoursesFragment(), "Мои курсы");
        adapter.addFragment(new MyCoursesFragment(), "Все курсы");
         viewPager.setAdapter(adapter);
    }
}