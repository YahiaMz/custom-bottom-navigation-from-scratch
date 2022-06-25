package com.aplication.custom_bottom_nav.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aplication.custom_bottom_nav.R;
import com.aplication.custom_bottom_nav.views.Fragments.Home_Fragment;
import com.aplication.custom_bottom_nav.views.Fragments.Fragment2;
import com.aplication.custom_bottom_nav.views.Fragments.Fragment3;
import com.aplication.custom_bottom_nav.views.Fragments.Fragment4;
import com.aplication.custom_bottom_nav.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
int selected_item = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

             LinearLayout bnv =  binding.bottomNVLayout;

                     LinearLayout items []  = {binding.item1 , binding.item2 , binding.item3 , binding.item4};
                     int icons [][] = {{R.drawable.ic_home , R.drawable.ic_home_selected , R.drawable.item1bg} , {R.drawable.ic_search_190 , R.drawable.ic_search_190_selected , R.drawable.item2bg}
                     ,{R.drawable.ic_heart , R.drawable.ic_heart_enabled , R.drawable.item3bg} , {R.drawable.ic_user , R.drawable.ic_user_selected , R.drawable.item4bg}
                     };
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout , new Home_Fragment(getApplicationContext())).commit();

        for (int x = 0 ; x < bnv.getChildCount() ; x ++  ) {

                         if (selected_item == x ) bnv.getChildAt(selected_item).setBackgroundResource(R.drawable.item1bg);
                         LinearLayout item = (LinearLayout) bnv.getChildAt(x);

                         int finalX = x;
                         item.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 selected_item = finalX;


                                 for (int x = 0 ; x < bnv.getChildCount() ; x ++  ) {
                                     bnv.getChildAt(x).setBackground(null);
                                     ((LinearLayout)bnv.getChildAt(x)).getChildAt(1).setVisibility(View.GONE);
                                     ((ImageView)items[x].getChildAt(0)).setImageResource(icons[x][0]);

                                     LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                                     param.weight = 1;
                                     ((LinearLayout)bnv.getChildAt(x)).setLayoutParams(param);


                                 }

                                 items[finalX].setBackgroundResource(R.drawable.item1bg);
                                 items[finalX].getChildAt(1).setVisibility(View.VISIBLE);
                                 bnv.getChildAt(selected_item).setBackgroundResource(icons[selected_item][2]);
                                 ((ImageView)items[finalX].getChildAt(0)).setImageResource(icons[finalX][1]);
                                 LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                                 param.weight = 2;
                                 ((LinearLayout)bnv.getChildAt(selected_item)).setLayoutParams(param);


                                 ScaleAnimation animation = new ScaleAnimation(.6f ,1f , 1f, 1f  );
                                 animation.setDuration(200);
                                 animation.setFillAfter(true);
                                 ((LinearLayout)bnv.getChildAt(selected_item)).startAnimation(animation);
                                 getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout , FactoryMethod(selected_item)).commit();

                             }
                         });

             }

    }

    public Fragment FactoryMethod (int x) {
        Fragment selectedF = null;
        switch ( x ) {
            case 0 :
                selectedF = new Home_Fragment(getApplicationContext());
                break;
            case 1 :
                selectedF = new Fragment2(getApplicationContext());
            break;
            case 2 :
                selectedF = new Fragment3(getApplicationContext());
            break;
            case 3:
                selectedF = new Fragment4(getApplicationContext());
            break;

        }
        return  selectedF;

    }


}