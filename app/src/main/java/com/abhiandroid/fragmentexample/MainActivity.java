    package com.abhiandroid.fragmentexample;


    import android.os.Bundle;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;

    import com.abhiandroid.fragmentexample.Fragments.BlankFragment;
    import com.abhiandroid.fragmentexample.Fragments.FirstFragment;
    import com.abhiandroid.fragmentexample.Fragments.ItemListDialogFragment;
    import com.abhiandroid.fragmentexample.Fragments.ModalBottomSheetFragment;
    import com.abhiandroid.fragmentexample.Fragments.SecondFragment;
    import com.abhiandroid.fragmentexample.interfaces.ButtonClickListener;

    public class MainActivity extends AppCompatActivity implements ButtonClickListener {

        Button firstFragment, secondFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // get the reference of Button's
            firstFragment = (Button) findViewById(R.id.firstFragment);
            secondFragment = (Button) findViewById(R.id.secondFragment);

            // perform setOnClickListener event on First Button
            firstFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // load First Fragment
                    loadFragment(new FirstFragment());
                }
            });
            // perform setOnClickListener event on Second Button
            secondFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // load Second Fragment
                    //loadFragment(new SecondFragment());
                    loadFragment(ItemListDialogFragment.newInstance(20));
                    ModalBottomSheetFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
                }
            });

        }

        private void loadFragment(Fragment fragment) {
            // create a FragmentManager
            FragmentManager fm=getSupportFragmentManager();
           // FragmentManager fm = getFragmentManager();
            // create a FragmentTransaction to begin the transaction and replace the Fragment
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            // replace the FrameLayout with new Fragment
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit(); // save the changes
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

        @Override
        public void onButtonClick(String message) {
            Log.d("Message",message);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
