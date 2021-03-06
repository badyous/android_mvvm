package io.digiteam.mvvm.repository.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Global executor pools for the whole application.
 *
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 */
@Singleton
public class AppExecutors {

    private static final int THREAD_COUNT = 3;

    private final Executor diskIO;
    private final Executor networkIO;
    private final Executor mainThread;


    public AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread){
        this.diskIO =  diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    @Inject
    public AppExecutors(){
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(THREAD_COUNT), new MainThreadExecutor());
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {

        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
