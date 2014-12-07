package samples.android.appassembla.com.fragmenttestingsample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

/**
 * Created by richard.thompson on 05/12/2014.
 */
public class HelloWorldExampleActivityTest extends ActivityUnitTestCase<HelloWorldExampleActivity> {

    public HelloWorldExampleActivityTest() {
        super(HelloWorldExampleActivity.class);
    }

    private HelloWorldExampleActivity activity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(),
                HelloWorldExampleActivity.class), null, null);
        activity = getActivity();
    }

    /**
     * Adds the fragment to a the activity, thereby fully initializing its view.
     */
    private void startFragment(Fragment fragment) {
        FragmentManager manager = activity.getFragmentManager();
        manager.beginTransaction().add(fragment, null).commit();
        manager.executePendingTransactions();
    }

    public void testSimpleFragment() {
        SimpleFragment fragment = new SimpleFragment();
        startFragment(fragment);

        assertNotNull(fragment.getView());
    }
}
