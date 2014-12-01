package merhold.pl.viewpagerscale;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Merhold on 2014-12-01.
 */
public class ScalePageTransformer implements ViewPager.PageTransformer{

    private static final float MIN_SCALE = 0.75f;
    private static final float MIN_ALPHA = 0.5f;
    private ViewPager viewPager;

    public ScalePageTransformer(ViewPager viewPager){
        this.viewPager = viewPager;
    }

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        int width = viewPager.getWidth();
        float pagePos = (pageWidth+viewPager.getPageMargin())/(float)width;
        float offsetPos = position - pagePos;

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(offsetPos));

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
