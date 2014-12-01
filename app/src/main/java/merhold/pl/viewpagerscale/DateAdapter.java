package merhold.pl.viewpagerscale;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Merhold on 2014-12-01.
 */
public class DateAdapter extends PagerAdapter{

    private Context context;

    public DateAdapter(Context context){
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View page= ((FragmentActivity)context).getLayoutInflater().inflate(R.layout.page, container, false);


        page.setBackgroundColor(Color.rgb(17, 143, 206));

        container.addView(page);

        return(page);
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return(20);
    }

    @Override
    public float getPageWidth(int position) {
        return(1.0f/3.0f);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return(view == object);
    }
}
