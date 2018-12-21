package com.android.dcxiaolou.voiceandvideocall.Common;

import android.app.Application;

import com.android.dcxiaolou.voiceandvideocall.GroupVideoCall.openvcall.model.VideoCurrentUserSettings;
import com.android.dcxiaolou.voiceandvideocall.GroupVideoCall.openvcall.model.VideoWorkerThread;
import com.android.dcxiaolou.voiceandvideocall.GroupVoiceCall.openacall.model.VoiceCurrentUserSettings;
import com.android.dcxiaolou.voiceandvideocall.GroupVoiceCall.openacall.model.VoiceWorkerThread;

public class AGApplication extends Application {

    private VoiceWorkerThread mVoiceWorkerThread;
    private VideoWorkerThread mVideoWorkerThread;

    public synchronized void initWorkerThread(int type) {
        if (mVoiceWorkerThread == null && type == 1) {
            mVoiceWorkerThread = new VoiceWorkerThread(getApplicationContext());
            mVoiceWorkerThread.start();

            mVoiceWorkerThread.waitForReady();
        } else if (mVideoWorkerThread == null && type == 2) {
            mVideoWorkerThread = new VideoWorkerThread(getApplicationContext());
            mVideoWorkerThread.start();

            mVideoWorkerThread.waitForReady();
        }
    }

    public synchronized VoiceWorkerThread getVoiceWorkerThread() {
        return mVoiceWorkerThread;
    }

    public synchronized VideoWorkerThread getVideoWorkerThread() {
        return mVideoWorkerThread;
    }

    public synchronized void deInitWorkerThread(int type) {
        if (type == 1) {
            mVoiceWorkerThread.exit();
            try {
                mVoiceWorkerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mVoiceWorkerThread = null;
        } else {
            mVideoWorkerThread.exit();
            try {
                mVideoWorkerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mVideoWorkerThread = null;
        }

    }

    public static final VoiceCurrentUserSettings mAudioSettings = new VoiceCurrentUserSettings();
    public static final VideoCurrentUserSettings mVideoSettings = new VideoCurrentUserSettings();

}
