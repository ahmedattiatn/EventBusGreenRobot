package ahmedattia.myeventbusproject.pager_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ahmedattia.myeventbusproject.fragment.FirstFragment;
import ahmedattia.myeventbusproject.fragment.SecondFragment;

/**
 * Created by Ahmed Attia on 29/05/2017.
 */

public class MYPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MYPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FirstFragment tab1 = new FirstFragment();
                return tab1;
            case 1:
                SecondFragment tab2 = new SecondFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}