package com.example.asasfans.ui.main.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.asasfans.ui.main.fragment.ImageFanArtFragment;
import com.example.asasfans.ui.main.fragment.MainFragment;
import com.example.asasfans.ui.main.fragment.NewToolsFragment;
import com.example.asasfans.ui.main.fragment.NullFragment;
import com.example.asasfans.ui.main.fragment.WebFragment;

/**
 * @author akarinini
 * @description:
 * @date :2022/4/10 12:16
 */
public class NewBottomPagerAdapter extends FragmentStatePagerAdapter {
    private static final String[] TAB_TITLES = new String[]{"视频", "图片", "音乐", "工具"};
    private static Object currentFragment;
    public NewBottomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return MainFragment.newInstance();
            case 1:
                return ImageFanArtFragment.newInstance();
            case 2:
                return WebFragment.newInstance("https://zjsongs.netlify.app", true);
            case 3:
                return NewToolsFragment.newInstance();
            default:
                return NullFragment.newInstance();
        }
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }

    /**
     * @description 获取当前视点Fragment的object
     * @param
     * @return
     * @author akari
     * @time 2022/2/27 11:00
     */
    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        currentFragment = object;
        super.setPrimaryItem(container, position, object);
    }

    /**
     * @description 获取当前视点的Fragment
     * @param
     * @return
     * @author akari
     * @time 2022/2/27 10:07
     */
    public static Object getCurrentFragment() {
        return currentFragment;
    }
}
