package samples.android.appassembla.com.fragmenttestingsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

/**
 * Created by richard.thompson on 05/12/2014.
 */
public class HelloWorldExampleActivity2Test extends ActivityUnitTestCase<HelloWorldExampleActivity2> {

    public HelloWorldExampleActivity2Test() {
        super(HelloWorldExampleActivity2.class);
    }

    private HelloWorldExampleActivity2 activity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(),
                HelloWorldExampleActivity2.class), null, null);
        activity = getActivity();
    }

    /**
     * Adds the fragment to a the activity, thereby fully initializing its view.
     */
    private void startFragment(Fragment fragment) {
        FragmentManager manager = activity.getSupportFragmentManager();
        manager.beginTransaction().add(fragment, null).commit();
        manager.executePendingTransactions();
    }

    public void testSimpleFragment() {
        SimpleFragment2 fragment = new SimpleFragment2();
        startFragment(fragment);

        assertNotNull(fragment.getView());
    }
}
