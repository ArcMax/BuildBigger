package com.udacity.gradle.builditbigger.test;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by archana on 2/4/2016.
 */
public class EndpointAsyncTaskTest extends AndroidTestCase {

    private final CountDownLatch mSignal = new CountDownLatch(1);

    public void testJokeRetriever() {
        new EndpointsAsyncTask(new TestJokeListener()).execute();
        try {
            boolean success = mSignal.await(5, TimeUnit.SECONDS);
            if (!success) {
                fail("Test timed out, make sure the server is actually running.");
            }
        } catch (InterruptedException e) {
            fail();
        }
    }

    private class TestJokeListener implements EndpointsAsyncTask.IJokeListener {

        @Override
        public void iJokeListener(String joke) {
            assertTrue(joke != null && joke.length() > 0);
            mSignal.countDown();
        }
    }
}
