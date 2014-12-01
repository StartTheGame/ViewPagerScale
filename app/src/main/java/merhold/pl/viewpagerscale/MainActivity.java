package merhold.pl.viewpagerscale;

import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = width/3;
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width,height);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(20);
        viewPager.setOffscreenPageLimit(9);
        viewPager.setPageTransformer(true, new ScalePageTransformer(viewPager));
        viewPager.setAdapter(new DateAdapter(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
